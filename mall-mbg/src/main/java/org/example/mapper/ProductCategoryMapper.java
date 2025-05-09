package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.modules.DO.ProductCategory;
import org.example.modules.VO.ProductCategoryResponse;

import java.util.List;

public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {
    List<ProductCategoryResponse> getCategoryList();
}
