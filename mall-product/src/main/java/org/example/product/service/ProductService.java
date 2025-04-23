package org.example.product.service;

import org.example.common.utils.R;
import org.example.product.modules.DO.ProductSPU;
import org.example.product.modules.Request.ProductListRequest;
import org.example.product.modules.Response.ProductCategoryResponse;
import org.example.product.modules.Response.ProductResponse;
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
     * @param id spu_id
     * @return List<UserDTO>
     */
    ProductResponse getProductSPUById(int id);




    void testRedis(String name);


}
