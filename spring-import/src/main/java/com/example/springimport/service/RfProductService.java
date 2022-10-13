package com.example.springimport.service;

import com.example.springimport.model.RfProduct;
import com.example.springimport.util.Result;
import com.example.springimport.vo.RfServiceExcel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * @author: liulq
 * @date: 2022/9/30
 */
public interface RfProductService {

    Result<List<RfProduct>> findPage(RfProduct rfProduct);

    Result importProduct(MultipartFile multipartFile);

    Result<Boolean> importExcels(List<RfServiceExcel> rfServiceExcelData);

    Result importExcel(List<RfServiceExcel> all);
}
