package com.dk;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: mybatisplus_books
 * @description: TODO
 * @author: Mr.XYH
 * @create: 2021-01-10 16:05
 **/
@SpringBootApplication
@MapperScan("com.dk.mapper")
@EnableDubbo
public class BooksApplication {
    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class,args);
    }
}
