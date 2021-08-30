package com.eomcs.coding_test2;

import java.sql.Date;
import java.util.Scanner;

//1)변경 준비
//2)사용자에게 명령 프롬포트 출력
//3)사용자의 명령의 입력 받아 출력
//4)명령을 입력 받아 출력하는 것을 무한 반복
//5)exit나 quit 명령을 입력하면 반복 실행 중지
//6)/member/add와 /member/list 명령을 구분해보자
//7)/member/add 명령 처리
//8)/member/list 명령 처리
//9)project/add 명령 처리
//10)project/list 명령 처리
public class App_변경10 {

  public static void main(String[] args) {
    Scanner keyboardScan = new Scanner(System.in); //열었음 닫기 (1)
    // 회원 정보와 관련된 변수
    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] password = new String[LENGTH];
    String[] photo = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] registeredDate = new Date[LENGTH]; //빨간색 뜨면 ctrl+스페이스 눌러서 스캐너설정

    int size = 0;

    // 프로젝트 정보와 관련된 변수
    final int PROJECTLENGTH = 1000; //length 사용하면 안됨->회원정보는 100개인데 프로젝트 정보는 1000개일수있으니깐, 변수명이 같음, 변수명 수정

    int[]pNo = new int[PROJECTLENGTH];
    String[] pTitle = new String[PROJECTLENGTH];
    String[] pContent = new String[PROJECTLENGTH];
    Date[] pStarDate = new Date[PROJECTLENGTH];
    Date[] pEndDate = new Date[PROJECTLENGTH];
    String[] pOwner = new String[PROJECTLENGTH];
    String[] pMembers = new String[PROJECTLENGTH]; //빨간색 뜨면 ctrl+스페이스 눌러서 스캐너설정

    int pSize = 0; //변수명 선언한거


    while (true) {
      System.out.print("명령> ");

      String input = keyboardScan.nextLine(); //명령에 있는 값들을 키보드가 받아 무한출력

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) { //멤버 add를 출력하면
        System.out.println("[회원등록]");
        System.out.print("번호? ");
        no[size] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("이름? ");
        name[size] = keyboardScan.nextLine();

        System.out.print("이메일? ");
        email[size] = keyboardScan.nextLine();

        System.out.print("암호? ");
        password[size] = keyboardScan.nextLine();

        System.out.print("사진? ");
        photo[size] = keyboardScan.nextLine();

        System.out.print("전화? ");
        tel[size] = keyboardScan.nextLine();

        registeredDate[size] = new java.sql.Date(System.currentTimeMillis());

        size++;

      } else if (input.equals("/member/list")) {
        System.out.println("[회원목록]");
        for (int i = 0; i < size; i++) {
          // 번호, 이름, 이메일, 전화, 가입일
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              no[i], name[i], email[i], tel[i], registeredDate[i]);
        }

      } else if (input.equals("/project/add")) {
        System.out.println("[프로젝트등록]"); //project/add 했을때 이 조건을 불러와야 하니깐 여기다 붙여넣기

        System.out.print("번호? ");
        pNo[pSize] = Integer.valueOf(keyboardScan.nextLine()); //변수 에러 뜸 그냥 가져오면!, 위에 메모리 변수명을 보고 

        System.out.print("프로젝트명? ");
        pTitle[pSize] = keyboardScan.nextLine();

        System.out.print("내용? ");
        pContent[pSize] = keyboardScan.nextLine();

        System.out.print("시작일? ");
        pStarDate[pSize] = Date.valueOf(keyboardScan.nextLine());

        System.out.print("종료일? ");
        pEndDate[pSize] = Date.valueOf(keyboardScan.nextLine());

        System.out.print("만든이? ");
        pOwner[pSize] = keyboardScan.nextLine();

        System.out.print("팀원? ");
        pMembers[pSize] = keyboardScan.nextLine();

        pSize++;


      } else if (input.equals("/project/list")) {
        System.out.println("[프로젝트 목록]");
        for (int i = 0; i < size; i++) {
          // 번호, 프로젝트명, 시작일, 종료일, 만든이
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              pNo[i], pTitle[i], pStarDate[i], pEndDate[i], pOwner[i]);
        }


      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println(input); 

    }

    keyboardScan.close(); //위에 반복문이 종료되는 문장을 적음. 키보드 종료하는걸 넣을 수 있음
  }
}
