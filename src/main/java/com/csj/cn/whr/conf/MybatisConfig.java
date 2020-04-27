package com.csj.cn.whr.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/2710:17
 */
@Configuration
@MapperScan(value = "com.csj.cn.whr.mapper")
public class MybatisConfig {
}
