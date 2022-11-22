package com.shaheen.integrationwithfirebase.service;

import com.shaheen.gateways.openapi.model.MessageRequest;
import com.shaheen.gateways.openapi.model.MessageResponse;

import java.util.List;

public interface MessageService {
  List<MessageResponse> listAllMessages();

  MessageResponse createMessage(MessageRequest messageRequest);
}
