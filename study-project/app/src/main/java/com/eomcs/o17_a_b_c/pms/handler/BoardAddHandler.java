package com.eomcs.o17_a_b_c.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.o17_a_b_c.pms.domain.Board;
import com.eomcs.o17_a_b_c.util.Prompt;

public class BoardAddHandler extends AbstractBoardHandler {

  public BoardAddHandler(List<Board> boardList) {
    super(boardList);
  }

  @Override
  public void execute(CommandRequest request) {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));

    board.setWriter(AuthLoginHandler.getLoginUser());
    board.setRegisteredDate(new Date(System.currentTimeMillis()));

    boardList.add(board);
  }
}







