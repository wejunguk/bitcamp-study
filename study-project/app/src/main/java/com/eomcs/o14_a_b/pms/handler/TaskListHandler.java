package com.eomcs.o14_a_b.pms.handler;

import com.eomcs.o14_a_b.pms.domain.Project;

public class TaskListHandler extends AbstractTaskHandler {

  public TaskListHandler(AbstractProjectHandler projectHandler) {
    super(projectHandler);
  }

  public void list() {
    System.out.println("[작업 목록]");

    Project project = projectHandler.promptProject();
    if (project == null) {
      System.out.println("작업 등록을 취소합니다.");
      return;
    }

    printTasks(project);
  }
}





