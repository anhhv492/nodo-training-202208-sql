package edu.hanoi.spring.controller;

import edu.hanoi.spring.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/topic/chat")
    public Message say(Message message, Principal principal){
        System.out.println("-- From client: "+message.getContent());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        return new Message(principal.getName()+": "+message.getContent()+"!");
        return new Message("- Hanoi: "+message.getContent()+"!");
    }

}
