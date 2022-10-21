package com.example.springmybatisplus.service.impl;

import com.example.springmybatisplus.model.Category;
import com.example.springmybatisplus.dao.CategoryMapper;
import com.example.springmybatisplus.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lucas
 * @since 2022-10-21
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
