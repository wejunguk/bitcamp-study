package com.eomcs.coding_test4;

import java.sql.Date;

public class Project {

  static final int PROJECT_LENGTH = 1000;
  static int[] pNo = new int[PROJECT_LENGTH];
  static String[] pTitle = new String[PROJECT_LENGTH];
  static String[] pContent = new String[PROJECT_LENGTH];
  static Date[] pStartDate = new Date[PROJECT_LENGTH];
  static Date[] pEndDate = new Date[PROJECT_LENGTH];
  static String[] pOwner = new String[PROJECT_LENGTH];
  static String[] pMembers = new String[PROJECT_LENGTH];
  static int pSize = 0;

  static void add() {
    System.out.println("[프로젝트 등록]");

    pNo[pSize] = Prompt.inputInt("번호? ");
    pTitle[pSize] = Prompt.inputString("프로젝트명? ");
    pContent[pSize] = Prompt.inputString("내용? ");
    pStartDate[pSize] = Prompt.inputDate("시작일? ");
    pEndDate[pSize] = Prompt.inputDate("종료일? ");
    pOwner[pSize] = Prompt.inputString("만든이? ");
    pMembers[pSize] = Prompt.inputString("팀원? ");

    pSize++;
  }

  static void list() {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < pSize; i++) {
      // 번호, 프로젝트명, 시작일, 종료일, 만든이
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          pNo[i], pTitle[i], pStartDate[i], pEndDate[i], pOwner[i]);
    }
  }
