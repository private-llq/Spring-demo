package com.example.springimport.service.Impl;

import com.example.springimport.mapper.RfPodMapper;
import com.example.springimport.model.RfProduct;
import com.example.springimport.service.RfProductService;
import com.example.springimport.util.Result;
import com.example.springimport.vo.RfServiceExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class RfProductServiceImpl implements RfProductService {


    @Autowired
    private RfPodMapper rfProductervice;

    @Autowired
    private  RfPodMapper rfPodMapper;

    @Override
    public Result<List<RfProduct>> findPage(RfProduct rfProduct) {
//        Weekend<RfProduct> weekend = new Weekend<>(RfProduct.class);
//        WeekendCriteria<RfProduct, Object> weekendCriteria = weekend.weekendCriteria();
//        weekendCriteria.andEqualTo(RfProduct::getFlag, 1);
//        if (rfProduct.getCategory() != null) {
//            weekendCriteria.andEqualTo(RfProduct::getCategory, rfProduct.getCategory());
//        }
        List<RfProduct> rfProducts = rfPodMapper.selectAll();
//      PageInfo<RfProduct> pageInfo = super.pageInfo(weekend, rfProduct.getPageNum(), rfProduct.getPageSize()).getData();
        return Result.success(rfProducts);
    }

    @Override
    public Result importProduct(MultipartFile multipartFile) {



    return Result.success();
    }

    @Override
    public Result<Boolean> importExcels(List<RfServiceExcel> rfServiceExcelData) {
        List<RfProduct> list = new ArrayList<>();
        BeanUtils.copyProperties(rfServiceExcelData, list);
        for (RfProduct rfService : list) {
            rfService.setId(Long.valueOf(UUID.randomUUID().toString()));
            rfService.setFlag(1);
        }
        for (RfProduct rfProduct:list){
            rfPodMapper.insert(rfProduct);
        }
        return Result.success(true);
    }

    @Override
    public Result importExcel(List<RfServiceExcel> all) {


     return Result.success();
    }
}