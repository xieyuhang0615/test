package com.dk.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @program: springboot_log
 * @description: 配置类
 * @author: Mr.XYH
 * @create: 2020-12-04 20:46
 **/
@Configuration
public class DataSourceConfig {
    /**
     *
     * @ConfigurationProperties 配置前缀
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDruidDataSource() {
        return new DruidDataSource();
    }
}
