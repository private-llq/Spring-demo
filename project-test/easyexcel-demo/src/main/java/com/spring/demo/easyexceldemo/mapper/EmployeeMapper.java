package com.spring.demo.easyexceldemo.mapper;

import com.spring.demo.easyexceldemo.entity.Employee;
import com.spring.demo.easyexceldemo.mapper.basemapper.BaseDaoMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper extends BaseDaoMapper<Employee> {

    /**
     * 批量插入
     * @param employees 员工表
     */
    void batchInsert(List<Employee> employees);
}
