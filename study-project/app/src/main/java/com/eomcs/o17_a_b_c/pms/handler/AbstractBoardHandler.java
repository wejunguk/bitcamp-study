package com.eomcs.o17_a_b_c.pms.handler;

import java.util.List;
import com.eomcs.o17_a_b_c.pms.domain.Board;

public abstract class AbstractBoardHandler implements Command {

  protected List<Board> boardList;

  public AbstractBoardHandler(List<Board> boardList) {
    this.boardList = boardList;
  }

  protected Board findByNo(int no) {
    for (Board board : boardList) {
      if (board.getNo() == no) {
        return board;
      }
    }
    return null;
  }
}







