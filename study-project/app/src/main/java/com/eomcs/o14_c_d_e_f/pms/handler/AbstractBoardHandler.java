package com.eomcs.o14_c_d_e_f.pms.handler;

import java.util.List;
import com.eomcs.o14_c_d_e_f.pms.domain.Board;

public abstract class AbstractBoardHandler implements Command {

  protected List<Board> boardList;

  // AbstractBoardHandler는 기본생성자를 사용하지 않고
  // List를 받는 boardList생성자를 사용한다.
  public AbstractBoardHandler(List<Board> boardList) {
    this.boardList = boardList;
  }

  // 같은 패키지와 자식클래스까지 사용 가능
  protected Board findByNo(int no) {
    for (Board board : boardList) {
      if (board.getNo() == no) {
        return board;
      }
    }
    return null;
  }
}







