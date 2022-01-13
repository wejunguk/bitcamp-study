package com.eomcs.o08_b.pms.menu;

import com.eomcs.o08_b.pms.hadler.BoardHandler;

//Composite 패턴에서 Leaf 역할을 할 메뉴 항목을 정의한다.
public class BoardAddMenu extends Menu{

  BoardHandler boardHandler;

  public BoardAddMenu(BoardHandler boardHandler) {
    super("등록");
    this.boardHandler = boardHandler;
  }

  @Override 
  public void execute() {
    boardHandler.add(); 
  } 

}
