package org.example.order;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "org.example")
@MapperScan("org.example.mapper")
@EnableFeignClients(basePackages = "org.example.common.config.feign")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(org.example.order.OrderApplication.class, args);
        System.out.println("Hello Order service");
    }
}
