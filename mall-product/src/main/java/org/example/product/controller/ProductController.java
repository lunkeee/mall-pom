package org.example.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.common.utils.R;
import org.example.product.modules.DO.ProductSPU;
import org.example.product.modules.Request.ProductListRequest;
import org.example.product.modules.Response.ProductCategoryResponse;
import org.example.product.modules.Response.ProductResponse;
import org.example.product.modules.Response.ProductSPUResponse;
import org.example.product.service.ProductService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<R<String>> test() {
        return ResponseEntity.ok(R.success("hello world"));
    }

    @ApiOperation(value = "测试Redis")
    @PostMapping("/test/redis")
    public R<String> test(@RequestParam String name) {
        productServiceImpl.testRedis(name);
        return R.success("hello world");
    }

    @ApiOperation(value = "通过ID查询SPU")
    @GetMapping("/spu/{id}")
    public R<ProductSPU> findSPUById(@PathVariable Long id) {
        R<ProductSPU> result = productServiceImpl.findSPUById(id);
        if(result.getCode() == 200){
            return result;
        }else{
            return result;
        }
    }

    @ApiOperation(value = "商品分类列表")
    @GetMapping("/list-category")
    public R<List<ProductCategoryResponse>> getCategoryList(){
        List<ProductCategoryResponse> result = productServiceImpl.getCategoryList();
        return R.success(result);
    }

    @ApiOperation(value = "默认商品列表-根据关键词搜索商品-根据分类搜索商品")
    @GetMapping("/list-product")
    public R<List<ProductSPUResponse>> getProductList(@RequestBody ProductListRequest qry) {
        List<ProductSPUResponse> response = productServiceImpl.getProductSPUs(qry);
        return R.success(response);
    }

    @ApiOperation(value = "获取商品spu信息-附带所有sku信息")
    @GetMapping("/product/spu/{id}")
    public R<ProductResponse> getProductSPUById(@PathVariable int id){
        ProductResponse response = productServiceImpl.getProductSPUById(id);
        return R.success(response);
    }


}
