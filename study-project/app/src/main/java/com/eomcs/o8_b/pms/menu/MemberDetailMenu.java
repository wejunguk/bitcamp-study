package com.eomcs.o8_b.pms.menu;

import com.eomcs.o8_b.pms.hadler.MemberHandler;

//Composite 패턴에서 Leaf 역할을 할 메뉴 항목을 정의한다.
public class MemberDetailMenu extends Menu{

  MemberHandler memberHandler;

  public MemberDetailMenu(MemberHandler memberHandler) {
    super("상세보기");
    this.memberHandler = memberHandler;
  }

  @Override 
  public void execute() {
    memberHandler.detail(); 
  } 

}
