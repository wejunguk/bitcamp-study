package com.eomcs.o14_a_b.pms.handler;

public class AuthLogoutHandler {
  public void logout() {
    System.out.println("[로그아웃]");

    AuthLoginHandler.loginUser = null;
    System.out.println("로그아웃 하였습니다.");
  }
}







