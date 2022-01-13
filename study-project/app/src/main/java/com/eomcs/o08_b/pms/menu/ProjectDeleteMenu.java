package com.eomcs.o08_b.pms.menu;

import com.eomcs.o08_b.pms.hadler.ProjectHandler;

//Composite 패턴에서 Leaf 역할을 할 메뉴 항목을 정의한다.
public class ProjectDeleteMenu extends Menu {

  ProjectHandler projectHandler;

  public ProjectDeleteMenu(ProjectHandler projectHandler) {
    super("삭제");
    this.projectHandler = projectHandler;
  }

  @Override 
  public void execute() {
    projectHandler.delete(); 
  } 
}
