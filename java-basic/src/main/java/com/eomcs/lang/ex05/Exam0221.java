// 관계 연산자 : 부동소수점 비교 
package com.eomcs.lang.ex05;

public class Exam0221 {
  public static void main(String[] args) {
    float f1 = 0.1f;
    float f2 = 0.1f;

    System.out.println(f1 * f2 == 0.01f); // false

    // 이유?
    System.out.println(f1 * f2); // 0.010000001 결과 값 뒤에 0.000000001 오차 발생! 뒤에 쓰레기 붙음 왜?
    //IEEE 때문에 딱 맞아 떨어지지 않아서 그렇다

    // 해결책?
    // => 오차를 제거한 후 비교
    // => 다만 계산 결과를 절대값으로 만든 후에 오차 이하의 값인지 비교하라!
    float r = f1 * f2 - 0.01f;
    System.out.println(Math.abs(r) <= Float.POSITIVE_INFINITY);
    //Float.POSITIVE_INFINITY ->EPSILON 값을 미리 정해놓은 것, 극한의 값을 정의
    //Math.abs 결과값이 음수가 나올 수도 있음, 그래서 두 수를 뺀 결과값을 일단 양수로 바꾼 후
    //최소값보다 작은걸
  }
}
