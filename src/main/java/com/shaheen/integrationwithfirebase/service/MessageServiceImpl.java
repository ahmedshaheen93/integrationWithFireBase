package com.shaheen.integrationwithfirebase.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.shaheen.gateways.openapi.model.MessageRequest;
import com.shaheen.gateways.openapi.model.MessageResponse;
import com.shaheen.integrationwithfirebase.mapper.MessageMapper;
import com.shaheen.integrationwithfirebase.model.Message;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
  @Value("${com.shaheen.database.collectionName}")
  private String databaseName;

  private final Firestore firestore;

  private final MessageMapper messageMapper;

  @Override
  public List<MessageResponse> listAllMessages() {
    throw new NotImplementedException();
  }

  @Override
  public MessageResponse createMessage(MessageRequest messageRequest) {
    Message message = messageMapper.mapMessageFromRequest(messageRequest);
    try {

      ApiFuture<WriteResult> collectionsApiFuture =
          firestore.collection(databaseName).document(UUID.randomUUID().toString()).set(message);
      String lastModifiedTime = collectionsApiFuture.get().getUpdateTime().toString();
      MessageResponse messageResponse = new MessageResponse();
      messageResponse.setMessage(message.getMessage());
      messageResponse.setName(message.getName());
      messageResponse.setLastModifedTime(lastModifiedTime);
      return messageResponse;
    } catch (Exception exception) {
      throw new RuntimeException("can't persist message");
    }
  }
}
