package com.eomcs.o14_a_b.pms.handler;

import java.util.List;
import com.eomcs.o14_a_b.pms.domain.Member;
import com.eomcs.o14_a_b.util.Prompt;

public class AuthLoginHandler {

  List<Member> memberList;

  static Member loginUser;
  public static Member getLoginUser() {
    return loginUser;
  }

  public AuthLoginHandler(List<Member> memberList) {
    this.memberList = memberList;
  }

  public void login() {
    System.out.println("[로그인]");

    String email = Prompt.inputString("이메일? ");
    String password = Prompt.inputString("암호? ");

    Member member = findByEmailPassword(email, password);

    if (member == null) {
      System.out.println("이메일과 암호가 일치하는 회원을 찾을 수 없습니다.");
    } else {
      System.out.printf("%s님 환영합니다!\n", member.getName());
      loginUser = member;
    }
  }

  private Member findByEmailPassword(String email, String password) {
    for (Member member : memberList) {
      if (member.getEmail().equalsIgnoreCase(email) &&
          member.getPassword().equals(password)) {
        return member;
      }
    }
    return null;
  }

}







