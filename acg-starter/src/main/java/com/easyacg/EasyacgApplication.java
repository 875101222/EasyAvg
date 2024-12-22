package com.easyacg;

import com.easyacg.factory.EasyacgPropertySourceFactory;
import org.dromara.autotable.springboot.EnableAutoTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Brahma
 */
@EnableAutoTable
@SpringBootApplication
@PropertySource(value = {
        "classpath:application.yml", "classpath:application-wx.yml"
}, factory = EasyacgPropertySourceFactory.class)
@ComponentScan("com.easyacg.*")
public class EasyacgApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyacgApplication.class, args);
    }
}
