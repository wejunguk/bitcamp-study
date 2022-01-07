package com.eomcs.o2_c;

import java.util.Date;
import java.util.Scanner;


public class App {

  public static void main(String[] args) {
    System.out.println("[회원]");

    final int MAX_LENGTH = 5;

    int[] no = new int[MAX_LENGTH];
    String[] name = new String[MAX_LENGTH];
    String[] email = new String[MAX_LENGTH];
    String[] password = new String[MAX_LENGTH];
    String[] photo = new String[MAX_LENGTH];
    String[] phone = new String[MAX_LENGTH];
    Date[] registeredDate = new Date[MAX_LENGTH];

    int size = 0;

    Scanner keyboardScan = new Scanner(System.in);

    for (int i = 0; i < MAX_LENGTH; i++) {
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
      phone[i] = keyboardScan.nextLine();

      registeredDate[i] = new java.sql.Date(System.currentTimeMillis());

      size++;

      System.out.println("계속 입력하시겠습니까?(y/N)");
      String pro = keyboardScan.nextLine();
      if (pro.equalsIgnoreCase("N") || pro.equals(" ")) {
        break;
      }
    }

    keyboardScan.close();

    System.out.println("-----------------------");

    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          no[i], name[i], email[i], phone[i], registeredDate[i]);
    }
  }
}
