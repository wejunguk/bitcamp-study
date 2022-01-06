package com.eomcs.oop.ex00.p3;

public class Calculator {

  //결과를 여러개 유지할수 없다
  // 여러 결과 유지를 하려면 인스턴스변수를 사용해라
  // 인스턴스 변수를 사용하려면 인스턴스변수 주소를 받아야한다.

  int result;

  static void plus(Calculator that, int value) {
    that.result += value;

  }

  static void minus(Calculator that, int value) {
    that.result -= value;
  }

  static void multiple(Calculator that, int value) {
    that.result *= value;
  }
}
