package com.eomcs.o08_b.pms.menu;

import com.eomcs.o08_b.pms.hadler.TaskHandler;

//Composite 패턴에서 Leaf 역할을 할 메뉴 항목을 정의한다.
public class TaskAddMenu extends Menu {

  TaskHandler taskHandler;

  public TaskAddMenu(TaskHandler taskHandler) {
    super("등록");
    this.taskHandler = taskHandler;
  }

  @Override 
  public void execute() {
    taskHandler.add(); 
  } 
}

