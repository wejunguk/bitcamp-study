package com.eomcs.coding_test2;

import java.util.Scanner;

//1)변경 준비
//2)사용자에게 명령 프롬포트 출력
//3)사용자의 명령의 입력 받아 출력
public class App_변경3 {

  public static void main(String[] args) {
    Scanner keyboardScan = new Scanner(System.in); //열었음 닫기 (1)

    System.out.print("명령> "); //줄바꿈 안되게 수정

    String input = keyboardScan.nextLine(); //한줄을 입력받아서
    System.out.println(input); //명령어 쓰면 그대로 출력함
    //•사용자가 입력한 명령어를 그대로 출력한다 ->썻으면 클로즈 해야함!
    keyboardScan.close(); // 맨위에 키보드스캔 열었음 닫아야지(1)

    /* System.out.println("[회원]");



    // 최대 입력 개수
    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] password = new String[LENGTH];
    String[] photo = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] registeredDate = new Date[LENGTH];

    int size = 0;

    for (int i = 0; i < LENGTH; i++) {
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

      registeredDate[i] = new java.sql.Date(System.currentTimeMillis());

      size++;
      System.out.println(); // 빈 줄 출력

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String str = keyboardScan.nextLine();
      if (!str.equalsIgnoreCase("y")) {
        break;
      }
      System.out.println(); // 빈 줄 출력
    }



    System.out.println("--------------------------------");

    for (int i = 0; i < size; i++) {
      // 번호, 이름, 이메일, 전화, 가입일
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          no[i], name[i], email[i], tel[i], registeredDate[i]);
    }
     */

  }
}
