package com.eomcs.o13_e.pms.handler;

import java.sql.Date;
import com.eomcs.o13_e.pms.domain.Member;
import com.eomcs.o13_e.pms.domain.Project;
import com.eomcs.o13_e.pms.domain.Task;
import com.eomcs.o13_e.util.Prompt;

public class TaskHandler {

  // 더이상 TaskHandler에서는 memberHandler의 인스턴스가 필요하지 않다.
  // 파라미터라 받지 않는다. 삭제함
  ProjectHandler projectHandler;

  public TaskHandler(ProjectHandler projectHandler) {
    this.projectHandler = projectHandler;
  }

  public void add() {
    System.out.println("[작업 등록]");

    Project project = projectHandler.promptProject();
    if (project == null) {
      System.out.println("작업 등록을 취소합니다.");
      return;
    }

    if (project.getOwner().getNo() != AuthHandler.getLoginUser().getNo()) {
      System.out.println("이 프로젝트의 관리자가 아닙니다.");
      return;
    }

    Task task = new Task();

    task.setProject(project);
    task.setNo(Prompt.inputInt("작업번호? "));
    task.setContent(Prompt.inputString("내용? "));
    task.setDeadline(Prompt.inputDate("마감일? "));
    task.setStatus(promptStatus());
    task.setOwner(MemberHandler.promptMember("담당자?(취소: 빈 문자열) ", project.getMembers()));
    if (task.getOwner() == null) {
      System.out.println("작업 등록을 취소합니다.");
      return; 
    }

    project.getTasks().add(task);

    System.out.println("작업을 등록했습니다.");
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[작업 목록]");

    Project project = projectHandler.promptProject();
    if (project == null) {
      System.out.println("작업 등록을 취소합니다.");
      return;
    }

    printTasks(project);
  }

  private void printTasks(Project project) {
    // 특정 프로젝트의 작업목록 출력
    System.out.printf("%s:\n\n", project.getTitle());
    for (Task task : project.getTasks()) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          task.getNo(), 
          task.getContent(), 
          task.getDeadline(), 
          getStatusLabel(task.getStatus()), 
          task.getOwner().getName());
    }
  }

  public void detail() {
    System.out.println("[작업 상세보기]");

    Project project = projectHandler.promptProject();
    if (project == null) {
      System.out.println("작업 조회를 취소합니다.");
      return;
    }

    printTasks(project);

    System.out.println("----------------------------------");
    int taskNo = Prompt.inputInt("작업 번호? ");

    // taskHandler는 자체적으로 작업목록을 가지고 있지 않고
    // project에 담겨있기 때문에
    // Project에 담겨있는걸 꺼내와야 한다.
    Task task = findByNo(project, taskNo);
    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    System.out.printf("내용: %s\n", task.getContent());
    System.out.printf("마감일: %s\n", task.getDeadline());
    System.out.printf("상태: %s\n", getStatusLabel(task.getStatus()));
    System.out.printf("담당자: %s\n", task.getOwner().getName());
  }

  public void update() {
    System.out.println("[작업 변경]");

    Project project = projectHandler.promptProject();
    if (project == null) {
      System.out.println("작업 변경을 취소합니다.");
      return;
    }

    if (project.getOwner().getNo() != AuthHandler.getLoginUser().getNo()) {
      System.out.println("이 프로젝트의 관리자가 아닙니다.");
      return;
    }

    printTasks(project);

    System.out.println("----------------------------------");

    int taskNo = Prompt.inputInt("변경할 작업 번호? ");

    Task task = findByNo(project, taskNo);
    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", task.getContent()));
    Date deadline = Prompt.inputDate(String.format("마감일(%s)? ", task.getDeadline()));
    int status = promptStatus(task.getStatus());
    // 스태틱메서드는 정확한 클래스명으로 호출하자
    Member owner = MemberHandler.promptMember(
        String.format("담당자(%s)?(취소: 빈 문자열) ", task.getOwner().getName()),
        project.getMembers());
    if (owner == null) {
      System.out.println("작업 변경을 취소합니다.");
      return;
    }

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 변경을 취소하였습니다.");
      return;
    }

    task.setContent(content);
    task.setDeadline(deadline);
    task.setStatus(status);
    task.setOwner(owner);

    System.out.println("작업를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[작업 삭제]");

    Project project = projectHandler.promptProject();
    if (project == null) {
      System.out.println("작업 삭제 취소합니다.");
      return;
    }

    if (project.getOwner().getNo() != AuthHandler.getLoginUser().getNo()) {
      System.out.println("이 프로젝트의 관리자가 아닙니다.");
      return;
    }

    printTasks(project);

    System.out.println("----------------------------------");

    int taskNo = Prompt.inputInt("삭제할 작업 번호? ");

    Task task = findByNo(project, taskNo);
    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 삭제를 취소하였습니다.");
      return;
    }

    project.getTasks().remove(task);

    System.out.println("작업를 삭제하였습니다.");
  }

  private String getStatusLabel(int status) {
    switch (status) {
      case 1: return "진행중";
      case 2: return "완료";
      default: return "신규";
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

  private Task findByNo(Project project, int taskNo) {
    for (Task task : project.getTasks()) {
      if (task.getNo() == taskNo) {
        return task;
      }
    }
    return null;
  }

}





