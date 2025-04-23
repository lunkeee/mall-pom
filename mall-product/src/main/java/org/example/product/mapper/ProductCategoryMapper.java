package org.example.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.product.modules.DO.ProductCategory;
import org.example.product.modules.Response.ProductCategoryResponse;

import java.util.List;

public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {
    List<ProductCategoryResponse> getCategoryList();
}
