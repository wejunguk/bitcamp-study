package com.eomcs.pms.o2_c;

import java.util.Date;
import java.util.Scanner;

//1) 배열 사용 전
//2) 배열 사용 후
//3) 반복문 적용 : while 문
//4) 반복문 적용 : for 문
//5) 여러 문장에서 반복해서 사용하는 값은 변수에 담아서 사용한다.
//6) 조회용으로만 사용할 변수라면 상수로 선언한다.
//7) 특정 조건에 따라 반복을 멈춘다.
//8) 날짜의 출력형식을 "yyyy-MM-dd"로 변경한다.

public class App {

  static class Member {
    int no;
    String name;
    String email;
    String password;
    String photo; 
    String tel;
    Date registeredDate;
  }

  static final int MAX_LENGTH = 100;
  static Member[] members = new Member[MAX_LENGTH];
  static int size = 0;

  public static void main(String[] args) {
    System.out.println("[회원]");

    inputMembers();

    System.out.println("--------------------------------");

    printMembers();

  }

  static void inputMembers() {
    Scanner keyboardScan = new Scanner(System.in);

    for (int i = 0; i < MAX_LENGTH; i = i + 1) {

      Member member = new Member();

      System.out.print("번호? ");
      member.no = Integer.parseInt(keyboardScan.nextLine());

      System.out.print("이름? ");
      member.name = keyboardScan.nextLine();

      System.out.print("이메일? ");
      member.email = keyboardScan.nextLine();

      System.out.print("암호? ");
      member.password = keyboardScan.nextLine();

      System.out.print("사진? ");
      member.photo = keyboardScan.nextLine();

      System.out.print("전화? ");
      member.tel = keyboardScan.nextLine();

      member.registeredDate = new java.sql.Date(System.currentTimeMillis());

      members[size++] = member;

      System.out.println();

      System.out.print("계속 입력하시겠습니까? (y/N) ");
      String input = keyboardScan.nextLine();
      if (input.equalsIgnoreCase("N") || input.equals("")) {
        break;
      }
      System.out.println();
    }

    keyboardScan.close(); // 데이터 입출력이 끝났으면 도구를 닫는다.
  }

  static void printMembers() {
    for (int i = 0; i < size; i = i + 1) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.no, m.name, m.email, m.tel, m.registeredDate);
    }
  }
}
