package com.bogdan.springasync;

public class AsyncResponse {

  private final String threadId;
  private final String name;

  public AsyncResponse(final String threadId, final String name) {
    this.threadId = threadId;
    this.name = name;
  }

  public String getThreadId() {
    return threadId;
  }

  public String getName() {
    return name;
  }
}
