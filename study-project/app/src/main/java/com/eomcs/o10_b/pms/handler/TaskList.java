package com.eomcs.o10_b.pms.handler;

import com.eomcs.o10_b.pms.domain.Task;

public class TaskList extends ArrayList {

  public Task findByNo(int no) {

    Object[] arr = toArray();

    for (Object obj : arr) {
      Task task = (Task) obj;
      if (task.no == no) {
        return task;
      }
    }
    return null;
  }
}
