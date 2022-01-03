package com.eomcs.pms.o4_b;

public class MemberHandler {

  static final int MAX_LENGTH = 5;

  // Member 인스턴스의 주소를 저장할 래퍼런스를 5개 생성한다.
  // 07_16_149
  static Member[] members = new Member[MAX_LENGTH];
  static int size = 0;

  static void add() {
    System.out.println("[회원 등록]");

    // 새 회원 정보를 담을 변수를 준비한다(식판을 준비!)
    // Member의 설계도로 만든 변수들(인스턴스)이 담긴
    // 주소를 저장하는 member변수를 선언한다.
    // member = Member인스턴스 주소를 저장하는 래퍼런스
    // 07_16_971
    Member member = new Member();

    // member 래퍼런스(member의 주소값)가 가르키는 인스턴스의 no!
    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new java.sql.Date(System.currentTimeMillis());

    members[size++] = member;
  }

  static void list() {
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
}
