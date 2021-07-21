package com.eomcs.pms.domain;

import java.sql.Date;

//한 회원의 데이터를 저장할 수 있도록
//새 구조의 데이터 타입(user defined data type)을 정의한다.
public class Board {
  public int no;
  public String title;
  public String content;
  public String wirte;
  public Date registeredDate;
  public int viewCount;
}