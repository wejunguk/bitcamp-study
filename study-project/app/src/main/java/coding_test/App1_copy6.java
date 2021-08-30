package com.eomcs.pms;

import java.util.Date;
import java.util.Scanner;

public class App1_copy6 {
  public static void main(String[] args) {

    // 6. 특정조건문에 따라 반복을 멈춘다
    final int MAX_LENGTH = 100;

    int[] no = new int[MAX_LENGTH];
    String[] name = new String[MAX_LENGTH];
    String[] email = new String[MAX_LENGTH];
    String[] password = new String[MAX_LENGTH];
    String[] photo = new String[MAX_LENGTH];
    String[] tel = new String[MAX_LENGTH];
    Date[] registeredDate = new Date[MAX_LENGTH];


    Scanner keyboardScan = new Scanner(System.in);
    Date now = new Date(System.currentTimeMillis());

    int size = 0;

    System.out.println("[회원]");

    for (int i = 0; i < MAX_LENGTH; i = i + 1) {
      size = size + 1;

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
      System.out.println("계속 입력하시겠습니까? (y/N)");
      String input = keyboardScan.nextLine();
      if (input.equalsIgnoreCase("N") || input.equals("")) {
        break; //현재 반복한걸 멈추개=ㅔ
      }
    }

    //.equalsIgnoreCase 대소문자 상관없이 사용자가 입력한 값이랑 같은지 비교

    keyboardScan.close();

    // 출력창
    System.out.println("--------------------------------");


    for (int i = 0; i < size; i=i+1) {
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
