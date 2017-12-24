package io.ymq.fm.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 描述:启动服务
 * author: yanpenglei
 * Date: 2017/9/5 12:16
 */
@SpringBootApplication
@ComponentScan(value = {"io.ymq.fm"})
public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
    }
}