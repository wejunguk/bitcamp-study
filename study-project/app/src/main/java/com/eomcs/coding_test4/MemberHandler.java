package com.eomcs.coding_test4;

import java.sql.Date;

public class MemberHandler {

  static final int LENGTH = 100;
  static int[] no = new int[LENGTH];
  static String[] name = new String[LENGTH];
  static String[] email = new String[LENGTH];
  static String[] password = new String[LENGTH];
  static String[] photo = new String[LENGTH];
  static String[] tel = new String[LENGTH];
  static Date[] registeredDate = new Date[LENGTH];
  static int size = 0;

  static void add() {
    System.out.println("[회원 등록]");

    //    String input = prompt("번호? ");
    //    no[size] = Integer.parseInt(input);

    no[size] = Prompt.inputInt("번호? ");
    name[size] = Prompt.inputString("이름? ");
    email[size] = Prompt.inputString("이메일? ");
    password[size] = Prompt.inputString("암호? ");
    photo[size] = Prompt.inputString("사진? ");
    tel[size] = Prompt.inputString("전화? ");
    registeredDate[size] = new Date(System.currentTimeMillis());

    size++;
  }

  static void list() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          no[i], name[i], email[i], tel[i], registeredDate[i]);
    }
  }
}