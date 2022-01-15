package com.eomcs.pms.handler;

public class ArrayList implements List {
  static final int MAX_LENGTH = 5;

  // BoardList, MemberList, TaskList, ProjectList 중 어떤걸 사용할지 몰라서
  // 부모로 선언한다.
  Object[] list = new Object[MAX_LENGTH];
  int size = 0;

  public void add(Object obj) { // board 객체 주소를 넣는다면
    if (size == list.length) {
      Object[] arr = new Object[list.length + (list.length >> 1)];
      for (int i = 0; i < size; i++) {
        arr[i] = list[i];
      }
      list = arr; // boards에 저장된 옛날 배열 주소를 버리고 새 배열 주소를 저장한다.
    }
    // 그 리스트에(하나씩 증가될떄마다) obj를 저장한다.
    this.list[this.size++] = obj;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size]; // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다.
    for (int i = 0; i < size; i++) { // 배열에 저장된 값을 새 배열에 복사한다.
      arr[i] = list[i]; // 새 배열에, 값이 담긴 배열만 담아라
    }
    return arr; // 새 배열을 리턴한다.
  }

  // remove할 주소
  public boolean remove(Object obj) {
    int index = indexOf(obj);
    if (index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }
    this.list[--this.size] = null;

    return true;
  }

  private int indexOf(Object obj) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i] == obj) {
        return i;
      }
    }
    return -1;
  }

}
