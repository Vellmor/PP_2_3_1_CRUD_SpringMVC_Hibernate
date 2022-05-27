package ru.kata.springmvcapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author KalachikovMP
 * @create 2022-05-27 10:24
 **/
@EnableJpaRepositories("ru.kata.springmvcapp.repository")
@EntityScan("ru.kata.springmvcapp.model")
@SpringBootApplication
public class SpringBootApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}
