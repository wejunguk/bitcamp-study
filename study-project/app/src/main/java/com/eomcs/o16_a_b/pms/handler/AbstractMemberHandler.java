package com.eomcs.o16_a_b.pms.handler;

import java.util.List;
import com.eomcs.o16_a_b.pms.domain.Member;

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







