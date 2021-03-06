package com.eomcs.o14_a_b.pms.handler;

import com.eomcs.o14_a_b.pms.domain.Member;

public class AuthUserInfoHandler {

  public void displayLoginUser() {
    System.out.println("[내정보]");

    Member loginUser = AuthLoginHandler.getLoginUser();

    if (loginUser == null) {
      System.out.println("로그인 하지 않았습니다.");
      return;
    }

    System.out.printf("이름: %s\n", loginUser.getName());
    System.out.printf("이메일: %s\n", loginUser.getEmail());
    System.out.printf("사진: %s\n", loginUser.getPhoto());
    System.out.printf("전화: %s\n", loginUser.getTel());
    System.out.printf("등록일: %s\n", loginUser.getRegisteredDate());
  }
}






