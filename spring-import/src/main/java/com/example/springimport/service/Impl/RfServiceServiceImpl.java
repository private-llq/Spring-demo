package com.example.springimport.service.Impl;


import com.example.springimport.mapper.RfServiceMapper;
import com.example.springimport.model.RfService;
import com.example.springimport.service.RfServiceService;
import com.example.springimport.util.ObjectMapper;
import com.example.springimport.util.Result;
import com.example.springimport.vo.RfServiceExcel;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

/**
 * @author 杜飘
 * @date 2022/9/29
 */
@Service
public class RfServiceServiceImpl implements RfServiceService {


    @Autowired
    private RfServiceMapper rfServiceMapper;
    /**
     * 分页查询
     *
     * @param rfService RfService
     * @return Result<PageInfo < RfService>>
     */
    @Override
    public Result<PageInfo<RfService>> selectPage(RfService rfService) {
        Weekend<RfService> weekend = new Weekend<>(RfService.class);
        WeekendCriteria<RfService, Object> weekendCriteria = weekend.weekendCriteria();
        //添加默认查询条件
        weekendCriteria.andEqualTo(RfService::getFlag, 1);
        //添加分类查询条件
        if (rfService.getCategory() != null) {
            weekendCriteria.andEqualTo(RfService::getCategory, rfService.getCategory());
        }
//        PageInfo<RfService> pageInfo = super.selectPage(weekend, rfService.getPageNum(), rfService.getPageSize()).getData();
        return Result.success();
    }

    /**
     * 导入数据
     *
     * @param rfServiceExcelData List<RfServiceExcel>
     * @return Result<Boolean>
     */
    @Override
    public Result importExcel(List<RfServiceExcel> rfServiceExcelData) {
        List<RfService> list = ObjectMapper.clone(rfServiceExcelData, RfService.class);
        for (RfService rfService : list) {
            rfService.setId(1L);
            rfService.setFlag(1);
            rfServiceMapper.insert(rfService);
        }
        return Result.success();
    }
}
