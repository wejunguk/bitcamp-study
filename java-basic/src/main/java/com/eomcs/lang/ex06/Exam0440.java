package com.eomcs.lang.ex06;

// # 흐름 제어문 - for(;;) 와 배열
//
public class Exam0440 {
  public static void main(String[] args) {

    //  String[] names = new String[5]; 
    //    names[0] = "홍길동"; 
    //    names[1] = "임꺽정"; 
    //    names[2] = "유관순";
    //    names[3] = "윤봉길"; 
    //    names[4] = "안중근";

    //    String[] names;
    //    names = new String[] {"홍길동", "임꺽정", "유관순", "윤봉길", "안중근"};

    // 배열 변수 선언과 동시에 배열 초기화를 실행할 때는  new String[] 을 생략할 수 있다. 
    String[] names = {"홍길동", "임꺽정", "유관순", "윤봉길", "안중근"}; //배열 주소를 만드는 동시에
    //초기화된 변수를 담을것이냐!

    for (int i = 0; i < names.length; i++) // 0부터 4까지 length:는 5임
      System.out.println(names[i]);

  }
}
