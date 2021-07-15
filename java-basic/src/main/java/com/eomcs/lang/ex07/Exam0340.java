package com.eomcs.lang.ex07;

//# 메서드 : 레퍼런스를 리턴하기
//
public class Exam0340 {

  // swap()에서 만든 int a와 int b의 값을 main()에서 사용하기
  // primitive data type 값을 객체에 담아 넘겨라!

  static class MyObject {
    int a;
    int b;
  }

  static MyObject swap(int a, int b)// a,b는 swap넘겨줄때 담겨있는 변수=파라미터 {
  MyObject ref = new MyObject(); //MyObject 설계에에 따라서 heap에 저장하라, 근데 매서드에리어에 MyObject가 없음->MyObject 생성함
  ref.a = b; //파라미터 b값을 a에 넣어라
  ref.b = a;
  return ref//3700;
}

public static void main(String[] args) {
  int a = 100;
  int b = 200;

  MyObject ref = swap(a//100, b//200); //->a,에 값을 넣고swap을 돌아가고 나서 Myobject ref에 값을 넣음

      System.out.printf("main(): ref.a=%d, ref.b=%d\n", ref.a, ref.b//3700번지에 a,3700번지에b);
}
}
