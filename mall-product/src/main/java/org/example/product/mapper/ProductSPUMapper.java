package org.example.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.product.modules.DO.ProductSPU;
import org.example.product.modules.Request.ProductListRequest;

import java.util.List;

public interface ProductSPUMapper extends BaseMapper<ProductSPU> {
    List<ProductSPU> getProductSPUs(ProductListRequest qry);
}
