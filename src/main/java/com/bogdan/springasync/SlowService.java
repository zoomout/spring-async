package com.bogdan.springasync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class SlowService {

  private static final Logger logger = LoggerFactory.getLogger(SlowService.class);

  @Async
  public CompletableFuture<AsyncResponse> getSlowResult(String name) {
    logger.info("Looking up " + name);
    sleep(1000); // delay for demo
    AsyncResponse user = new AsyncResponse(Thread.currentThread().getName(), name);
    return CompletableFuture.completedFuture(user);
  }

  private void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
