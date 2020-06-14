package com.shopping.product.controller;
import com.shopping.product.message.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

  @MessageMapping("/sendMessage")
  @SendTo("/topic/greetings")
  public String sendMessage(Message message) throws Exception {
    Thread.sleep(300); // simulated delay
    System.out.println(message);
    return message.getContent();
  }
}
