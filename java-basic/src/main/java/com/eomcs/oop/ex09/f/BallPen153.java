package com.eomcs.oop.ex09.f;

// 다음 클래스를 말로 설명한다면?
// - BallPen153의 기본 기능은 Monami에서 받고
//   Pen 규칙에 따라 동장하도록 만든다.
public class BallPen153 extends Monami implements Pen {
  @Override
  public void write(String text) {
    if (!this.use) // !this.use -> 사용상태가 아니면 나가라(=return)/ this.use-> 사용상태면 나가라
      return;
    System.out.println("모나미 ** " + text + " **");
  }
}