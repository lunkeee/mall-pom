package org.example.product.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.product.mapper.ProductSPUMapper;
import org.example.product.modules.DO.ProductSPU;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Slf4j
@Repository
public class ProductSPUDaoImpl extends ServiceImpl<ProductSPUMapper, ProductSPU> implements ProductSPUDao {
    @Resource
    private ProductSPUMapper productSPUMapper;

}