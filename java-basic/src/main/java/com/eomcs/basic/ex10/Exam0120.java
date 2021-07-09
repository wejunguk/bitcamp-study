package com.eomcs.basic.ex10;

public class Exam0120 {
  public static void main(String[] args) {
    long millis = System.currentTimeMillis();
    System.out.println(millis);//현재 날짜를 일단 뽑아놓고 java.sql.Date를 사용함

    java.sql.Date d = new java.sql.Date(millis); //java.util.date 설계도는 원하는 형식으로 만들어 주지 않음
    System.out.println(d.toString());
  }
}
