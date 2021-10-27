package ru.lanit.chat.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.lanit.chat.gen.Message;
import ru.lanit.chat.messages.MessageRepository;

@Controller
@RequestMapping("/chat")
public class MessageController {

    @Autowired
    MessageRepository repository;

    @GetMapping
    public String allMessages(Model model) {
        model.addAttribute("messageList", repository.getMessages());
        return "messages";
    }

    @PostMapping("/send")
    public String sendMessage(@ModelAttribute("message") Message message) {
        repository.addMessage(message);
        return "redirect:/chat";
    }


}
