package com.eomcs.o17_a_b_c.pms.handler;

import com.eomcs.o17_a_b_c.pms.domain.Project;
import com.eomcs.o17_a_b_c.pms.domain.Task;
import com.eomcs.o17_a_b_c.util.Prompt;

public abstract class AbstractTaskHandler implements Command {

  protected ProjectPrompt projectPrompt;

  public AbstractTaskHandler(ProjectPrompt projectPrompt) {
    this.projectPrompt = projectPrompt;
  }

  protected static void printTasks(Project project) {
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

  protected static String getStatusLabel(int status) {
    switch (status) {
      case 1: return "진행중";
      case 2: return "완료";
      default: return "신규";
    }
  }

  protected static int promptStatus() {
    return promptStatus(-1);
  }

  protected static int promptStatus(int status) {
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





