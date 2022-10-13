package com.example.springimport.service;

import com.example.springimport.model.RfService;
import com.example.springimport.util.Result;
import com.example.springimport.vo.RfServiceExcel;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 杜飘
 * @date 2022/9/29
 */
public interface RfServiceService {

    /**
     * 分页查询
     *
     * @param rfService RfService
     * @return Result<PageInfo < RfService>>
     */
    Result<PageInfo<RfService>> selectPage(RfService rfService);

    /**
     * 导入数据
     *
     * @param  rfServiceExcelData List<RfServiceExcel>
     * @return Result<Boolean>
     */
    Result<Boolean> importExcel(List<RfServiceExcel> rfServiceExcelData);
}
