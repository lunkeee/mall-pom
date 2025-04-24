package org.example.product.service;

import lombok.extern.slf4j.Slf4j;
import org.example.common.utils.RedisUtil;
import org.example.product.mapper.ProductCategoryMapper;
import org.example.product.mapper.ProductSKUMapper;
import org.example.product.mapper.ProductSPUMapper;
import org.example.product.modules.Request.ProductListRequest;
import org.example.product.modules.Response.ProductCategoryResponse;
import org.example.product.modules.Response.ProductResponse;
import org.example.product.modules.Response.ProductSPUResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

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
    public List<ProductSPUResponse> getProductSPUs(ProductListRequest qry) {

        // 从数据库查询
        List<ProductSPUResponse> productSPUs = productSPUMapper.getProductSPUs(qry);

        return productSPUs;
    }

    @Override
    public ProductResponse getProductSPUById(int spuId) {
        String spuKey = "product:spu:" + spuId;

        // 1. 先从缓存中查询
        ProductResponse productResponse = (ProductResponse) redisUtil.get("productSPU_" + spuId);

        if (productResponse != null){
            // 有缓存，直接返回
            return productResponse;
        }

        // 2. 缓存未命中，从数据库查询
        // redis分布式锁
        String requestId = UUID.randomUUID().toString();
//        try{
//            boolean locked = redisUtil.set
//        }

        productResponse = productSPUMapper.getProductSPUById(spuId);

        if (productResponse != null){
            // 数据库查到了返回，否则，报错，并且写入空数据缓存
            return productResponse;
        }

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