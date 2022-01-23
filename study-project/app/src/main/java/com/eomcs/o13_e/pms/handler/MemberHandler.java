package com.eomcs.o13_e.pms.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.o13_e.pms.domain.Member;
import com.eomcs.o13_e.util.Prompt;

public class MemberHandler {

  List<Member> memberList;

  public MemberHandler(List<Member> memberList) {
    this.memberList = memberList;


    Member testUser = new Member();
    testUser.setNo(1);
    testUser.setName("aaa");
    testUser.setEmail("aaa@test.com");
    testUser.setPassword("1111");
    testUser.setPhoto("aaa.gif");
    testUser.setTel("010-1111-1111");
    testUser.setRegisteredDate(new Date(System.currentTimeMillis()));


    memberList.add(testUser);

    testUser = new Member();
    testUser.setNo(2);
    testUser.setName("bbb");
    testUser.setEmail("bbb@test.com");
    testUser.setPassword("1111");
    testUser.setPhoto("bbb.gif");
    testUser.setTel("010-2222-2222");
    testUser.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(testUser);

    testUser = new Member();
    testUser.setNo(3);
    testUser.setName("ccc");
    testUser.setEmail("ccc@test.com");
    testUser.setPassword("3333");
    testUser.setPhoto("ccc.gif");
    testUser.setTel("010-3333-3333");
    testUser.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(testUser);

    testUser = new Member();
    testUser.setNo(4);
    testUser.setName("ddd");
    testUser.setEmail("ddd@test.com");
    testUser.setPassword("444");
    testUser.setPhoto("444.gif");
    testUser.setTel("010-4444-4444");
    testUser.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(testUser);
  }

  public void add() {
    System.out.println("[회원 등록]");

    Member member = new Member();

    member.setNo(Prompt.inputInt("번호? "));
    member.setName(Prompt.inputString("이름? "));
    member.setEmail(Prompt.inputString("이메일? "));
    member.setPassword(Prompt.inputString("암호? "));
    member.setPhoto(Prompt.inputString("사진? "));
    member.setTel(Prompt.inputString("전화? "));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(member);
  }

  public void list() {
    System.out.println("[회원 목록]");

    Member[] list = memberList.toArray(new Member[0]);

    for (Member member : list) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          member.getNo(), 
          member.getName(), 
          member.getEmail(), 
          member.getTel(), 
          member.getRegisteredDate());
    }
  }

  public void detail() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("사진: %s\n", member.getPhoto());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("등록일: %s\n", member.getRegisteredDate());
  }

  public void update() {
    System.out.println("[회원 변경]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String name = Prompt.inputString("이름(" + member.getName()  + ")? ");
    String email = Prompt.inputString("이메일(" + member.getEmail() + ")? ");
    String password = Prompt.inputString("암호? ");
    String photo = Prompt.inputString("사진(" + member.getPhoto() + ")? ");
    String tel = Prompt.inputString("전화(" + member.getTel() + ")? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.setName(name);
    member.setEmail(email);
    member.setPassword(password);
    member.setPhoto(photo);
    member.setTel(tel);

    System.out.println("회원을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    memberList.remove(member);

    System.out.println("회원을 삭제하였습니다.");
  }

  private Member findByNo(int no) {
    // iterator을 상속받은 memberList를 바로 사용할 수 있다.
    for (Member member : memberList) {
      if (member.getNo() == no) {
        return member;
      }
    }
    return null;
  }

  // memberList 인스턴스 변수 사용함 -> 스태틱메서드 될 수 없음
  private Member findByName(String name) {
    for (Member member : memberList) {
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }

  // 파라미터로 memberList를 받아서 name을 찾는것이다.
  // 인스턴스필드를 사용하지 않는다면 그 메소드는 static으로 만들어라
  private static Member findByName(String name, List<Member> memberList) {
    for (Member member : memberList) {
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }

  public boolean exist(String name) {
    for (Member member : memberList) {
      if (member.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  // findByName 인스턴스 변수를 사용한다 -> 스태틱 메서드 될 수 없음
  public Member promptMember(String label) {
    while (true) {
      String memberName = Prompt.inputString(label);
      if (memberName.length() == 0) {
        return null;
      }

      Member member = findByName(memberName);
      if (member != null) {
        return member;
      } else 
        System.out.println("등록된 회원이 아닙니다.");
    }
  }

  // 파라미터로 받은 값을 사용하고
  // 내부에서 호출하는 메서드도 스태틱메서드 -> 어떠한 인스턴스 메서드 사용하지 않음
  // 스태틱 메서드로 만든다.
  public static Member promptMember(String label, List<Member> memberList) {
    while (true) {
      String memberName = Prompt.inputString(label);
      if (memberName.length() == 0) {
        return null;
      }

      Member member = findByName(memberName, memberList);
      if (member != null) {
        return member;
      } else 
        System.out.println("등록된 회원이 아닙니다.");
    }
  }

  // Member목록 List리턴한다.
  public List<Member> promptMembers(String label) {
    ArrayList<Member> members = new ArrayList<>();

    // 존재하냐 존재하지 않느냐 코드
    while (true) {
      // memberName을 가지고 member를 찾는다.
      String memberName = Prompt.inputString(label);
      Member member = findByName(memberName);
      if (member != null) {
        // members 리스트에 현재 member를 등록시키다.
        members.add(member);
        continue;
      } else if (memberName.length() == 0) {
        break;
      } 
      System.out.println("등록된 회원이 아닙니다.");
    }
    // 멤버목록 List를 리턴
    return members;
  }
}







