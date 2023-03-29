package com.ayerscarpe.xivstratz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ayerscarpe.xivstratz.mapper")
public class XivStratzApplication {

    public static void main(String[] args) {
        SpringApplication.run(XivStratzApplication.class, args);
    }

}
