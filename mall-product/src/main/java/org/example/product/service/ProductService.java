package org.example.product.service;

import org.example.common.utils.R;
import org.example.product.modules.DO.ProductSPU;
import org.example.product.modules.Response.ProductSKUResponse;
import org.example.product.modules.Response.ProductSPUResponse;

import java.util.List;

public interface ProductService {

    /**
     * 通过ID查询SPU
     *
     * @param id productSPU id
     * @return ProductSPU
     */
    R<ProductSPU> findSPUById(Long id);

    /**
     * 查看具体商品SPU
     *
     * @param qry 查询体
     * @return List<UserDTO>
     */
    List<ProductSPUResponse> getProductSPUs(ProductSKUResponse qry);

    /**
     * 查看具体商品SKU
     *
     * @param qry 查询体
     * @return List<UserDTO>
     */
    List<ProductSKUResponse> getProductSKUs(ProductSKUResponse qry);


    void testRedis(String name);
}
