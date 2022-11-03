package com.example.springmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springmybatisplus.model.Category;
import com.example.springmybatisplus.service.ICategoryService;
import com.example.springmybatisplus.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package com.example.springmybatisplus
 * @date 2022/11/3 23:17
 * @Copyright 公司
 */
@SpringBootTest
public class mybatisplus {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    /**
     * 查询所有
     */
    @Test
    void contextLoads() {
        List<Category> list = categoryServiceImpl.list();
        System.out.println("查询所有"+list);
    }

    /**
     * 新增
     */
    @Test
    void add() {
        Category category = new Category();
        category.setCategoryName("张三");
        category.setCategoryLevel(3);
        category.setParentId(1);
        category.setCategoryIcon("张三");
        category.setCategorySlogan("张三");
        category.setCategoryPic("张三");
        category.setCategoryBgColor("颜色");
        boolean save = categoryServiceImpl.save(category);
        if (save){
            System.out.println("新增成功"+true);
        }
    }

    /**
     * 根据id删除
     */
    @Test
    void delete() {
        boolean b = categoryServiceImpl.removeById(1);
        if (b) {
            System.out.println("删除成功" + b);
        }
    }

    /**
     * 全量更新
     */
    @Test
    void update() {
        Category category = categoryServiceImpl.getById(2);
        category.setCategoryName("刘良琪");
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id",2);
        categoryServiceImpl.update(category,wrapper);
    }


    /**
     * 分页查询
     */
    @Test
    void page() {
        int pageNum =1;
        int pageSize = 2;
        Page<Category> page = new Page<>(pageNum, pageSize);
        // 条件构造
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select();
        IPage iPage = categoryServiceImpl.pageMaps(page, wrapper);
        System.out.println(iPage.getRecords());
    }



}
