package com.eomcs.o08_b.pms.menu;

import com.eomcs.o08_b.pms.hadler.ProjectHandler;

//Composite 패턴에서 Leaf 역할을 할 메뉴 항목을 정의한다.
public class ProjectDetailMenu extends Menu {

  ProjectHandler projectHandler;

  public ProjectDetailMenu(ProjectHandler projectHandler) {
    super("상세보기");
    this.projectHandler = projectHandler;
  }

  @Override 
  public void execute() {
    projectHandler.detail(); 
  } 
}

