package com.eomcs.o13_a_b_c_d.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.o13_a_b_c_d.pms.domain.Board;
import com.eomcs.o13_a_b_c_d.util.Prompt;

public class BoardHandler {


  // 주입받자 생성자를 통해! 의존객체 교체가 더 쉬어진다.
  // 실무는 타입을 추상이나 인터페이스로 사용한다.
  List<Board> boardList;

  // BoardHandler 만들때 List 객체 반드시 필요해. 넘겨줘
  // 안주면 BoardHandler 못 만들어!
  public BoardHandler(List<Board> boardList) {
    this.boardList = boardList;
  }

  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setRegisteredDate(new Date(System.currentTimeMillis()));

    // boardList에게 더해달라고해라. board객체를
    boardList.add(board);

  }

  public void list() {
    System.out.println("[게시글 목록]");

    // 현재 BoardList에 보관된 값을 담을 수 있는 만큼 크기의 배열을 생성한다. 
    Board[] boards = new Board[boardList.size()];

    // 배열을 파라미터로 넘겨서 값을 받아 온다.
    // => 넘겨 주는 배열의 크기가 충분하기 때문에 toArray()는 새 배열을 만들지 않을 것이다.
    boardList.toArray(boards);

    // 이렇게 제네릭이 적용된 List를 사용하면 
    // List에서 값을 꺼낼 때 마다 형변환 할 필요가 없어 프로그래밍이 편리하다.
    for (Board board : boards) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          board.getNo(), 
          board.getTitle(), 
          board.getWriter(),
          board.getRegisteredDate(),
          board.getViewCount(), 
          board.getLike());
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

    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter());
    System.out.printf("등록일: %s\n", board.getRegisteredDate());

    board.setViewCount(board.getViewCount() + 1);
    System.out.printf("조회수: %d\n", board.getViewCount());
  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", board.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.getContent()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.setTitle(title);
    board.setContent(content);
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
    // 일부러 BoardList에 들어 있는 배열 보다 작은 배열을 넘겨준다.
    // => 그러면 toArray()는 새 배열을 만들어 값을 저장한 후 리턴할 것이다.
    Board[] arr = boardList.toArray(new Board[0]);
    for (Board board : arr) {
      if (board.getNo() == no) {
        return board;
      }
    }
    return null;
  }

}







