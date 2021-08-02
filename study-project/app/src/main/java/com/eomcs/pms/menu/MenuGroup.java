package com.eomcs.pms.menu;

public class MenuGroup extends Menu {
  Menu [] childs = new Menu[100];
  int size;

  @Override // 컴파일러에게 오버라이딩을 제대로 하는지 조사해 달라고 요구한다.
  public void execute() {

  }
}
