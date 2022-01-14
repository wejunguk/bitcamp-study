package com.eomcs.o10_c.pms.handler;

import com.eomcs.o10_c.pms.domain.Board;

public class BoardList2 extends LinkedList {

  public Board findByNo(int no) {
    Object[] list = toArray();
    for (Object obj : list) {
      Board board = (Board) obj;
      if (board.no == no) {
        return board;
      }
    }
    return null;
  }
}
