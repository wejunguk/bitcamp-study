package com.eomcs;

public class method {
  // 두 값을 받아서 둘중에 큰 값을 반환하는 메서드를 작성하시오.
  long uk(long a, long b) {
    long result = 0;
    if (a > b) {
      result = a;
    } else {
      result = b;
    }
    return result;
  }

  //두 값을 받아서 둘중에 작은 값을 반환하는 메서드를 작성하시오. 
  //메서드 이름 설정
  long sunho (long a, long b) {
    long result = 0;
    if (a > b) {
      result = b;
    } else {
      result = a;
    }
    return result;
  }

}
