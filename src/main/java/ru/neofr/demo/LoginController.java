package ru.neofr.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.neofr.demo.entity.Message;
import ru.neofr.demo.entity.User;
import ru.neofr.demo.exception.ServerNotResponding;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller
public class LoginController {
    private String login;
    private Logger logger = LogManager.getLogger(LoginController.class);
    //@Autowired
    private UserRepository userRepository = new UserRepositoryImpl();

    @GetMapping(value = "/login")
    public String loginPage(Model data) {
        data.addAttribute("data", new User());
        return "login";
    }

    @PostMapping(value = "/login")
    public String checkLogin(@ModelAttribute User data, HttpSession session ) {
        login = data.getLogin();
        logger.debug("checking user {}",data);
        try {
            if( userRepository.checkToken(data) ){
                List<Message> messages = new LinkedList<>();
                session.setAttribute("messages", messages);
                session.setAttribute("account", data);
                return "chatroom";
            }

            return "error";

        } catch (ServerNotResponding serverNotResponding) {
            logger.warn("user repository: {} does not respond", userRepository);
            return "error";
        }
    }
}
