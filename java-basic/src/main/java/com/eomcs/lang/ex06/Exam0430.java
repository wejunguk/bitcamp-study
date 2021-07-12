package com.eomcs.lang.ex06;

// # 흐름 제어문 - for 중첩과 break
//
public class Exam0430 {
  public static void main(String[] args) {
    // for 문의 중첩
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) { // i가 3이면 j는 1에서 3까지
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }
}


