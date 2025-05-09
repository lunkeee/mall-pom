package org.example.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.common.utils.R;
import org.example.modules.DTO.ProductListRequest;
import org.example.modules.VO.ProductCategoryResponse;
import org.example.modules.VO.ProductResponse;
import org.example.modules.VO.ProductSPUResponse;
import org.example.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "商品")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productServiceImpl;

    @ApiOperation(value = "测试")
    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @ApiOperation(value = "测试Redis")
    @PostMapping("/test/redis")
    public String test(@RequestParam String name) {
        productServiceImpl.testRedis(name);
        return "hello world";
    }

    @ApiOperation(value = "商品分类列表")
    @GetMapping("/list-category")
    public R<List<ProductCategoryResponse>> getCategoryList(){
        List<ProductCategoryResponse> result = productServiceImpl.getCategoryList();
        return R.success(result);
    }

    @ApiOperation(value = "默认商品列表-根据关键词搜索商品-根据分类搜索商品")
    @PostMapping("/list-spu")
    public R<List<ProductSPUResponse>> getProductList(@RequestBody ProductListRequest qry) {
        List<ProductSPUResponse> response = productServiceImpl.getProductSPUs(qry);
        return R.success(response);
    }

    @ApiOperation(value = "获取商品spu信息-附带所有sku信息")
    @GetMapping("/spu/{id}")
    public R<ProductResponse> getProductSPUById(@PathVariable int id){
        ProductResponse response = productServiceImpl.getProductSPUById(id);
        return R.success(response);
    }


}
