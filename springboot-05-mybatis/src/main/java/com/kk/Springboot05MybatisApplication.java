package com.kk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//@MapperScan("com.kk.springboot.mapper")//扫描该包下的所有接口，生成接口代理对象
public class Springboot05MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot05MybatisApplication.class, args);
    }

}
