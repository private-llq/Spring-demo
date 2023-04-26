package com.spring.demo.easyexceldemo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.spring.demo.easyexceldemo.mapper.basemapper.BaseDaoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ImportListener<T> implements ReadListener<T> {

    private final BaseDaoMapper baseDaoMapper;

    /**
     * 每隔100条存储数据库，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    /**
     * 缓存的数据
     */
    private List<T> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    private final AtomicInteger count = new AtomicInteger(0);

    public ImportListener(BaseDaoMapper baseDaoMapper) {
        this.baseDaoMapper = baseDaoMapper;
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) {
        log.error("解析失败，但是继续解析下一行:{}", exception.getMessage());
        // 如果是某一个单元格的转换异常 能获取到具体行号
        // 如果要获取头的信息 配合invokeHeadMap使用
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException excelDataConvertException = (ExcelDataConvertException)exception;
            log.error("第{}行，第{}列解析异常，数据为:{}", excelDataConvertException.getRowIndex(),
                    excelDataConvertException.getColumnIndex(), excelDataConvertException.getCellData());
        }
    }

    @Override
    public void invoke(T entity, AnalysisContext analysisContext) {
        count.addAndGet(1);

        log.info("解析到一条数据:{}", JSON.toJSONString(entity));
        cachedDataList.add(entity);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            batchInsert();
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        batchInsert();
        log.info("所有数据解析完成！");
    }

    @Async
    public void batchInsert() {
        log.info("{}条数据，开始存储数据库!", count.get());
        baseDaoMapper.batchInsert(cachedDataList);
        log.info("存储数据库成功!");
    }
}
