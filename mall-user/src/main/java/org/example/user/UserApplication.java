package org.example.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "org.example")
@MapperScan("org.example.mapper")
@EnableFeignClients
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);

        System.out.println("Hello UserApplication");

//        System.out.println(ClassLoader.getSystemClassLoader().getResource("org/example/common/config/SwaggerConfig.class"));

    }
}
