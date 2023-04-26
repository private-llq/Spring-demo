package com.spring.demo.easyexceldemo.mapper;

import com.spring.demo.easyexceldemo.entity.EmployeeImport;
import com.spring.demo.easyexceldemo.mapper.basemapper.BaseDaoMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author lijin
 * @version 1.0
 * @date 2022/7/13 13:53
 */
@Mapper
public interface EmployeeImportMapper extends BaseDaoMapper<EmployeeImport> {
    void batchInsert(List<EmployeeImport> employees);

}
