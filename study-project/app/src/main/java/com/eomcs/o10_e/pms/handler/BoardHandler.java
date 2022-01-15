package com.eomcs.o10_e.pms.handler;

import java.sql.Date;
import com.eomcs.o10_e.pms.domain.Board;
import com.eomcs.o10_e.util.Prompt;

public class BoardHandler {


  // 주입받자 생성자를 통해! 의존객체 교체가 더 쉬어진다.
  // 실무는 타입을 추상이나 인터페이스로 사용한다.
  List boardList;

  // BoardHandler 만들때 List 객체 반드시 필요해. 넘겨줘
  // 안주면 BoardHandler 못 만들어!
  public BoardHandler(List boardList) {
    this.boardList = boardList;
  }

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
    Object[] list = boardList.toArray();

    for (Object obj : list) {   // list에 들어있는건 Object의 주소
      // obj 배열에 들어있는 주소는 Board객체 주소 이기 때문에 형변환을 해서 사용해야한다.
      Board board = (Board) obj;
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

    Board board = findByNo(no);

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

    Board board = findByNo(no);

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

    // 같은 클래스 안에 findByNo이 있기때문에
    // 바로 불러올 수 있다.
    Board board = findByNo(no);


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

  private Board findByNo(int no) {

    // boardHandler를 상속받지 않았기 때문에
    // 정확한 인스턴스명을 지정해주고 toArray를 호출해야한다.
    Object[] arr = boardList.toArray();
    for (Object obj : arr) {
      Board board = (Board) obj;
      if (board.no == no) {
        return board;
      }
    }
    return null;
  }

}







