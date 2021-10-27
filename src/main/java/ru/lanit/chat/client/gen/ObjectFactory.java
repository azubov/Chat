
package ru.lanit.chat.client.gen;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.lanit.chat.client.gen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.lanit.chat.client.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendMessageRequest }
     * 
     */
    public SendMessageRequest createSendMessageRequest() {
        return new SendMessageRequest();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link SendMessageResponse }
     * 
     */
    public SendMessageResponse createSendMessageResponse() {
        return new SendMessageResponse();
    }

    /**
     * Create an instance of {@link AllMessagesRequest }
     * 
     */
    public AllMessagesRequest createAllMessagesRequest() {
        return new AllMessagesRequest();
    }

    /**
     * Create an instance of {@link AllMessagesResponse }
     * 
     */
    public AllMessagesResponse createAllMessagesResponse() {
        return new AllMessagesResponse();
    }

}
