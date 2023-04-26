package com.spring.demo.easyexceldemo.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface EmployeeService {

    void initData();

    void importExcel(MultipartFile file) throws IOException;

    void exportExcel(HttpServletResponse response) throws IOException;

    void fillExcel(HttpServletResponse response)throws IOException;;
}
