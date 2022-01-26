package com.eomcs.o16_a_b.pms.handler;

import java.util.List;
import com.eomcs.o16_a_b.pms.domain.Board;
import com.eomcs.o16_a_b.util.Prompt;

public class BoardSearchHandler extends AbstractBoardHandler {

  public BoardSearchHandler(List<Board> boardList) {
    super(boardList);
  }

  @Override
  public void execute() {
    System.out.println("[게시글 검색]");

    String input = Prompt.inputString("검색어? ");

    for (Board board : boardList) {
      if (!board.getTitle().contains(input) &&
          !board.getContent().contains(input) &&
          !board.getWriter().getName().contains(input)) {
        continue;
      }
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          board.getNo(), 
          board.getTitle(), 
          board.getWriter().getName(),
          board.getRegisteredDate(),
          board.getViewCount(), 
          board.getLike());
    }
  }
}







