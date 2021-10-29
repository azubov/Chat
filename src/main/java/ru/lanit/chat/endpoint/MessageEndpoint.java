package ru.lanit.chat.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.lanit.chat.gen.*;
import ru.lanit.chat.service.MessageService;

@Endpoint
public class MessageEndpoint {

    private static final String NAMESPACE_URI = "http://lanit.ru/chat/gen";

    private final MessageService service;

    @Autowired
    public MessageEndpoint(MessageService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendMessageRequest")
    @ResponsePayload
    public SendMessageResponse sendMessage(@RequestPayload SendMessageRequest request) {
        SendMessageResponse response = new SendMessageResponse();
        boolean receivedStatus = service.receivedStatus(request.getMessage());

        response.setReceived(receivedStatus);
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "allMessagesRequest")
    @ResponsePayload
    public AllMessagesResponse allMessages(@RequestPayload AllMessagesRequest request) {
        AllMessagesResponse response = new AllMessagesResponse();

        response.getMessageList().addAll(service.getMessages());
        return response;
    }

}
