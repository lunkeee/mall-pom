package org.example.product.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.product.modules.DO.ProductSKU;

/**
 * @author 阳光倾洒
 * @description 用户-数据访问层(依赖mybatis-plus),重用mybatis-service提供的CURD方法
 */
public interface ProductSKUDao extends IService<ProductSKU> {
    /**
     * 查询用户
     *
     * @param qry
     * @return
     */
}
