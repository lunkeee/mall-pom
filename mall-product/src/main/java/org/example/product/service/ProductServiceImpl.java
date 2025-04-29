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
        String spuKey = "productSpu:" + spuId;
        String lockKey = "productLock_" + spuId;

        // 1. 先从缓存中查询
        ProductResponse productResponse = (ProductResponse) redisUtil.get(spuKey);

        if (productResponse != null) {
            // 有缓存，直接返回
            return productResponse;
        }

        // 2. 缓存未命中，从数据库查询
        // redis分布式锁
        String requestId = UUID.randomUUID().toString();
        try {
            boolean locked = redisUtil.getLock(lockKey, requestId, 3);
            if (!locked) {
                // 获取锁失败，短暂等待后重试
                // 加锁失败，重试
                Thread.sleep(100);
                return getProductSPUById(spuId);
            }

            // 检查缓存，防止其他线程已经更新
            productResponse = (ProductResponse) redisUtil.get(spuKey);
            if (productResponse != null) {
                // 有缓存，直接返回
                return productResponse;
            }

            // 3. 缓存未命中，从数据库查询

            productResponse = productSPUMapper.getProductSPUById(spuId);
            if (productResponse != null) {
                // 有数据，写入缓存并返回结果

                redisUtil.set(spuKey, productResponse, 30);
                return productResponse;
            } else {
                // 没有数据，写入空数据缓存
                redisUtil.set(spuKey, productResponse, 30);
                return null;
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // 释放锁
            if (requestId.equals(redisUtil.get(lockKey))) {
                redisUtil.delete(lockKey);
            }
        }

//        return productSPUMapper.getProductSPUById(spuId);

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