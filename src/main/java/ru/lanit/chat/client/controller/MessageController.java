package ru.lanit.chat.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.lanit.chat.gen.Message;
import ru.lanit.chat.messages.MessageRepository;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    MessageRepository repository;

    @GetMapping("/all")
    public String allMessages(Model model) {
        List<Message> messageList = repository.getMessages();
        messageList.forEach(message -> System.out.println(message.getText()));
        String text = messageList.get(0).getText();
        model.addAttribute("message", text);
        model.addAttribute("messageList", messageList);
        return "messages";
    }


}
