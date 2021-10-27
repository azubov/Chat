package ru.lanit.chat.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.lanit.chat.gen.*;

import java.util.List;

@Endpoint
public class MessageEndpoint {

    private static final String NAMESPACE_URI = "http://lanit.ru/chat/gen";

    private MessageRepository repository;

    @Autowired
    public MessageEndpoint(MessageRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendMessageRequest")
    @ResponsePayload
    public SendMessageResponse sendMessage(@RequestPayload SendMessageRequest request) {
        Message newMessage = request.getMessage();
        SendMessageResponse response = new SendMessageResponse();

        if (repository.addMessage(newMessage)) {
            response.setReceived(Boolean.TRUE);
        } else {
            response.setReceived(Boolean.FALSE);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "allMessagesRequest")
    @ResponsePayload
    public AllMessagesResponse allMessages(@RequestPayload AllMessagesRequest request) {
        AllMessagesResponse response = new AllMessagesResponse();

        response.getMessageList().addAll(repository.getMessages());
        return response;
    }

}
