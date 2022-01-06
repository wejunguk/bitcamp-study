package com.eomcs.oop.ex00.p2;

public class Calculator {
  //계산결과를 내부에서 관리하기 때문에
  // 파라미터로 받을 필요가 없다.

  static int result;

  static void plus(int value) {
    result += value;
  }

  static void minus(int value) {
    result -= value;
  }

  static void multiple(int value) {
    result *= value;
  }
}
