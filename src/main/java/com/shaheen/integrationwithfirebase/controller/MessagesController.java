package com.shaheen.integrationwithfirebase.controller;

import com.shaheen.gateways.openapi.api.MessagesApi;
import com.shaheen.gateways.openapi.model.MessageRequest;
import com.shaheen.gateways.openapi.model.MessageResponse;
import com.shaheen.integrationwithfirebase.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessagesController implements MessagesApi {
  private final MessageService messageService;

  @Override
  public ResponseEntity<MessageResponse> addMessage(MessageRequest messageRequest) {
    return new ResponseEntity<>(messageService.createMessage(messageRequest), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<List<MessageResponse>> listAllMessages() {
    return ResponseEntity.ok(messageService.listAllMessages());
  }
}
