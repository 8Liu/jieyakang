package com.liudehuang.jieyakang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liudehuang
 * @date 2019/5/14 10:54
 */
@MapperScan(basePackages = "com.liudehuang.jieyakang.*.dao")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
