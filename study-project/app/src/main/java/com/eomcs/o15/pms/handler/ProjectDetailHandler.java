package com.eomcs.o15.pms.handler;

import java.util.List;
import com.eomcs.o15.pms.domain.Project;
import com.eomcs.o15.util.Prompt;

public class ProjectDetailHandler extends AbstractProjectHandler {

  public ProjectDetailHandler(List<Project> projectList) {
    super(projectList);
  }

  public void execute() {
    System.out.println("[프로젝트 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    System.out.printf("프로젝트명: %s\n", project.getTitle());
    System.out.printf("내용: %s\n", project.getContent());
    System.out.printf("시작일: %s\n", project.getStartDate());
    System.out.printf("종료일: %s\n", project.getEndDate());
    System.out.printf("만든이: %s\n", project.getOwner().getName());
    System.out.printf("팀원: %s\n", project.getMemberNames());
  }
}





