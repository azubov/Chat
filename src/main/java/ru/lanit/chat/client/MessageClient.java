package ru.lanit.chat.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import ru.lanit.chat.gen.*;

public class MessageClient extends WebServiceGatewaySupport {

    public SendMessageResponse sendMessage(Message message) {
        SendMessageRequest request = new SendMessageRequest();
        request.setMessage(message);

        return (SendMessageResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public AllMessagesResponse allMessages() {
        AllMessagesRequest request = new AllMessagesRequest();

        return (AllMessagesResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
