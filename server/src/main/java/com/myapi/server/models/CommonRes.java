package com.myapi.server.models;

public class CommonRes {
  public enum EStatus {
    success,
    failure
  }

  public Enum<EStatus> status;
  public String message;

  public CommonRes(Enum<EStatus> status, String message) {
    this.status = status;
    this.message = message;
  }
}
