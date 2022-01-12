package com.eomcs.o8_b.pms.menu;

import com.eomcs.o8_b.pms.hadler.TaskHandler;

//Composite 패턴에서 Leaf 역할을 할 메뉴 항목을 정의한다.
public class TaskDeleteMenu extends Menu {

  TaskHandler taskHandler;

  public TaskDeleteMenu(TaskHandler taskHandler) {
    super("삭제");
    this.taskHandler = taskHandler;
  }

  @Override 
  public void execute() {
    taskHandler.delete(); 
  } 
}

