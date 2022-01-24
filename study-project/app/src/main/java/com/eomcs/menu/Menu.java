package com.eomcs.menu;

public abstract class Menu {

  public static final int ACCESS_LOGOUT = 0x01;    //0001
  public static final int ACCESS_GENERAL = 0x02;   //0010
  public static final int ACCESS_ADMIN = 0x04;     //0100


  String title;

  int accessScope;

  public Menu(String title) {
    this(title, ACCESS_LOGOUT | ACCESS_GENERAL | ACCESS_ADMIN); // 모든 사람 접근 가능
  }

  public Menu(String title, int accessCope) {
    this.title = title; // 메뉴 이름 설정은 기존 생성자를 통해 처리한다. this -> Menu 생성자 호출
    this.accessScope = accessCope;
  }

  public abstract void execute();
}
