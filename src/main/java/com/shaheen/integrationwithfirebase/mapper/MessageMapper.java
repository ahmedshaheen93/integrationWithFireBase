package com.shaheen.integrationwithfirebase.mapper;

import com.shaheen.gateways.openapi.model.MessageRequest;
import com.shaheen.integrationwithfirebase.model.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {
  public Message mapMessageFromRequest(MessageRequest messageRequest) {
    Message message = new Message();
    message.setMessage(messageRequest.getMessage());
    message.setName(messageRequest.getName());
    return message;
  }
}
