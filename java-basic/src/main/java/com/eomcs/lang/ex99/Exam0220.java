package com.eomcs.lang.ex99;

//# 키보드 입력 받기 - 문자열 한 줄 읽기
//
public class Exam0220 {
  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in; //입력장치를 불러온다. 콘솔에 입력할 수 있는 창이 생긴다.System.in->키보드
    java.util.Scanner keyScan = new java.util.Scanner(keyboard); //Scanner->어떤 바이트로 불러올지 지정/ 
    //스캐너는 스스로 장비를 불어올 수 없음 

    // 팀 멤버의 정보를 입력 받아 출력하라.
    // 이름, 전화, 이메일, 나이, 재직여부
    // 예)
    // 이름? 홍길동
    // 홍길동
    // 전화? 1111-2222
    // 1111-2222
    // 이메일? hong@test.com
    // hong@test.com
    // 나이? 20
    // 20
    // 재직여부? y
    // y
    System.out.print("이름? ");
    System.out.println(keyScan.nextLine());
    System.out.print("전화? ");
    System.out.println(keyScan.nextLine());
    System.out.print("이메일? ");
    System.out.println(keyScan.nextLine());
    System.out.print("나이? ");
    System.out.println(keyScan.nextLine());
    System.out.print("재직여부? ");
    System.out.println(keyScan.nextLine());

    keyScan.close();
  }
}

