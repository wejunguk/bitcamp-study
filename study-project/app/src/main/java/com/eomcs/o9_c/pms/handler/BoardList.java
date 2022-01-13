package com.eomcs.o9_c.pms.handler;

import com.eomcs.o9_c.pms.domain.Board;

public class BoardList {
  static final int MAX_LENGTH = 5;
  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;


  public void add(Board board) { // board 객체 주소를 넣는다면
    this.boards[this.size++] = board;
  }

  public Board[] toArray() {
    Board[] arr = new Board[size]; // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다.
    for (int i = 0; i < size; i++) { // 배열에 저장된 값을 새 배열에 복사한다.
      arr[i] = boards[i]; // 새 배열에, 값이 담긴 배열만 담아라
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
    if (index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.boards[i - 1] = this.boards[i];
    }
    this.boards[--this.size] = null;

    return true;
  }

  // board 객체를 받아서
  // board객체가 몇번째에 저장되어 있는지 확인
  private int indexOf(Board board) {
    for (int i = 0; i < this.size; i++) {
      if (this.boards[i] == board) {
        return i;
      }
    }
    return -1;
  }
}
