package com.eomcs.coding_test11.pms.handler;

import com.eomcs.pms.domain.Board;

public class BoardList {
  static final int MAX_LENGTH = 5;
  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;

  // add board 만들어서 집어넣어라
  public void add(Board board) {
    this.boards[this.size++] = board;
  }

  // 기존 배열을 다 주지 말고
  // 값이 들어있는 배열만 전달해주자!
  // 그래서 새로 코딩함
  public Board[] toArray() {
    Board[] arr = new Board[this.size];  // 배열에 저장된 값을 담을 새 배열을 만든다.
    for(int i = 0; i < this.size; i++) { // 배열에 저장된 값을 새 배열에 복사한다.
      arr[i] = boards[i];
    }
    return arr; // 새 배열을 리턴한다.
  }

  public Board findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (boards[i].no == no) {
        return boards[i];
      }
    }
    return null;
  }

  public boolean remove(Board board) {
    int index = indexOf(board);
    if(index == -1) {
      return false;
    }
    for (int i = index + 1; i < this.size; i++) {
      this.boards[i - 1] = this.boards[i];
    }
    this.boards[--this.size] = null;
    return true;
  }

  // 게시물 번호로 index 되어있는걸 Board로 수정함
  private int indexOf(Board board) {
    for (int i = 0; i < this.size; i++) {
      if (this.boards[i] == board) {
        return i;
      }
    }
    return -1;
  }
}
