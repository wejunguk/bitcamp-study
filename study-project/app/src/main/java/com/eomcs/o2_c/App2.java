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

public class App2 {

  public static void main(String[] args) {

    System.out.println("[프로젝트]");

    Scanner keyboardScan = new Scanner(System.in);

    final int MAX_LENGTH = 100 ;

    int[] no = new int[MAX_LENGTH];
    String[] title = new String[MAX_LENGTH];
    String[] content = new String[MAX_LENGTH];
    Date[] startDate = new Date[MAX_LENGTH];
    Date[] endDate = new Date[MAX_LENGTH];
    String[] owner = new String[MAX_LENGTH];
    String[] members = new String[MAX_LENGTH];

    int size = 0;

    for (int i = 0; i < MAX_LENGTH; i++) {
      System.out.print("번호? ");
      no[i] = Integer.valueOf(keyboardScan.nextLine());

      System.out.print("프로젝트명? ");
      title[i] = keyboardScan.nextLine();

      System.out.print("내용? ");
      content[i] = keyboardScan.nextLine();

      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyboardScan.nextLine());

      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyboardScan.nextLine());

      System.out.print("만든이? ");
      owner[i] = keyboardScan.nextLine();

      System.out.print("팀원? ");
      members[i] = keyboardScan.nextLine();

      size++;
      System.out.println();

      System.out.println("계속 입력하시겠습니까?(y/N)");
      String te = keyboardScan.nextLine();
      //      if (te.equalsIgnoreCase("N") || te.equals("")) {
      //        break;
      //      }
      if (!te.equalsIgnoreCase("y")) {
        break;
      }
    }

    keyboardScan.close();

    System.out.println("------------------------");

    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s , %s, %s, %s, %s, %s\n" , 
          no[i],
          title[i],
          content[i],
          startDate[i],
          endDate[i],
          owner[i],
          members[i]);
    }



  }
}