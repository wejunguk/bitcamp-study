package com.eomcs.pms;

import java.sql.Date;

public class App2 {

  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.println("[프로젝트]");

    System.out.print("번호? ");
    int number = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("프로젝트명? ");
    String projectName = keyboard.nextLine();

    System.out.print("내용? ");
    String text = keyboard.nextLine();

    System.out.println("시작일? ", format(now));
    

    System.out.println("종료일? ");

    System.out.print("만든이? ");
    String name = keyboard.nextLine();

    System.out.print("팀원? ");
    String team = keyboard.nextLine();

    System.out.print("--------------------------------");
    System.out.printf("번호:$d\n ", number);
    System.out.printf("프로젝트명:$s\n ", projectName);
    System.out.printf("내용: #s\n", text);
    System.out.println("시작일: " + "2020-01-01");
    System.out.println("종료일: " + "2020-12-31");
    System.out.printlnf("만든이: %s\n", name);
    System.out.printlnf("팀원: %s\n", team}
  }
}
