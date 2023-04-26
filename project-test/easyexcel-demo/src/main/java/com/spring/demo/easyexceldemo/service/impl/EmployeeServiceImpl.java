package com.spring.demo.easyexceldemo.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.util.MapUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.row.SimpleRowHeightStyleStrategy;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.demo.easyexceldemo.entity.Employee;
import com.spring.demo.easyexceldemo.entity.EmployeeExporter;
import com.spring.demo.easyexceldemo.entity.EmployeeImport;
import com.spring.demo.easyexceldemo.listener.ExportListener;
import com.spring.demo.easyexceldemo.listener.ImportListener;
import com.spring.demo.easyexceldemo.mapper.EmployeeExporterMapper;
import com.spring.demo.easyexceldemo.mapper.EmployeeImportMapper;
import com.spring.demo.easyexceldemo.mapper.EmployeeMapper;
import com.spring.demo.easyexceldemo.service.EmployeeService;
import com.spring.demo.easyexceldemo.utils.ExcelResponseHeaderUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeExporterMapper employeeExporterMapper;

    @Autowired
    private EmployeeImportMapper employeeImportMapper;

    @Override
    public void initData() {
        long beforeTime = System.currentTimeMillis();
        List<Employee> employees = new ArrayList<Employee>();
        for (int i = 0; i < 50; i++) {
            Employee employee = new Employee();
            employee.setUserName(getRandomName());
            employee.setGender(getRandomGender());
            employee.setAge(getRandomAge());
            employee.setMaritalStatus(getRandomGender());
            employee.setEducation(getRandomEducation());
            employee.setMobile("18866998888");
            employee.setDepartmentName(getRandomDP());
            employee.setNationalArea("中国");
            employee.setCity("深圳");
            employees.add(employee);
            if(employees.size() % 1000 == 0){
                employeeMapper.batchInsert(employees);
                employees.clear();
            }
        }
        long afterTime = System.currentTimeMillis();
        log.info("耗时:{}", afterTime - beforeTime/1000+"s");
    }

    @Override
    public void importExcel(MultipartFile file) throws IOException {

        long beforeTime = System.currentTimeMillis();
        EasyExcel.read(file.getInputStream(),
                EmployeeImport.class,
                new ImportListener(employeeImportMapper)).sheet().headRowNumber(1).doRead();
        long afterTime = System.currentTimeMillis();
        log.info("耗时:{}", (afterTime - beforeTime)/1000+"s");
    }

    @Override
    public void exportExcel(HttpServletResponse response) throws IOException {

        ServletRequestAttributes servletRequestAttributes =  (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response2 = servletRequestAttributes.getResponse();
        long beforeTime = System.currentTimeMillis();

        QueryWrapper<EmployeeExporter> queryWrapper = new QueryWrapper();
        queryWrapper.gt("age", 20);
        queryWrapper.between("education", "0", "3");

        new ExportListener<>(employeeExporterMapper).
                exportExcel(response2, "员工信息", EmployeeExporter.class,
                        queryWrapper);


        long afterTime = System.currentTimeMillis();
        log.info("耗时:{}", (afterTime - beforeTime)/1000+"s");
    }

    @Override
    public void fillExcel(HttpServletResponse response) throws IOException {
        Map<String, Object> mapData = new HashMap<>();
        mapData.put("nowTime", LocalDateTime.now().toString());
        List<EmployeeExporter> list = employeeExporterMapper.selectList(null);
        try {
            ExcelResponseHeaderUtil.setResponseHeader(response,"员工信息表格数据导出");
            ClassPathResource fileTemplate = new ClassPathResource("templates/员工信息模板.xlsx");
            // 创建输出的excel对象
             ExcelWriter write = EasyExcel.write(response.getOutputStream(),EmployeeExporter.class).withTemplate(fileTemplate.getInputStream()).excelType(ExcelTypeEnum.XLSX).build();

            Workbook workbook = write.writeContext().writeWorkbookHolder().getWorkbook();
           //设置强制计算公式：不然公式会以字符串的形式显示在excel中
            workbook.setForceFormulaRecalculation(true);

            // 创建第一个sheel页
             WriteSheet sheet1 = EasyExcel.writerSheet(0)/*.registerWriteHandler(new SimpleRowHeightStyleStrategy(null,(short)25))*/.build();//可在sheet进行合并，样式操作
            // 创建第二个sheel页
             WriteSheet sheet2 = EasyExcel.writerSheet(1).build();

             //往第一个sheet页填充数据
            write.fill(list, sheet1);
            mapData.put("nowTime", LocalDateTime.now().toString());
            write.fill(mapData, sheet1);

            //往第二个sheet页填充数据，需要注意如果模板没有这个sheet页填充数据会报错
            write.fill(list, sheet2);
            mapData.put("nowTime", LocalDateTime.now().toString());
            write.fill(mapData, sheet2);
            // 关闭流
            write.finish();
        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = MapUtils.newHashMap();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(JSON.toJSONString(map));
        }

    }

    /**
     * 随机取名字
     * @return
     */
    public String getRandomName(){
        String[] doc = {"朝歌晚酒", "都怪时光太动听", "笑我孤陋", "水墨青花","时光清浅", "草帽撸夫", "江山如画",
        "热度不够", "盏茶浅抿", "把酒临风", "且听风吟", "梦忆笙歌", "倾城月下", "清风墨竹", "自愈心暖", "几许轻唱",
        "平凡之路", "半夏倾城", "南栀倾寒", "孤君独战", "温酒杯暖", "眉目亦如画", "旧雪烹茶", "律断华章", "清酒暖风",
        "清羽墨安", "一夕夙愿", "南顾春衫", "和云相伴", "夕颜若雪", "时城旧巷", "梦屿千寻"};
        int index = (int) (Math.random() * doc.length);
        return doc[index];
    }

    /**
     * 性别随机
     * @return
     */
    public String getRandomGender(){
        String[] doc = {"0", "1"};
        int index = (int) (Math.random() * doc.length);
        return doc[index];
    }

    /**
     * 年龄随机
     * @return
     */
    public int getRandomAge(){
        int[] doc = {16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        int index = (int) (Math.random() * doc.length);
        return doc[index];
    }

    public String getRandomEducation(){
        String[] doc = {"0", "1", "2", "3"};
        int index = (int) (Math.random() * doc.length);
        return doc[index];
    }

    public String getRandomDP(){
        String[] doc = {"行政部", "财务部", "技术部", "市场部", "公关部"};
        int index = (int) (Math.random() * doc.length);
        return doc[index];
    }
}
