package org.example.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.common.utils.R;
import org.example.product.modules.DO.ProductSPU;
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
    public ResponseEntity<R<String>> test(@RequestParam String name) {
        productServiceImpl.testRedis(name);
        return ResponseEntity.ok(R.success("hello world"));
    }

    @ApiOperation(value = "通过ID查询SPU")
    @GetMapping("/spu/{id}")
    public ResponseEntity<R<ProductSPU>> findSPUById(@PathVariable Long id) {
        R<ProductSPU> result = productServiceImpl.findSPUById(id);
        if(result.getCode() == 200){
            return ResponseEntity.ok().body(result);
        }else{
            return ResponseEntity.badRequest().body(result);
        }

    }

    @ApiOperation(value = "默认商品列表-根据关键词搜索商品-根据分类搜索商品")
    @GetMapping("/list")
    public ResponseEntity<R<List<ProductSPU>>> getProductList() {
//        ResultResponse<List<ProductSPU>> response = productServiceImpl.getProductSPUs(null);
        return ResponseEntity.ok(R.success(null));
    }

}
