package com.eomcs.o10_b.pms.handler;

import com.eomcs.o10_b.pms.domain.Member;

public class MemberList extends ArrayList {

  public Member findByNo(int no) {
    Object[] arr = toArray();

    for (Object obj : arr) {
      Member member = (Member) obj;
      if (member.no == no) {
        return member;
      }
    }
    return null;
  }

  public boolean exist(String name) {
    Object[] arr = toArray();

    for (Object obj : arr) {
      Member member = (Member) obj;
      if (member.name.equals(name)) {
        return true;
      }
    }
    return false;
  }
}

