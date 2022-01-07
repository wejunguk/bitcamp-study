package com.eomcs.o2_c;

import java.sql.Date;
import java.util.Scanner;

//1) 배열 사용 전
//2) 배열 사용 후
//3) 반복문 적용 : while 문
//4) 반복문 적용 : for 문
//5) 여러 문장에서 반복해서 사용하는 값은 변수에 담아서 사용한다.
//6) 조회용으로만 사용할 변수라면 상수로 선언한다.
//7) 특정 조건에 따라 반복을 멈춘다.
//8) 날짜의 출력형식을 "yyyy-MM-dd"로 변경한다.

public class App3 {

  public static void main(String[] args) {

    System.out.println("[작업]");

    Scanner keyboardScan = new Scanner(System.in);

    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] content = new String[LENGTH];
    Date[] deadline = new Date[LENGTH];
    int[] status = new int[LENGTH];
    String[] owner = new String[LENGTH];

    System.out.print("프로젝트? ");
    String project = keyboardScan.nextLine();

    int size = 0;

    for (int i = 0; i < LENGTH; i++) {

      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());

      System.out.print("내용? ");
      content[i] = keyboardScan.nextLine();

      System.out.print("완료일? ");
      deadline[i] = Date.valueOf(keyboardScan.nextLine());

      System.out.println("상태? ");
      System.out.println("0: 신규");
      System.out.println("1: 진행중");
      System.out.println("2: 완료");
      System.out.println("> ");
      status[i] = Integer.valueOf(keyboardScan.nextLine());

      System.out.print("담당자? ");
      owner[i] = keyboardScan.nextLine();

      size++;

      System.out.print("계속 입력하시겠습니까?(y/N)");
      String te = keyboardScan.nextLine();
      if (te.equalsIgnoreCase("N") || te.equals("")) {
        break;
      }
    }

    keyboardScan.close();

    System.out.println("--------------------------");

    System.out.printf("%s\n", project);

    for (int i = 0; i < size; i++) {
      String stateLabel = null;
      switch (status[i]) {
        case 1:
          stateLabel = "진행중";
          break;
        case 2:
          stateLabel = "완료";
          break;
        default:
          stateLabel = "신규";
      }

      System.out.printf("%d, %s, %s, %s, %s\n",
          no[i], content[i], deadline[i], stateLabel, owner[i]);
    }
  }
}
