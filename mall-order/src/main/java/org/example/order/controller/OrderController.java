package org.example.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "订单")
@RestController
@RequestMapping("/order")
public class OrderController {



    @ApiOperation(value = "测试")
    @GetMapping("/test")
    public String test() {
        return "hello order service";
    }




    @ApiOperation(value = "创建订单")
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(){

        return ResponseEntity.ok("createOrder");
    }

    @ApiOperation(value = "获取订单详情")
    @GetMapping("/detail/{orderId}")
    public ResponseEntity<String> getOrderDetail(@PathVariable Long orderId){


        return ResponseEntity.ok("getOrderDetail");
    }

    @ApiOperation(value = "获取订单详情")
    @PostMapping("/list")
    public ResponseEntity<String> getOrderList(@RequestBody Long orderId){


        return ResponseEntity.ok("getOrderList");
    }

    @ApiOperation(value = "取消订单")
    @PostMapping("/cancel/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long orderId){


        return ResponseEntity.ok("cancelOrder");
    }

}
