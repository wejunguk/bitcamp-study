package com.eomcs.o18_a_b_c.pms.handler;

import java.util.List;
import com.eomcs.o18_a_b_c.pms.domain.Project;
import com.eomcs.o18_a_b_c.util.Prompt;

public class ProjectPrompt {

  protected List<Project> projectList;

  public ProjectPrompt(List<Project> projectList) {
    this.projectList = projectList;
  }

  public Project promptProject() {
    System.out.println("프로젝트:");
    for (Project project : projectList) {
      System.out.printf("  %d. %s\n", project.getNo(), project.getTitle());
    }
    while (true) {
      int projectNo = Prompt.inputInt("프로젝트 번호 선택? (취소: 0) ");
      if (projectNo == 0) {
        return null;
      }
      Project selectedProject = findByNo(projectNo);
      if (selectedProject != null) {
        return selectedProject;
      }
      System.out.println("프로젝트 번호가 옳지 않습니다.");
    }
  }

  protected Project findByNo(int no) {
    for (Project project : projectList) {
      if (project.getNo() == no) {
        return project;
      }
    }
    return null;
  }
}
