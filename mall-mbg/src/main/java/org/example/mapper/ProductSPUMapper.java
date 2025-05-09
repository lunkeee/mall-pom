package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.modules.DO.ProductSPU;
import org.example.modules.DTO.ProductListRequest;
import org.example.modules.VO.ProductResponse;
import org.example.modules.VO.ProductSPUResponse;

import java.util.List;

public interface ProductSPUMapper extends BaseMapper<ProductSPU> {

    List<ProductSPUResponse> getProductSPUs(ProductListRequest qry);

    ProductResponse getProductSPUById(int id);


}
