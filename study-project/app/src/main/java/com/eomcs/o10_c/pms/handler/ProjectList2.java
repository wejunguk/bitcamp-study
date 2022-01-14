package com.eomcs.o10_c.pms.handler;

import com.eomcs.o10_c.pms.domain.Project;

public class ProjectList2 extends LinkedList {

  public Project findByNo(int no) {
    // 상속받은 메서드에 toArray()메서드가 있으니깐
    // toArray를 호출해서 Object타입의 list로 받아
    // node에 들어있는 걸 list 배열로 받아
    // 배열을 반복하면서 obj로 꺼내
    // 근데 여기서 형변환 필요함
    // 형변환 해줌
    Object[] list = toArray();
    for (Object obj : list) {
      Project project = (Project) obj;
      if (project.no == no) {
        return project;
      }
    }
    return null;

    //    Node node = head;
    //    while (node != null) {
    //      if (node.project.no == no) {
    //        return node.project;
    //      }
    //      node = node.next;
    //    }
    //    return null;
    //  }
  }
}

