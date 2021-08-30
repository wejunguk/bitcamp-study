package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class AuthHandler {

  List<Member> memberList;

  public AuthHandler(List<Member> memberList) {
    this.memberList = memberList;
  }

  public void login() {
    System.out.println("[로그인]");

    String email = Prompt.inputString("이메일? ");
    String password = Prompt.inputString("암호?")

        Member member = findByEmailPassword(email, password);

    if (member == null) {
      System.out.println("이메일과 암호가 일치하지 않습니다.");
    } else {
      System.out.println("%s님 환영합니다!/n", member.getName());
    }

    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("사진: %s\n", member.getPhoto());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("등록일: %s\n", member.getRegisteredDate());
  }




  private Member findByEmailPassword(String email, String password) {
    for (Member member : memberList) {
      if (member.getEmail() == .equalsIgnoreCase(email) &&
          member.getPassword().equals(password)) {
        return member;
      }
    }
    return null;
  }


}







