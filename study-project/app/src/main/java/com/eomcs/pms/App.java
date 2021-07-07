package com.eomcs.pms;

public class App {

  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    java.util.Scanner keyScan = new java.util.Scanner(keyboard);

    System.out.println("[회원]");
    System.out.print("번호 ");
    String number = keyScan.nextLine();

    System.out.print("이름 ");
    String name = keyScan.nextLine();

    System.out.print("이메일 ");
    String email = keyScan.nextLine();

    System.out.print("암호 ");
    String passward = keyScan.nextLine();

    System.out.print("사진 ");
    String photo = keyScan.nextLine();

    System.out.print("전화 ");
    String phone = keyScan.nextLine();

    java.sql.Date now = new java.sql.Date(System.currentTimeMillis());

    keyScan.close();
    System.out.println("---------------------------");
    System.out.println("번호: " + number);
    System.out.println("이름: " + name);
    System.out.println("이메일: " + email);
    System.out.printf("암호: %s\n", passward);
    System.out.printf("사진: %s\n", photo);
    System.out.printf("전화: %s\n ", phone);
    System.out.printf("가입일: %s\n", now);


  } 
}
