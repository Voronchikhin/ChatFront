package ru.neofr.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.neofr.demo.entity.LoginReply;
import ru.neofr.demo.entity.LoginRequest;
import ru.neofr.demo.entity.User;
import ru.neofr.demo.exception.ServerNotResponding;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class SignUpController {

    @Resource
    ChatServer chatServer;

    @PostMapping(value = "/signup")
    public String confirmSignUp(@RequestParam("login") String name,  HttpSession session) throws ServerNotResponding {
        LoginRequest request = new LoginRequest();
        request.setName(name);
        try {
            LoginReply reply = chatServer.login(request);
            User user = new User();
            user.setLogin(reply.getUsername());
            user.setToken(reply.getToken());
            session.setAttribute("account", user);
        }catch (Exception e){
            return "error";
        }
        return "chatroom";
    }
    @GetMapping("/signup")
    public String signUp(){
        return "signup";
    }
}
