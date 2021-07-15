package com.eomcs.algorithm.quiz;

public class Text {
  public static int divisorsPairs(int[] sequence) {
    int pairs = 0;
    for (int i = 0; i < sequence.length; i++) {
      for (int j = i + 1; j < sequence.length; j++) {
        System.out.printf("%d\n", sequence[i]);
        if (sequence[i] % sequence[j] ==0 || sequence[j] % sequence[i] ==0) {
          pairs++;
        }
      }
    }

    return pairs++;
  }

  public static void main(String[] args) {
    int[] values = {8, 4, 2, 3, 6, 10, 5};
    System.out.println(divisorsPairs(values));
  }
}








/*static int countEventNumber(int value) {
    int result = 0;//2)1
    int n = value; //1)1238694636
    while(n != 0) {
      if ((n % 2) == 0) {
        result++;
      }
      n /= 10; //->10으로 누면 마지막 날아감, 정수/정수는 정수여서, 어떤 정수값을 10으로 나누면 소수점 밑 날아감->정수 나누기 정수는 정수됨
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(countEventNumber(1238694636));

  }*/

