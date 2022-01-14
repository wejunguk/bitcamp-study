package com.eomcs.o09_e.pms.handler;

import com.eomcs.o09_e.pms.domain.Board;

public class BoardList2 {

  static class Node {
    Board board;
    Node next;

    public Node(Board board) {
      this.board = board;
    }
  }

  Node head;
  Node tail;
  int size = 0;


  public void add(Board board) { // board 객체 주소를 넣는다면
    Node node = new Node(board);

    if (head == null) {
      tail = head = node;
    } else {
      // 기존에 tail이 가리키는 마지막 노드의 next변수에 새 노드 주소를 저장한다.
      tail.next = node;

      // 새로 만든 node를 마지막 노드로 설정한다.
      tail = node;
    }

    size++;
  }

  public Board[] toArray() {
    // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다.
    Board[] arr = new Board[this.size]; 

    Node node = head;

    // i 값을 사용하기 때문에 for문을 사용한다.
    // int i = 0;
    // while (node != null) {
    //  arr[i++] = node.board
    //  node = node.next;
    //}

    for (int i = 0; i < this.size; i++) {
      arr[i] = node.board;
      node = node.next;
    }

    return arr; // 새 배열을 리턴한다.
  }

  public Board findByNo(int no) {
    Node node = head;
    while (node != null) { // node에 객체 주소가 들어있다면
      if (node.board.no == no) {
        return node.board;
      }
      node = node.next;
    }
    return null;
  }

  public boolean remove(Board board) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.board == board) { // 노드에 들어 있는 객체와 같다면
        if (node == head) { // 삭제할 노드가 하필이면 첫 번째 노드라면, 
          head = node.next; // head가 두 번째 노드를 가리키게 한다.
        } else { // 삭제할 노드가 첫 번째 노드가 아니라면
          prev.next = node.next; // 이전 노드를 다음 노드와 연결한다.
        }

        node.next = null; // 삭제할 노드가 더이상 다음 노드를 가리키지 않게 한다.

        if (node == tail) { // 삭제할 노드가 마지막 노드라면
          tail = prev; // tail이 이전 노드를 가리키게 한다.
        }
        size--;
        return true;
      }

      // 현재 노드가 아니라면,
      prev = node; // 현재 노드를 prev 에 저장하고,
      node = node.next; // node 는 다음 노드를 가리킨다.
    }

    return false;
  }
}
