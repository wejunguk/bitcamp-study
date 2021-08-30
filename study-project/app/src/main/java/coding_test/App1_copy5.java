package com.eomcs.pms;

import java.util.Date;
import java.util.Scanner;

public class App1_copy5 {
  public static void main(String[] args) {

    // 5. 조회용으로만 사용할 변수라면 상수로 사용
    int[] no = new int[5];
    String[] name = new String[5];
    String[] email = new String[5];
    String[] password = new String[5];
    String[] photo = new String[5];
    String[] tel = new String[5];
    Date[] registeredDate = new Date[5];


    Scanner keyboardScan = new Scanner(System.in);
    Date now = new Date(System.currentTimeMillis());

    System.out.println("[회원]");

    final int MAX_LENGTH = 3;

    for (int i = 0; i < MAX_LENGTH; i = i + 1) {

      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());   // 숫자만 문자열로 바꿔주는 명령어 사용
      System.out.print("이름? ");
      name[i] = keyboardScan.nextLine();
      System.out.print("이메일? ");
      email[i] = keyboardScan.nextLine();
      System.out.print("암호? ");
      password[i] = keyboardScan.nextLine();
      System.out.print("사진? ");
      photo[i] = keyboardScan.nextLine();
      System.out.print("전화? ");
      tel[i] = keyboardScan.nextLine();
      registeredDate[i] = new Date();
      System.out.println();
    }

    keyboardScan.close();

    // 출력창
    System.out.println("--------------------------------");


    for (int i = 0; i < MAX_LENGTH; i=i+1) {
      System.out.println("번호: " + no[i]);
      System.out.println("이름: " + name[i]);
      System.out.println("이메일: " + email[i]);
      System.out.printf("암호: %s\n", password[i]);
      System.out.printf("사진: %s\n", photo[i]);
      System.out.printf("전화: %s\n", tel[i]);
      System.out.printf("가입일: %s\n", registeredDate[i]);
      System.out.println();

    }
  }
}
