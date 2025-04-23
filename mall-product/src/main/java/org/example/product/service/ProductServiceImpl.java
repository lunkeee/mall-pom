package org.example.product.service;

import lombok.extern.slf4j.Slf4j;
import org.example.common.utils.R;
import org.example.common.utils.RedisUtil;
import org.example.product.mapper.ProductCategoryMapper;
import org.example.product.mapper.ProductSKUMapper;
import org.example.product.mapper.ProductSPUMapper;
import org.example.product.modules.DO.ProductSPU;
import org.example.product.modules.Request.ProductListRequest;
import org.example.product.modules.Response.ProductCategoryResponse;
import org.example.product.modules.Response.ProductResponse;
import org.example.product.modules.Response.ProductSPUResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private ProductSKUMapper productSKUMapper;

    @Resource
    private ProductSPUMapper productSPUMapper;

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public R<ProductSPU> findSPUById(Long id) {

        Thread currentThread = Thread.currentThread();

        // 如果缓存有数据，直接返回

        // 没有缓存，从数据库查询

        return null;
    }

    @Override
    public List<ProductSPUResponse> getProductSPUs(ProductListRequest qry) {

        // 从数据库查询
        List<ProductSPU> productSPUs = productSPUMapper.getProductSPUs(qry);

        return Collections.emptyList();
    }

    @Override
    public ProductResponse getProductSPUById(int id) {
        return null;
    }


    @Override
    public void testRedis(String name) {
        redisUtil.set("name", name);
    }

    @Override
    public List<ProductCategoryResponse> getCategoryList() {
        return productCategoryMapper.getCategoryList();
    }
}