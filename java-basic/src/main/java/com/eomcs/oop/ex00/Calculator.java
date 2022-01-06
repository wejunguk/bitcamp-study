package com.eomcs.oop.ex00;

public class Calculator {

  // 인스턴스 메소드에서 인스턴스 변수를 사용하면
  // 파라미터로 주소를 받지 않고 더 편리하게 사용할 수 있다.

  int result;

  void plus(int value) {
    this.result += value;
  }

  void minus(int value) {
    this.result -= value;
  }

  void multiple(int value) {
    this.result *= value;
  }
}
