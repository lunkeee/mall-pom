package org.example.product.service;

import lombok.extern.slf4j.Slf4j;
import org.example.common.utils.R;
import org.example.product.mapper.ProductSKUMapper;
import org.example.product.mapper.ProductSPUMapper;
import org.example.product.modules.DO.ProductSPU;
import org.example.product.modules.Response.ProductSKUResponse;
import org.example.product.modules.Response.ProductSPUResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductSKUMapper productSKUMapper;

    @Resource
    private ProductSPUMapper productSPUMapper;

    @Override
    public R<ProductSPU> findSPUById(Long id) {

        // 如果缓存有数据，直接返回

        // 没有缓存，从数据库查询

        return null;
    }

    @Override
    public List<ProductSPUResponse> getProductSPUs(ProductSKUResponse qry) {
        return Collections.emptyList();
    }

    @Override
    public List<ProductSKUResponse> getProductSKUs(ProductSKUResponse qry) {
        return Collections.emptyList();
    }
}