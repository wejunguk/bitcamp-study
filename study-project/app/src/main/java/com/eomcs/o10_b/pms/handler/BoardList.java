package com.eomcs.o10_b.pms.handler;

import com.eomcs.o10_b.pms.domain.Board;

public class BoardList extends ArrayList{

  public Board findByNo(int no) {

    Object[] arr = toArray(); // 상속받은 메소드중 toArray사용
    for (Object obj : arr) {
      // obj는 Object 타입이기 때문에
      // no 변수를 사용할 수가 없다.
      // 그리고 obj에 들어있는건 board객체가 맞다
      // 따라서 Board객체라고 형변환해서
      // board래퍼런스에 저장한다.
      // (Board) obj -> obj에 들어있는 주소는 board이다.
      Board board = (Board) obj;
      if (board.no == no) {
        return board;
      }
    }
    return null;
  }
}
