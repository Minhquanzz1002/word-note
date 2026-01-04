package com.vn.toeic.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.vn.toeic.mapper")
public class MyBatisConfig {
}
