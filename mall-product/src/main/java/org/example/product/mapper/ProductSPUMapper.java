package org.example.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.product.modules.DO.ProductSPU;
import org.example.product.modules.Request.ProductListRequest;
import org.example.product.modules.Response.ProductResponse;
import org.example.product.modules.Response.ProductSPUResponse;

import java.util.List;

public interface ProductSPUMapper extends BaseMapper<ProductSPU> {

    List<ProductSPUResponse> getProductSPUs(ProductListRequest qry);

    ProductResponse getProductSPUById(int id);


}
