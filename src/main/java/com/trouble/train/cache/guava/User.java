package com.trouble.train.cache.guava;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author troubleMan
 * @description user
 * @Date 2022/6/23 00:47
 * @Version 1.0
 **/
@Getter
@Setter
public class User implements Serializable {

  private String userName;
  private String userId;
  public User(String userName, String userId) {
    this.userName = userName;
    this.userId = userId;
  }

  public User() {

  }

  public String getUserId() {
    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }
  public String getUserName() {
    return userName;
  }
  @Override
  public String toString() {
    return userId + " --- " + userName;
  }

}
