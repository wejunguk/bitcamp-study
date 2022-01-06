package com.eomcs.pms.o4_d.hadler;

import com.eomcs.pms.o4_d.domain.Member;
import com.eomcs.pms.o4_d.util.Prompt;

public class MemberHandler {

  static final int MAX_LENGTH = 5;

  static Member[] members = new Member[MAX_LENGTH];
  static int size = 0;

  public static void add() {
    System.out.println("[회원 등록]");

    Member member = new Member();

    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new java.sql.Date(System.currentTimeMillis());

    members[size++] = member;
  }

  public static void list() {
    System.out.println("[회원 목록]");

    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          members[i].no,
          members[i].name,
          members[i].email,
          members[i].tel,
          members[i].registeredDate);
    }
  }

  // 메서드 선언 : 리턴타입 메서드 명(파라미터)
  static boolean exist(String name) {
    for (int i = 0; i <size; i++) {
      if (members[i].name.equals(name)) {
        return true;
      }
    } 
    return false;
  }

}
