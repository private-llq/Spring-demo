package com.spring.demo.easyexceldemo.mapper;

import com.spring.demo.easyexceldemo.entity.EmployeeExporter;
import com.spring.demo.easyexceldemo.mapper.basemapper.BaseDaoMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author lijin
 * @version 1.0
 * @date 2022/7/13 13:12
 */
@Mapper
public interface EmployeeExporterMapper extends BaseDaoMapper<EmployeeExporter> {

}
