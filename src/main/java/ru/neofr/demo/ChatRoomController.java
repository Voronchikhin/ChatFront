package ru.neofr.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.neofr.demo.entity.Message;
import ru.neofr.demo.entity.PostMessage;
import ru.neofr.demo.entity.ServerMessage;
import ru.neofr.demo.entity.User;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ChatRoomController {

    @Resource
    ChatServer chatServer;

    @GetMapping(value = "/chatroom")
    public String chatAction(Model model, HttpSession session) {
        User user = (User)session.getAttribute("account");
        List<ServerMessage> list = chatServer.getMessages(0, 99999, user.getToken()).getMessages();
        System.out.println("get list");
        List<Message> viewList = list.stream()
                .map(serverMessage -> new Message(serverMessage.getMessage()
                        , serverMessage.getUserName(),serverMessage.getSendTime().toString())).collect(Collectors.toList());
        session.setAttribute("messages", viewList);
        return "chatroom";
    }

    @PostMapping(value = "/chatroom")
    public String sendMessage(@RequestParam(name = "new message") String message, HttpSession session){
        User user = (User)session.getAttribute("account");
        System.out.println("user is :"+user);
        System.out.println("message is :"+message);
        PostMessage mes = new PostMessage();
        mes.setMessage(message);
        chatServer.postMessage(mes, user.getToken());
        return "chatroom";
    }
}
