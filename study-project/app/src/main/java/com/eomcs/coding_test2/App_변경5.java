package com.eomcs.coding_test2;

import java.util.Scanner;

//1)변경 준비
//2)사용자에게 명령 프롬포트 출력
//3)사용자의 명령의 입력 받아 출력
//4)명령을 입력 받아 출력하는 것을 무한 반복
//5)exit나 quit 명령을 입력하면 반복 실행 중지
public class App_변경5 {

  public static void main(String[] args) {
    Scanner keyboardScan = new Scanner(System.in); //열었음 닫기 (1)

    while (true) {
      System.out.print("명령> ");

      String input = keyboardScan.nextLine(); //명령에 있는 값들을 키보드가 받아 무한출력

      if (input.equals("exit") || input.equals("quit")) {
        break;
      } //exit 나 quit를 누르면 멈춤

      System.out.println(input); 
    }
    //이렇게 해서 출력하면 무한으로 출력된다. 그럼 나가는 방법은?

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
    keyboardScan.close(); //위에 반복문이 종료되는 문장을 적음. 키보드 종료하는걸 넣을 수 있음
  }
}
