package com.eomcs.o8_b.pms.menu;

import com.eomcs.o8_b.pms.hadler.TaskHandler;

//Composite 패턴에서 Leaf 역할을 할 메뉴 항목을 정의한다.
public class TaskUpdateMenu extends Menu {

  TaskHandler taskHandler;

  public TaskUpdateMenu(TaskHandler taskHandler) {
    super("변경");
    this.taskHandler = taskHandler;
  }

  @Override 
  public void execute() {
    taskHandler.update(); 
  } 
}

