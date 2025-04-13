package org.example.product.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.product.mapper.ProductSKUMapper;
import org.example.product.modules.DO.ProductSKU;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Slf4j
@Repository
public class ProductSKUDaoImpl extends ServiceImpl<ProductSKUMapper, ProductSKU> implements ProductSKUDao {
    @Resource
    private ProductSKUMapper productSKUMapper;

}