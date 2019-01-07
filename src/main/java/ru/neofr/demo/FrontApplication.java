package ru.neofr.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@ImportResource("applicationContext.xml")
@Controller
public class FrontApplication extends SpringBootServletInitializer{
    private String login;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FrontApplication.class);
    }

    @GetMapping("/")
    public String startPage() {
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(FrontApplication.class, args);
    }

}

