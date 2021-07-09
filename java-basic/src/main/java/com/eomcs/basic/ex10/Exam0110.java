package com.eomcs.basic.ex10;

public class Exam0110 {
  public static void main(String[] args) {
    java.util.Date d = new java.util.Date(); //java.util.date 설계도는 원하는 형식으로 만들어 주지 않음
    System.out.println(d.toString());
    System.out.printf("%tY-%tm-%td\n", d, d, d);//d 값중에서 년만 뽑고, 월만 뽑고 일만 뽑고
    // = System.out.printf("%tY-%1$tm-%1$td\n", d);
  }
}
