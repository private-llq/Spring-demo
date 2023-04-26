package com.spring.demo.easyexceldemo.controller;
import com.spring.demo.easyexceldemo.service.EmployeeService;
import com.spring.demo.easyexceldemo.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api(tags = "excel操作")
@RestController
@RequestMapping(value = "/employee/excel")
public class EmployeeExcelController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "初始化数据")
    @GetMapping("/initData")
    public ResultVo initData(){
        employeeService.initData();
        return ResultVo.success();
    }

    @ApiOperation(value = "导入")
    @PostMapping(value="/import")
    public ResultVo importExcel(@RequestParam(name = "file") MultipartFile file) throws IOException {
        employeeService.importExcel(file);
        return ResultVo.successMsg("导入成功");
    }

    @ApiOperation(value = "导出")
    @PostMapping(value = "/export")
    public void exportExcel(HttpServletResponse response) throws IOException {
        employeeService.exportExcel(response);
    }

    @ApiOperation(value = "填充模板式导出")
    @PostMapping(value = "/fill")
    public void fillExcel(HttpServletResponse response) throws IOException {
        employeeService.fillExcel(response);
    }
}
