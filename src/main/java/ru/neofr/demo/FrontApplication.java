package ru.neofr.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.neofr.demo.entity.Message;

import javax.servlet.http.HttpSession;
import java.util.List;

@SpringBootApplication
@ImportResource("applicationContext.xml")
//@EnableJaxRsProxyClient
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

