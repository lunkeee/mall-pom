package org.example.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example")
@MapperScan("org.example.product.mapper")
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(org.example.product.ProductApplication.class, args);
        System.out.println("Hello World");
    }

}
