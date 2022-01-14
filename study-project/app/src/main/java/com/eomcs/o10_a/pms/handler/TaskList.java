package com.eomcs.o10_a.pms.handler;

import com.eomcs.o10_a.pms.domain.Task;

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
