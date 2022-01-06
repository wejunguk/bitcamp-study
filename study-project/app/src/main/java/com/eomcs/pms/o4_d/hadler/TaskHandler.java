package com.eomcs.pms.o4_d.hadler;

import com.eomcs.pms.o4_d.domain.Task;
import com.eomcs.pms.o4_d.util.Prompt;

public class TaskHandler {

  static final int MAX_LENGTH = 5;

  static Task[] tasks = new Task[MAX_LENGTH];

  static int size = 0;

  public static void add() {
    System.out.println("[작업 등록]");

    Task task = new Task();

    task.no = Prompt.inputInt("번호? ");
    task.content = Prompt.inputString("내용? ");
    task.deadline = Prompt.inputDate("완료일? ");

    System.out.println("상태? ");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    task.status = Prompt.inputInt("> ");

    while (true) {
      String owner = Prompt.inputString("담당자?(취소: 빈 문자열) ");
      if (owner.length() == 0) {
        System.out.println("작업등록을 취소합니다.");
        return; // 현재 메서드 실행을 멈추고 리턴한다.
      } else if (MemberHandler.exist(owner)) {
        task.owner = owner;
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    tasks[size++] = task;
  }

  public static void list() {
    System.out.println("[작업 목록]");

    for (int i = 0; i < size; i++) {
      String stateLabel = null;
      switch (tasks[i].status) {
        case 1:
          stateLabel = "진행중";
          break;
        case 2:
          stateLabel = "완료";
          break;
        default:
          stateLabel = "신규";
      }

      System.out.printf("%d, %s, %s, %s, %s\n",
          tasks[i].no,
          tasks[i].content,
          tasks[i].deadline,
          stateLabel,
          tasks[i].owner);
    }
  }
}