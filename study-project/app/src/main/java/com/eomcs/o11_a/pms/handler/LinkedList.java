package com.eomcs.o11_a.pms.handler;

public class LinkedList extends AbstractList {

  static class Node {
    // Project에서만 쓰는데 아니라 
    // 모든 list에서 사용할 수 있도록
    //    Project project;
    Object item;
    Node next;

    public Node(Object item) {
      this.item = item;
    }
  }

  Node head;
  Node tail;

  public void add(Object item) {

    Node node = new Node(item);

    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;

      tail = node;
    }

    size++;
  }

  // 어떤 객체 주소를 담을 수 있다.
  public Object[] toArray() {
    Object[] arr = new Object[this.size]; 

    Node node = head;

    for (int i = 0; i < this.size; i++) {
      arr[i] = node.item;
      node = node.next;
    }

    return arr; // 새 배열을 리턴한다.
  }

  public boolean remove(Object item) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.item == item) { // 노드에 들어 있는 객체와 같다면
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

  @Override
  public Object get(int index) {
    if (index < 0 || index >= this.size) { // 유효하지 않은 인덱스인 경우
      return null;
    }
    Node node = this.head;

    for (int i = 0; i < this.size; i++) {
      if (i == index) {
        return node.item;
      }
      node = node.next;
    }
    return null;
  }

  @Override
  public Object remove(int index) {

    if (index < 0 || index >= this.size) { // 무효한 인덱스라면
      return null;
    }

    Node node = head;
    Node prev = null;

    for (int i = 0; i < this.size; i++) {

      if (i == index) { // 삭제할 위치를 찾았다면
        Object deleted = node.item; // 삭제할 위치에 있는 값을 보관한다.

        if (node == head) { // 삭제할 노드가 하필이면 첫 번째 노드라면, 
          head = node.next; // head가 두 번째 노드를 가리키게 한다.
        } else { // 삭제할 노드가 첫 번째 노드가 아니라면
          prev.next = node.next; // 이전 노드를 다음 노드와 연결한다.
        }

        // 가비지 관리를 위해 삭제할 노드의 인스턴스 필드를 null 로 초기화 한다.
        node.item = null;
        node.next = null; 

        if (node == tail) { // 삭제할 노드가 마지막 노드라면
          tail = prev; // tail이 이전 노드를 가리키게 한다.
        }
        size--;
        return deleted;

      } else { // 삭제할 노드가 아니라면
        prev = node; // 현재 노드를 prev 에 저장하고,
        node = node.next; // node 는 다음 노드를 가리킨다.
      }
    }

    return null;
  }

}
