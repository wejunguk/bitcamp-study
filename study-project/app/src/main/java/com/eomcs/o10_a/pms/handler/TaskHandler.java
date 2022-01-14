package com.eomcs.o10_a.pms.handler;

import java.sql.Date;
import com.eomcs.o10_a.pms.domain.Task;
import com.eomcs.o10_a.util.Prompt;

public class TaskHandler {


  // TaskList는 자기 자신이 사용하는 것이기 때문에
  // new를 선언해 자기가 만들어 사용하고
  TaskList taskList = new TaskList();
  //MemberList는 자신이 사용하는 것이 아니기 때문에
  // 생성자로 받아서 사용한다.
  MemberList memberList;

  public TaskHandler(MemberList memberList) {
    this.memberList = memberList;
  }

  public void add() {
    System.out.println("[작업 등록]");

    Task task = new Task();

    task.no = Prompt.inputInt("번호? ");
    task.content = Prompt.inputString("내용? ");
    task.deadline = Prompt.inputDate("마감일? ");
    task.status = promptStatus();
    task.owner = promptOwner("담당자?(취소: 빈 문자열) ");
    if (task.owner == null) {
      System.out.println("작업 등록을 취소합니다.");
      return; 
    }
    taskList.add(task);

  }

  public void list() {
    System.out.println("[작업 목록]");

    Object[] list = taskList.toArray();

    for (Object obj : list) {
      Task task = (Task) obj;
      System.out.printf("%d, %s, %s, %s, %s\n",
          task.no, 
          task.content, 
          task.deadline, 
          getStatusLabel(task.status), 
          task.owner);
    }
  }

  public void detail() {
    System.out.println("[작업 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Task task = taskList.findByNo(no);
    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    System.out.printf("내용: %s\n", task.content);
    System.out.printf("마감일: %s\n", task.deadline);
    System.out.printf("상태: %s\n", getStatusLabel(task.status));
    System.out.printf("담당자: %s\n", task.owner);
  }

  // update()가 사용할 MemberHandler 는 
  // 인스턴스 변수에 미리 주입 받기 때문에 파라미터로 받을 필요가 없다.
  public void update() {
    System.out.println("[작업 변경]");
    int no = Prompt.inputInt("번호? ");

    Task task = taskList.findByNo(no);
    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", task.content));
    Date deadline = Prompt.inputDate(String.format("마감일(%s)? ", task.deadline));
    int status = promptStatus(task.status);
    String owner = promptOwner(String.format(
        "담당자(%s)?(취소: 빈 문자열) ", task.owner));
    if (owner == null) {
      System.out.println("작업 변경을 취소합니다.");
      return;
    }

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 변경을 취소하였습니다.");
      return;
    }

    task.content = content;
    task.deadline = deadline;
    task.status = status;
    task.owner = owner;

    System.out.println("작업를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[작업 삭제]");
    int no = Prompt.inputInt("번호? ");

    Task task = taskList.findByNo(no);
    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 삭제를 취소하였습니다.");
      return;
    }

    taskList.remove(task);
    System.out.println("작업를 삭제하였습니다.");
  }

  private String getStatusLabel(int status) {
    switch (status) {
      case 1: return "진행중";
      case 2: return "완료";
      default: return "신규";
    }
  }

  private String promptOwner(String label) {
    while (true) {
      String owner = Prompt.inputString(label);
      // MemberHandler의 인스턴스는 미리 인스턴스 변수에 주입 받은 것을 사용한다.
      if (this.memberList.exist(owner)) {
        return owner;
      } else if (owner.length() == 0) {
        return null;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  private int promptStatus() {
    return promptStatus(-1);
  }

  private int promptStatus(int status) {
    if (status == -1) {
      System.out.println("상태?");
    } else {
      System.out.printf("상태(%s)?\n", getStatusLabel(status));
    }
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    return Prompt.inputInt("> ");
  }

}





