package org.example.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.common.utils.BusinessException;
import org.example.common.utils.R;
import org.example.modules.DTO.OrderCreateRequest;
import org.example.modules.VO.OrderCreateResponse;
import org.example.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "订单")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @ApiOperation(value = "测试")
    @GetMapping("/test")
    public String test() {
        return "hello order service";
    }




    @ApiOperation(value = "创建订单")
    @PostMapping("/create")
    public R<OrderCreateResponse> createOrder(@RequestBody OrderCreateRequest request){

        try {
            // 参数校验
            if (request.getUserId() == 0 || request.getUserId() == -1) {
                return R.error(4000, "用户ID不能为空");
            }
            if (request.getProducts() == null || request.getProducts().isEmpty()) {
                return R.error(4000, "订单商品不能为空");
            }

            // 处理订单创建
            OrderCreateResponse orderCreateResponse = orderService.createOrder(request);

            return R.success("订单创建成功",orderCreateResponse);

        } catch (BusinessException e) {
            return R.error(e);
        }
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


    @ApiOperation(value = "测试rabbitmq")
    @GetMapping("/testRabbitmq")
    public ResponseEntity<String> testRabbitmq(){

        orderService.send("testRabbitmq");

        return ResponseEntity.ok("testRabbitmq");
    }

}
