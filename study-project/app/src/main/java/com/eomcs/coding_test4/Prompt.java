package com.eomcs.coding_test4;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {

  static Scanner keyboardScan = new Scanner(System.in);

  //사용자로부터 문자열을 입력 받아 리턴한다.
  static String inputString(String title) {
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  // 사용자로부터 숫자를 입력 받아 리턴한다.
  static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }

  // 사용자로부터 날짜를 입력 받아 리턴한다.
  static Date inputtDate(String title) {
    return Date.valueOf(inputString(title));
  }

  //자원을 닫는 일은 그 자 원을 가지고 있는 클래스에서 해야 한다.
  static void close () {
    keyboardScan.close();
  }
}
