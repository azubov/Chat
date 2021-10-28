package ru.lanit.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.lanit.chat.gen.Message;
import ru.lanit.chat.messages.MessageRepository;

@Controller
@RequestMapping("/chat")
public class MessageController {

    @Autowired
    MessageRepository repository;

    @GetMapping("/{user}")
    public String allMessages(@PathVariable("user") String user, Model model) {
        model.addAttribute("messageList", repository.getMessages());
        model.addAttribute("user", user);
        return "messages";
    }

    @PostMapping("/send")
    public String sendMessage(@ModelAttribute("message") Message message) {
        repository.addMessage(message);
        return "redirect:/chat/" + message.getFrom();
    }

}
