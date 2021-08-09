package com.eomcs.oop.ex07.f;

// 추상 메서드만 있을 경우
// 객체 사용 규칙을 정의하는 "인터페이스" 문법으로 바꿔도 좋다.
public interface Sorter {


  // 인터페이스는 호출 규칙을 정의하는 것이기 때문에
  // 모든 메서드는 기본이 public이고, abstract 이다.
  // => 다음과 public과 abstract 
  void sort(int[] values);
}
