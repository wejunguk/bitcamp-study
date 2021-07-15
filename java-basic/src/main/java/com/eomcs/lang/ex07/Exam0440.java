package com.eomcs.lang.ex07;

//# 메서드 : 스택 메모리 응용 I
//
public class Exam0440 {

  static int m1(int value) { //value에 5 들어감
    int r1 = m2(value); //리턴된 값 r1에 저장됨
    int r2 = m3(value);
    return r1 + r2; //310 리턴함 어디로? 메인쪽으로
  }

  static int m2(int value) { //value에 5 들어감 
    return value + 100; // 105 리턴함
  }

  static int m3(int value) { //value에 5 들어감
    return value + 200; // 205리턴함
  }

  public static void main(String[] args) {
    int r = m1(5); // m1로컬변수 5 호출->m1이 만들어짐    m1(5)=310
    System.out.println(r);
  }
}
// JVM Stack 메모리의 사용
// 0) 시작
// 1) main()
// 2) main() => m1()
// 3) main() => m1() => m2()
// 4) main() => m1()
// 5) main() => m1() => m3()
// 6) main() => m1()
// 7) main()
// 8) 종료!