package ru.lanit.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lanit.chat.gen.Message;
import ru.lanit.chat.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public boolean addMessage(Message newMessage) {
        return repository.addMessage(newMessage);
    }

    public List<Message> getMessages() {
        return repository.getMessages();
    }

    public boolean receivedStatus(Message newMessage) {
        return addMessage(newMessage);
    }

}
