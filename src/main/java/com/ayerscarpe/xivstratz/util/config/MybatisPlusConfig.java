package com.ayerscarpe.xivstratz.util.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.ayerscarpe.xivstratz.mapper")
public class MybatisPlusConfig {
    /**
     * 实现分页插件 PaginationInterceptor
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor(){
        return new PaginationInnerInterceptor();
    }
}
