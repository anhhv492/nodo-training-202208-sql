package edu.hanoi.spring.controller;

import edu.hanoi.spring.dao.UserDAO;
import edu.hanoi.spring.model.Message;
import edu.hanoi.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    UserDAO userDAO;
    @MessageMapping("/user")
    @SendTo("/topic/chat")
    public Message add(User user){
        String status = userDAO.insert(user);
        System.out.println("user: "+user.getUsername()+" - email: "+user.getEmail());
        return new Message("Save: "+status+" successful!");
    }

}
