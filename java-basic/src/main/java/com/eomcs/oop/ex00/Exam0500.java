package com.eomcs.oop.ex00;

import com.eomcs.oop.ex00.util.Calculator;

//1) 계산하는 메소드를 한 클래스에서 관리한다.
public class Exam0500 {

  public static void main(String[] args) {
    //
    // 식1) 2 + 3 - 1 * 7 / 3 = ?
    // 식2) 3 * 2 + 7 / 4 - 5 = ?

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    c1.plus(2);
    c2.plus(3);

    c1.plus(3);
    c2.multiple(2);

    c1.minus(1);
    c2.plus(7);

    c1.multiple(7);
    c2.divide(4);

    c1.divide(3);
    c2.minus(5);

    System.out.printf("c1.result = %d\n", c1.result);
    System.out.printf("c2.result = %d\n", c2.result);
  }
}

// 수정 전
//  public static void main(String[] args) {
//    // 2 + 3 - 1 * 7 / 3 = ?
//
//    // 계산 결과를 담을 변수를 준비한다.
//    int result = 0;
//
//    result = plus(2, 3);
//    result = minus(result, 1);
//    result = multiple(result, 7);
//    result = divide(result, 3);
//
//    System.out.printf("result = %d\n", result);
//  }
//
//  static int plus(int a, int b) {
//    return a + b;
//  }
//
//  static int minus(int a, int b) {
//    return a - b;
//  }
//
//  static int multiple(int a, int b) {
//    return a * b;
//  }
//
//  static int divide(int a, int b) {
//    return a / b;
//  }
//}

// 수정 후
//  public static void main(String[] args) {
//
//    // 식1) 2 + 3 - 1 * 7 / 3 = ?
//    // 식2) 3 * 2 + 7 / 4 - 5 = ?
//
//    Calculator c1 = new Calculator();
//    Calculator c2 = new Calculator();
//
//    c1.plus(2);
//    c2.plus(3);
//
//    c1.plus(3);
//    c2.multiple(2);
//
//    c1.minus(1);
//    c2.plus(7);
//
//    c1.multiple(7);
//    c2.divide(4);
//
//    c1.divide(3);
//    c2.minus(5);
//
//    System.out.printf("result = %d\n", c1.result);
//    System.out.printf("result = %d\n", c2.result);
//  }
//}
