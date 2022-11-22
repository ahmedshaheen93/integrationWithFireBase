package com.shaheen.integrationwithfirebase.service;

import com.shaheen.gateways.openapi.model.MessageRequest;
import com.shaheen.gateways.openapi.model.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
  @Override
  public List<MessageResponse> listAllMessages() {
    return null;
  }

  @Override
  public MessageResponse createMessage(MessageRequest messageRequest) {
    return null;
  }
}
