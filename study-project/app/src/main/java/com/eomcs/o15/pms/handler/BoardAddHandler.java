package com.eomcs.o15.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.o15.pms.domain.Board;
import com.eomcs.o15.util.Prompt;

public class BoardAddHandler extends AbstractBoardHandler {

  public BoardAddHandler(List<Board> boardList) {
    // super클래스에 List를 받는 boardList 생성자를 받는다.
    super(boardList);
  }

  public void execute() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(AuthLoginHandler.getLoginUser());
    board.setRegisteredDate(new Date(System.currentTimeMillis()));

    // boardList에게 더해달라고해라. board객체를
    boardList.add(board);

  }
}







