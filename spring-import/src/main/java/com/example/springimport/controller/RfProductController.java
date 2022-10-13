package com.example.springimport.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.example.springimport.model.RfProduct;
import com.example.springimport.service.RfProductService;
import com.example.springimport.service.RfServiceService;
import com.example.springimport.util.FileCheckUtil;
import com.example.springimport.util.Result;
import com.example.springimport.vo.RfServiceExcel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author liuliangqi
 * @description: 产品管理
 * @date 2022/9/30
 */
@RestController
@RequestMapping("/api/vi/fosefinch/product")
@Slf4j
@Api(tags = "产品管理")
public class RfProductController {

    /**
     * Excel标题行
     */
    private final static List<String> EXCEL_HEADER_Alias = Arrays.asList("序号", "产品类型", "产品名称", "产品编码", "版本号", "Logo", "产品简介", "产品介绍", "产品截图", "产品发布时间", "镜像名称、版本号", "关联产品及版本号");

    /**
     * Excel文件大小，单位M
     */
    @ExcelIgnore
    private final static double EXCEL_SIZE = 10.0;

    /**
     * Excel文件后缀
     */
    private final static List<String> EXCEL_SUFFIX = Arrays.asList("xls", "xlsx");
    @Autowired
    private RfProductService productService;
    @Autowired
    private RfServiceService serviceService;

    /**
     * 产品管理分页查询
     * @param rfProduct
     * @return Result
     */
    @ApiOperation(value = "分页查询",notes = "产品管理分页查询",httpMethod = "PSOT")
    @PostMapping("/page")
    public Result<List<RfProduct>> findPage(@RequestBody RfProduct rfProduct){
        log.info("产品参数{}",rfProduct);
        List<RfProduct> product = productService.findPage(rfProduct).getData();
        return Result.success(product);
    }

    /**
     * 批量导入excel
     * @param multipartFile
     * @return Result
     */
    @ApiOperation(value = "导入excel",notes = "批量导入excel",httpMethod = "POST")
    @PostMapping("/import")
    public Result  importProduct(@RequestParam("file")MultipartFile multipartFile) {
        if (multipartFile ==null){
            return new Result<>(903, "文件为空");
        }
        //检查Excel文件大小
        if (!FileCheckUtil.checkSize(multipartFile, EXCEL_SIZE, "M")) {
            return new Result<>(901, "文件超过最大限制" + EXCEL_SIZE + "M");
        }
        //检查Excel文件后缀
        if (!FileCheckUtil.checkSuffix(multipartFile, EXCEL_SUFFIX)) {
            return new Result<>(902, "导入文件格式出错");
        }
//        try {
//            //读取Excel数据
//
//        
        return Result.success();
   }


    @ApiOperation(value = "导入数据", notes = "待开发中")
    @PostMapping("/import/excel")
    public Result importData(@RequestParam(value = "file") MultipartFile multipartFile) {
        //检查Excel文件大小
        if (!FileCheckUtil.checkSize(multipartFile, EXCEL_SIZE, "M")) {
            return new Result<>(901, "文件超过最大限制" + EXCEL_SIZE + "M");
        }
        //检查Excel文件后缀
        if (!FileCheckUtil.checkSuffix(multipartFile, EXCEL_SUFFIX)) {
            return new Result<>(902, "导入文件格式出错");
        }
        //读取Excel数据
        try {
            ExcelReader reader = ExcelUtil.getReader(multipartFile.getInputStream());
            //设置标题行别名
            Map<String, String> headerAlias = new HashMap<>(11);
            headerAlias.put("序号", "number");
            headerAlias.put("产品类型", "category");
            headerAlias.put("产品名称", "name");
            headerAlias.put("产品编码", "type");
            headerAlias.put("版本号", "version");
            headerAlias.put("Logo", "logoFileId");
            headerAlias.put("产品简介", "introduction");
            headerAlias.put("产品介绍", "description");
            headerAlias.put("产品发布时间", "releaseTime");
            headerAlias.put("授权代码", "authCode");
            headerAlias.put("镜像名称、版本号", "image");
            reader.setHeaderAlias(headerAlias);


            //读取Excel数据
            List<RfServiceExcel> all = reader.readAll(RfServiceExcel.class);
            if (all.isEmpty()) {
                return new Result<>(903, "请导入数据");
            }
            return serviceService.importExcel(all);
        } catch (IOException e) {
            log.error("读取Excel出错，异常信息：{}", e.getMessage());
        }
        return Result.success("测试");
    }
}
