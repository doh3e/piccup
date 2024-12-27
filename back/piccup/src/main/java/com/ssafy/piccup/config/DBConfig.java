package com.ssafy.piccup.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.piccup.model.dao")
public class DBConfig {


}




