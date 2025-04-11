package org.example.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example")
@MapperScan("org.example.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);

//        System.out.println("Hello UserApplication");

        System.out.println(ClassLoader.getSystemClassLoader().getResource("org/example/common/config/SwaggerConfig.class"));

    }
}
