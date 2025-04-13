package org.example.product.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.product.mapper.ProductCategoryMapper;
import org.example.product.modules.DO.ProductCategory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Slf4j
@Repository
public class ProductCategoryDaoImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryDao {
    @Resource
    private ProductCategoryMapper productCategoryMapper;

}