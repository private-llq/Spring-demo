package com.example.springmybatisplus2.service.impl;

import com.example.springmybatisplus2.model.Category;
import com.example.springmybatisplus2.dao.CategoryMapper;
import com.example.springmybatisplus2.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author llq
 * @since 2023-12-17
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
