package com.eomcs.lang.ex07;

//# 메서드 : call by reference II
//
public class Exam0330 {

  // main()에서 만든 int a와 int b의 값을 바꾸고 싶다면,
  // primitive data type 값을 직접 넘기지 말고 
  // 객체에 담아 넘겨라!
  static class MyObject { //->컴파일,별도의 파일로 만들어짐 처음에 로딩하지 않음
    int a;
    int b;
  }

  static void swap(MyObject ref) {
    System.out.printf("swap(): a=%d, b=%d\n", ref.a, ref.b);
    int temp = ref.a;
    ref.a = ref.b;
    ref.b = temp;
    System.out.printf("swap(): a=%d, b=%d\n", ref.a, ref.b);
  }

  public static void main(String[] args) {
    // MyObject 설계도에 따라 int a와 int b 메모리를 만든다.
    // 그리고 그 메모리(인스턴스=객체)의 주소를 ref 변수에 저장한다.
    // 래퍼런스에 저장된 주소는 모두 heap에 있는 메모리 주소다
    MyObject ref = new MyObject(); //MyObject 이걸 바로 로딩하지 않고 사용할때 로딩 함,  MyObject() 변수를 heap에 만들어라
    ref.a = 100;//.을 찍는 이유는
    ref.b = 200;

    // a, b 변수가 들어 있는 인스턴스(객체=메모리)의 주소를 
    // swap()에 넘긴다. => 그래서 "call by reference"인 것이다.
    swap(ref//3700); //JVM 스택에 swap 만들어짐
        System.out.printf("main(): a=%d, b=%d\n", ref.a, ref.b);
  }
}
