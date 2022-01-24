package com.eomcs.o15.pms.handler;

import java.util.List;
import com.eomcs.o15.pms.domain.Board;
import com.eomcs.o15.util.Prompt;

public class BoardDeleteHandler extends AbstractBoardHandler {

  public BoardDeleteHandler(List<Board> boardList) {
    super(boardList);
  }


  public void execute() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    // 같은 클래스 안에 findByNo이 있기때문에
    // 바로 불러올 수 있다.
    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    if (board.getWriter().getNo() != AuthLoginHandler.getLoginUser().getNo()) {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    boardList.remove(board);


    System.out.println("게시글을 삭제하였습니다.");
  }

}







