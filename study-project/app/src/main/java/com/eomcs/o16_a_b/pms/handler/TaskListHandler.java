package com.eomcs.o16_a_b.pms.handler;

import com.eomcs.o16_a_b.pms.domain.Project;

public class TaskListHandler extends AbstractTaskHandler {

  public TaskListHandler(ProjectPrompt projectPrompt) {
    super(projectPrompt);
  }

  @Override
  public void execute() {
    System.out.println("[작업 목록]");

    Project project = projectPrompt.promptProject();
    if (project == null) {
      System.out.println("작업 등록을 취소합니다.");
      return;
    }

    printTasks(project);
  }
}





