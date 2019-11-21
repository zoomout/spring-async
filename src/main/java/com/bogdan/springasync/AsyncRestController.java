package com.bogdan.springasync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class AsyncRestController {

  private final SlowService slowService;
  private static final Logger LOGGER = LoggerFactory.getLogger(AsyncRestController.class);

  @Autowired
  public AsyncRestController(final SlowService slowService) {
    this.slowService = slowService;
  }

  @GetMapping("/getAsync")
  public ResponseEntity<AsyncResponseDto> getAsyncResponse() {
    CompletableFuture<AsyncResponse> slowTurtle = slowService.getSlowResult("turtle");
    CompletableFuture<AsyncResponse> slowKettle = slowService.getSlowResult("kettle");
    CompletableFuture<AsyncResponse> slowBus = slowService.getSlowResult("bus");

    long start = System.currentTimeMillis();
    CompletableFuture.allOf(slowTurtle, slowKettle, slowBus).join();
    long elapsedTime = System.currentTimeMillis() - start;
    LOGGER.info("Elapsed time: " + elapsedTime);

    List<AsyncResponse> users = new ArrayList<>();
    try {
      users.add(slowTurtle.get());
      users.add(slowKettle.get());
      users.add(slowBus.get());
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException("OMG!!!", e);
    }
    return ResponseEntity.ok(new AsyncResponseDto(elapsedTime, users));
  }
}
