package com.dk.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springboot_mybatis_plus
 * @description: mybatis分页配置类
 * @author: Mr.XYH
 * @create: 2021-01-09 16:39
 **/
@Configuration//标志配置类
public class MybatisPlusConfig {
    /**
    * @Description: 注入到spring容器中  PaginationInterceptor:分页插件类
    * @return: com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
    * @Author: Mr.XYH
    * @Date: 2021/1/10
    */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
