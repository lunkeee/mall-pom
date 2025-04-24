package org.example.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.product.modules.DO.ProductSKU;
import org.example.product.modules.Response.ProductSKUResponse;

import java.util.List;

public interface ProductSKUMapper extends BaseMapper<ProductSKU> {

    List<ProductSKUResponse> getSKUBySpuId(int spuId);
}
