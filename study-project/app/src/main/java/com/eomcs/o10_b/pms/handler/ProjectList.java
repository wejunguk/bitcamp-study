package com.eomcs.o10_b.pms.handler;

import com.eomcs.o10_b.pms.domain.Project;

public class ProjectList extends ArrayList {

  public Project findByNo(int no) {
    Object[] arr = toArray();

    for (Object obj : arr) {
      Project project = (Project) obj;
      if (project.no == no) {
        return project;
      }
    }
    return null;
  }
}
