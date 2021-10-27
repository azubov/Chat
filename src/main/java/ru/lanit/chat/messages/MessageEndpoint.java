package ru.lanit.chat.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.lanit.chat.gen.AddMessageRequest;
import ru.lanit.chat.gen.AddMessageResponse;
import ru.lanit.chat.gen.Message;

@Endpoint
public class MessageEndpoint {

    private static final String NAMESPACE_URI = "http://lanit.ru/chat/gen";

    private MessageRepository repository;

    @Autowired
    public MessageEndpoint(MessageRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addMessageRequest")
    @ResponsePayload
    public AddMessageResponse addMessage(@RequestPayload AddMessageRequest request) {
        Message newMessage = request.getMessage();
        AddMessageResponse response = new AddMessageResponse();

        if (repository.addMessage(newMessage)) {
            response.setReceived(Boolean.TRUE);
        } else {
            response.setReceived(Boolean.FALSE);
        }
        return response;
    }
}
