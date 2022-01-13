package com.eomcs.o05_a.pms.hadler;

import java.sql.Date;
import com.eomcs.o05_a.pms.domain.Board;
import com.eomcs.o05_a.util.Prompt;

public class BoardHandler5 {

  static final int MAX_LENGTH = 5;

  static Board[] boards = new Board[MAX_LENGTH];
  static int size = 0;

  public static void add() {
    System.out.println("[새 게시글5]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());
    //  board.viewCount = 0; // 인스턴스 변수는 생성되는 순간 기본 값이 0으로 설정된다.

    System.out.println("게시글을 등록하였습니다.");

    boards[size++] = board;
  }

  public static void list() {
    System.out.println("[게시글 목록5]");

    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n",
          boards[i].no,
          boards[i].title,
          boards[i].writer,
          boards[i].registeredDate,
          boards[i].viewCount,
          boards[i].like);
    }
  }


}
