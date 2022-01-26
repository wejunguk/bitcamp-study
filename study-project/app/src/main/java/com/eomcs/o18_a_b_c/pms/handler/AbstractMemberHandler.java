package com.eomcs.o18_a_b_c.pms.handler;

import java.util.List;
import com.eomcs.o18_a_b_c.pms.domain.Member;

public abstract class AbstractMemberHandler implements Command {

  protected List<Member> memberList;

  public AbstractMemberHandler(List<Member> memberList) {
    this.memberList = memberList;
  }

  protected Member findByNo(int no) {
    for (Member member : memberList) {
      if (member.getNo() == no) {
        return member;
      }
    }
    return null;
  }
}







