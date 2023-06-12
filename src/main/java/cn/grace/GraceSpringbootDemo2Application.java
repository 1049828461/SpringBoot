package cn.grace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:jdbcConfig.properties")
@MapperScan("cn.grace.mapper")
@EnableCaching
@SpringBootApplication
public class GraceSpringbootDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(GraceSpringbootDemo2Application.class, args);
    }

}
