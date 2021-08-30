package com.eomcs.pms;

import java.util.Date;
import java.util.Scanner;

public class App1_copy4 {
  public static void main(String[] args) {

    // 4. 배열과 반복문 적용 (for 반복문)
    // 여러문장에서 반복해서 사용하는 값은 변수에 담아서 사용한다.
    int[] no = new int[5];
    String[] name = new String[5];
    String[] email = new String[5];
    String[] password = new String[5];
    String[] photo = new String[5];
    String[] tel = new String[5];
    Date[] registeredDate = new Date[5];

    Scanner keyboardScan = new Scanner(System.in);
    java.sql.Date now = new java.sql.Date(System.currentTimeMillis());


    System.out.println("[회원]");

    for(int i=0; i<5; i=i+1) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());  
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

    for(int i=0;i<5; i=i+1){
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
