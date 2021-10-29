package ru.lanit.chat.repository;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import ru.lanit.chat.gen.Message;

@Repository
public class MessageRepository {

    private final List<Message> messages = new ArrayList<>();

    @PostConstruct
    public void initData() {
        Message message1 = new Message();
        message1.setFrom("User1");
        message1.setText("Hello from User1");
        messages.add(message1);

        Message message2 = new Message();
        message2.setFrom("User2");
        message2.setText("Hi from User2");
        messages.add(message2);
    }

    public boolean addMessage(Message newMessage) {
        return messages.add(newMessage);
    }

    public List<Message> getMessages() {
        return messages;
    }
}
