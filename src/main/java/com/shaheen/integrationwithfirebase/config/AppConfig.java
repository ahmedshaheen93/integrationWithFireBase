package com.shaheen.integrationwithfirebase.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
@Slf4j
public class AppConfig {
  @PostConstruct
  private void intFireBaseConnection() throws IOException {
    FileInputStream serviceAccount = new FileInputStream("serviceAccoutKey.json");
    FirebaseOptions options =
        FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();
    FirebaseApp.initializeApp(options);
    log.info("SUCCESS: Init Firebase Connection");
  }
}
