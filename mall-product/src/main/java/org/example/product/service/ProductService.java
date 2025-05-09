package org.example.product.service;

import org.example.modules.DTO.ProductListRequest;
import org.example.modules.VO.ProductCategoryResponse;
import org.example.modules.VO.ProductResponse;
import org.example.modules.VO.ProductSPUResponse;

import java.util.List;

public interface ProductService {

    /**
     * 查看所有商品分类
     *
     * @return List<ProductSPU>
     */
    List<ProductCategoryResponse> getCategoryList();

    /**
     * 商品SPU分页、查询
     *
     * @param qry 查询体
     * @return List<UserDTO>
     */
    List<ProductSPUResponse> getProductSPUs(ProductListRequest qry);


    /**
     * 查看具体商品SKU
     *
     * @param id productSPU id
     * @return ProductSPU
     */
    ProductResponse getProductSPUById(int id);




    void testRedis(String name);


}
