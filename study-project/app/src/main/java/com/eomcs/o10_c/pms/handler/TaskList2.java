package com.eomcs.o10_c.pms.handler;

import com.eomcs.o10_c.pms.domain.Task;

public class TaskList2 extends LinkedList {

  public Task findByNo(int no) {
    Object[] list = toArray();
    for (Object obj : list) {
      Task task = (Task) obj;
      if (task.no == no) {
        return task;
      }
    }
    return null;
  }
}