package com.eomcs.o09_e.pms.handler;

import com.eomcs.o09_e.pms.domain.Task;

public class TaskList2 {

  static class Node {
    Task task;
    Node next;

    public Node(Task task) {
      this.task = task;
    }
  }

  Node head;
  Node tail;
  int size = 0;

  public void add(Task task) {
    // 새 노드를 만든다. 생성자를 호출할 때, 노드에 담을 Task 객체 주소를 넘긴다. 
    Node node = new Node(task);

    if (head == null) {
      tail = head = node;
    } else {
      // 기존에 tail이 가리키는 마지막 노드의 next 변수에 새 노드 주소를 저장한다.
      tail.next = node;

      // 새로 만든 노드를 마지막 노드로 설정한다. 
      tail = node;
    }

    size++;
  }

  public Task[] toArray() {
    // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다.
    Task[] arr = new Task[this.size]; 

    Node node = head;

    for (int i = 0; i < this.size; i++) {
      arr[i] = node.task;
      node = node.next;
    }

    return arr; // 새 배열을 리턴한다.
  }

  public Task findByNo(int no) {
    Node node = head;
    while (node != null) {
      if (node.task.no == no) {
        return node.task;
      }
      node = node.next;
    }
    return null;
  }

  public boolean remove(Task task) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.task == task) { // 노드에 들어 있는 객체와 같다면
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