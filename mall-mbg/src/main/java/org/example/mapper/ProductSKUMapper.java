package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.modules.DO.ProductSKU;
import org.example.modules.VO.ProductSKUResponse;

import java.util.List;

public interface ProductSKUMapper extends BaseMapper<ProductSKU> {

    List<ProductSKUResponse> getSKUBySpuId(int spuId);
}
