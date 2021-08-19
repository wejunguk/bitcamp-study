package com.eomcs.pms.handler;

public interface List {
  void add(Object item);
  Object[] toArray();
  boolean remove(Object obj);
  int size (); //목록에 리턴하는 사이즈의 갯수 규칙 추가
  Object get(int index); // 게시글을 가지고 올때 사용
  Object remove(int index); // 삭제한 객체 주소를 리턴
}









