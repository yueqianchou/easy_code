package com.day;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.day.dao")
public class MybatisBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisBackApplication.class, args);
        System.out.println("启动成功---------》");
    }

}
