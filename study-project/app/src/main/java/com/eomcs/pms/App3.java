package com.eomcs.pms;

import java.sql.Date;

public class App3 {

  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.println("[작업]");
    System.out.print("프로젝트? ");
    String pro = keyboard.nextLine();
    System.out.print("번호? ");
    int number = keyboard.nextInt ();
    keyboard.nextLine();
    System.out.print("내용? ");
    String text = keyboard.nextLine();
    System.out.print("완료일? ");
    System.out.print("상태? ");
    System.out.print("담당자? ");
    System.out.printf("-------------------------------");
    System.out.printf("프로젝트: %s\n", "미니 프로젝트 관리 시스템 개발");
    System.out.printf("번호: %d\n", 1);
    System.out.printf("내용: %s\n", "요구사항 수집");
    System.out.printf("완료일: %s\n", "2020-01-20");
    System.out.printf("상태: %s\n", "진행중");
    System.out.printf("담당자: %s\n", "홍길동");
  }
}
