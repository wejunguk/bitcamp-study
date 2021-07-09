package com.eomcs.pms;

import java.util.Date;
import java.util.Scanner;



//8 날짜의 출력형식을 "yyyy-MM-dd"로 출력한다
public class App {

  public static void main(String[] args) {
    System.out.println("[회원]");

    final int MAX_LENGTH = 100; //전체갯수

    int[] no = new int[MAX_LENGTH]; //maxLength는 숫자대신 쓰면 간편하다/입력한 값만큼 돔
    String[] name = new String[MAX_LENGTH];
    String[] email = new String[MAX_LENGTH];
    String [] photo = new String[MAX_LENGTH];
    String [] password = new String[MAX_LENGTH];
    String [] tell =new String[MAX_LENGTH];
    Date[] registeredDate = new Date[MAX_LENGTH];

    Scanner keyboardScan = new Scanner(System.in);

    int size = 0; //지정된 갯수만큼만 돌린다


    for (int i = 0; i < MAX_LENGTH; i = i + 1) {
      size = size + 1; // 1개가 입력되었으면 어딘가에 저장해둬라, 2개면 2개 입력해둬라

      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine()); // index 약자 i 사용
      System.out.print("이름? ");
      name[i] = keyboardScan.nextLine();
      System.out.print("이메일? ");
      email[i] = keyboardScan.nextLine();
      System.out.print("암호? ");
      password[i] = keyboardScan.nextLine();
      System.out.print("사진? ");
      photo[i] = keyboardScan.nextLine();
      System.out.print("전화? ");
      tell[i] = keyboardScan.nextLine();
      registeredDate[i] = new Date ();
      System.out.println();

      System.out.println("계속 입력하시겠습니까? (y/N)");
      String input = keyboardScan.nextLine();
      if (input.equalsIgnoreCase("N") || input.equals("")) { //input 의 값과 N의 값이 같으면 참, 다르면 false
        break;
      }
      System.out.println();
    }

    keyboardScan.close(); 

    System.out.println("--------------------------------");

    for (int i = 0; i < size; i= i + 1) {
      System.out.printf("%d, %s, %s, %s, %tY-%5$tm-%5$td\n", // 5$인 이유 -> printf에서 5번째 
          no[i],
          name[i],
          email[i],
          tell[i],
          registeredDate[i]);
    }
  }
}
