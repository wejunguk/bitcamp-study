package com.eomcs.o8_b.pms.menu;

import com.eomcs.o8_b.pms.hadler.BoardHandler;

//Composite 패턴에서 Leaf 역할을 할 메뉴 항목을 정의한다.
public class BoardUpdateMenu extends Menu{

  BoardHandler boardHandler;

  public BoardUpdateMenu(BoardHandler boardHandler) {
    super("변경");
    this.boardHandler = boardHandler;
  }

  @Override 
  public void execute() {
    boardHandler.update(); 
  } 

}
