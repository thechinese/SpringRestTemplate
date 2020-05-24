package de.cheng.templateservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static de.cheng.templateservice.util.Constants.THREAD_POOL_SIZE;

@Configuration
public class AsyncConfiguration {

  @Bean
  ExecutorService getExecutorService() {
    return Executors.newFixedThreadPool(THREAD_POOL_SIZE);
  }
}
