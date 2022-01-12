package com.eomcs.o8_b.pms.menu;

import com.eomcs.o8_b.pms.hadler.BoardHandler;

//Composite 패턴에서 Leaf 역할을 할 메뉴 항목을 정의한다.
public class BoardListMenu extends Menu{

  BoardHandler boardHandler;

  public BoardListMenu(BoardHandler boardHandler) {
    super("목록");
    this.boardHandler = boardHandler;
  }

  @Override 
  public void execute() {
    boardHandler.list(); 
  } 

}
