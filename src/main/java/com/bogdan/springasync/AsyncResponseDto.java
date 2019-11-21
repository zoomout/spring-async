package com.bogdan.springasync;

import java.util.List;

public class AsyncResponseDto {

  private final Long elapsedTimeMillis;
  private final List<AsyncResponse> users;

  public AsyncResponseDto(final Long elapsedTimeMillis, final List<AsyncResponse> users) {
    this.elapsedTimeMillis = elapsedTimeMillis;
    this.users = users;
  }

  public Long getElapsedTimeMillis() {
    return elapsedTimeMillis;
  }

  public List<AsyncResponse> getUsers() {
    return users;
  }
}
