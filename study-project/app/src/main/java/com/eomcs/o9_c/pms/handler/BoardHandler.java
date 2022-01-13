package com.eomcs.o9_c.pms.handler;

import java.sql.Date;
import com.eomcs.o9_c.pms.domain.Board;
import com.eomcs.o9_c.util.Prompt;

public class BoardHandler {

  //BoardList를 사용하기 위해 BoardList 인스턴스 주소를 저장한다.
  BoardList boardList = new BoardList();

  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());

    // boardList에게 더해달라고해라. board객체를
    boardList.add(board);

  }

  public void list() {
    System.out.println("[게시글 목록]");
    Board[] list = boardList.toArray();

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          board.no, 
          board.title, 
          board.writer,
          board.registeredDate,
          board.viewCount, 
          board.like);
    }
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = boardList.findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("등록일: %s\n", board.registeredDate);
    System.out.printf("조회수: %d\n", ++board.viewCount);
  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = boardList.findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", board.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.title = title;
    board.content = content;
    System.out.println("게시글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    Board board = boardList.findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
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

  // BoardList에 옮기지 않으면 이렇게 사용해야 한다.
  //  private Board findByNo(int no) {
  //    Board[] list = boardList.toArray();
  //    for (Board board : list) {
  //      if (board.no == no) {
  //        return board;
  //      }
  //    }
  //    return null;
  //  }




}







