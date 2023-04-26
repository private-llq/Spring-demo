package com.spring.demo.easyexceldemo.test;/*
package com.example.easyexcel.test;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;

import cn.hutool.db.handler.HandleHelper;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.alibaba.excel.write.style.row.SimpleRowHeightStyleStrategy;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.basics.log.annotation.Log;
import com.basics.utils.R;
import com.hare.file.api.FileApi;
import com.hare.tawl.dto.*;

import com.hare.tawl.entity.*;
import com.hare.tawl.enums.*;
import com.hare.tawl.exception.ReturnMsgException;
import com.hare.tawl.mapper.TawlFileMapper;
import com.hare.tawl.mapper.TawlLoanApplyMapper;
import com.hare.tawl.lang.Money;
import com.hare.tawl.mapper.*;
import com.hare.tawl.service.*;


import com.hare.tawl.util.*;
import com.hare.tawl.vo.TawlLoanApplyVO;
import com.hare.tawl.vo.TawlQuyerRejectVO;
import com.hare.tawl.vo.*;
import com.hare.tawl.vo.export.EqualBookRoEqualExPortVO;
import com.hare.tawl.vo.export.TawlPlanRepaymentExPortVO;
import com.hare.tawl.vo.export.TawlRepaymentScheduleBodyExPortVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

*
 * 放款申请表
 *
 * @author auto
 * @note 需要注意，该类为自动生成，需结合真实业务进行修改


@Api(tags = "放款申请表")
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/tawl_loan_apply")
public class TawlLoanApplyController {

    private WriteCellStyle getContentWriteCellStyle(){
        //内容样式策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //垂直居中,水平居中
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
        contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
        contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
        //设置 自动换行
        contentWriteCellStyle.setWrapped(true);
        // 字体策略
        WriteFont contentWriteFont = new WriteFont();
        // 字体大小
        contentWriteFont.setFontHeightInPoints((short) 12);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        return contentWriteCellStyle;
    }


    private WriteCellStyle getHeadWriteCellStyle(){
        //头策略使用默认 设置字体大小
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 14);
        headWriteCellStyle.setWriteFont(headWriteFont);
        return headWriteCellStyle;

    }

    @ApiOperation("还款计划表导出2.0版本")
    @RequestMapping("tawlLoanApplyExportTwo")
    public void tawlLoanApplyExportTwo(@RequestParam("tawlLoanApplyId") Long tawlLoanApplyId ,HttpServletResponse response ) throws IOException {

        ArrayList<Object> rightList = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(rightList)){
            ExcelWriter excelWriter = null;
            try {
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                response.setCharacterEncoding("utf-8");
                String fileName = URLEncoder.encode("还款计划表", "UTF-8").replaceAll("\\+", "%20");
                response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

                // TODO: 2022/7/15 注册样式
                excelWriter = EasyExcel.write(response.getOutputStream())     //注册头样式             //注册内容样式
                        .registerWriteHandler(new HorizontalCellStyleStrategy(getHeadWriteCellStyle(),getContentWriteCellStyle())

                ).build();
                //右侧

                for (int i = 0; i <rightList.size(); i++) {//还款计划表数量循环

                    List<TawlPlanRepaymentExPortVO> tawlPlanRepaymentVOS = rightList.get(i).getTawlPlanRepaymentVOS();//期次里面的list数据

                    Integer number = rightList.size();
                    String sheetName="还款计划表("+number+"期)";
                    //左侧对应期数数据
                    EqualBookRoEqualExPortVO equalBookExPortVO = new EqualBookRoEqualExPortVO();
                    for (EqualBookRoEqualExPortVO equalBookRoEqualExPortVO : leftList) {
                        String contractPeriod = equalBookRoEqualExPortVO.getContractPeriod();//期次全称
                        boolean b = contractPeriod.contains("期");
                        if(!b){
                            contractPeriod = contractPeriod+"期";
                        }
                        if (StringUtils.isEmpty(contractPeriod)){
                            throw new RuntimeException("期次参数错误！");
                        }
                        String contractPeriodNumber = contractPeriod.substring(0, contractPeriod.indexOf("期"));
                        for (TawlPlanRepaymentExPortVO tawlPlanRepaymentVO : tawlPlanRepaymentVOS) {
                            if (contractPeriod.equals(tawlPlanRepaymentVO.getContractPeriod())){
                                sheetName="还款计划表--"+contractPeriod;
                                BeanUtils.copyProperties(equalBookRoEqualExPortVO,equalBookExPortVO);
                            }
                        }
                        if (number.toString().equals(contractPeriodNumber)){//获取期数相等的左侧小表
                            BeanUtils.copyProperties(equalBookRoEqualExPortVO,equalBookExPortVO);
                        }
                    }

                    // TODO: 2022/7/15 同一个sheetName 名字 sheet页会重复输出数据到这一页                                                           //sheet注册自动列宽
                    WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).registerWriteHandler(new SimpleColumnWidthStyleStrategy(20)).needHead(Boolean.FALSE).build();


                    // TODO: 2022/7/15 循环生成表格 
                    //指定右表
                    WriteTable writeTable = EasyExcel.writerTable(i).head(TawlPlanRepaymentExPortVO.class).needHead(Boolean.TRUE).build();


                    // TODO: 2022/7/15 可自定义put数据输出到sheet页,data1 表示一行记录，指定了这行数据里面的2列的值
                    //put左侧数据值
                    List<List<Object>> datalist = new ArrayList<>();//总共6条数据
                    List<Object> data1 = new ArrayList<>();//行
                    data1.add("放款金额");//列
                    data1.add(equalBookExPortVO.getLoanAmount()+"   ");//列
                    List<Object> data2 = new ArrayList<>();
                    data2.add("放款日");
                    data2.add(equalBookExPortVO.getDisbursementDate());
                    List<Object> data3 = new ArrayList<>();
                    data3.add("融资期限");
                    String financingTerm =sheetName.substring(sheetName.indexOf("期"), sheetName.length());
                    data3.add(equalBookExPortVO.getFinancingTerm()+financingTerm);
                    List<Object> data4 = new ArrayList<>();
                    data4.add("还款期数");
                    data4.add(equalBookExPortVO.getRepaymentNumber());
                    List<Object> data5 = new ArrayList<>();
                    data5.add("年利率");
                    data5.add(equalBookExPortVO.getAnnualInterestRate());
                    List<Object> data6 = new ArrayList<>();
                    data6.add("期利率");
                    data6.add(equalBookExPortVO.getInterestPerPeriod());
                    datalist.add(data1);
                    datalist.add(data2);
                    datalist.add(data3);
                    datalist.add(data4);
                    datalist.add(data5);
                    datalist.add(data6);


                    //循环输出左侧数据
                    excelWriter.write(datalist,writeSheet);


                    //循环输出右侧数据
                    excelWriter.write(rightList.get(i).getTawlPlanRepaymentVOS(), writeSheet, writeTable);

                }

            }catch (IOException e){
                response.reset();
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                Map<String, String> map = new HashMap<>();
                map.put("status", "failure");
                map.put("message", "下载文件失败" + e.getMessage());
                response.getWriter().println(JSON.toJSONString(map));
            }finally {
                if (excelWriter != null) {
                    excelWriter.finish();
                }
            }
        }

    }


}

*/
