package com.eomcs.o13_e.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.o13_e.pms.domain.Member;
import com.eomcs.o13_e.pms.domain.Project;
import com.eomcs.o13_e.util.Prompt;

public class ProjectHandler {

  List<Project> projectList;
  MemberHandler memberHandler;

  public ProjectHandler(List<Project> projectList, MemberHandler memberHandler) {
    this.projectList = projectList;
    this.memberHandler = memberHandler;

  }

  public void add() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();

    project.setNo(Prompt.inputInt("번호? "));
    project.setTitle(Prompt.inputString("프로젝트명? "));
    project.setContent(Prompt.inputString("내용? "));
    project.setStartDate(Prompt.inputDate("시작일? "));
    project.setEndDate(Prompt.inputDate("종료일? "));
    project.setOwner(AuthHandler.getLoginUser());
    // promptMembers는 List를 리턴하고, setMembers 타입도 List이므로 사용할 수 있다.
    project.setMembers(memberHandler.promptMembers("팀원?(완료: 빈 문자열) "));

    projectList.add(project);

    System.out.println("프로젝트를 저장했습니다!");
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[프로젝트 목록]");

    for (Project project : projectList) {

      System.out.printf("%d, %s, %s ~ %s, %s, [%s]\n",
          project.getNo(), 
          project.getTitle(), 
          project.getStartDate(), 
          project.getEndDate(), 
          project.getOwner().getName(),
          // getMember는 List인데 getMembers에
          // member이름만 뽑아야 하는데 어떻게 하냐?..
          // 반복문을 돌려 getMembers에서 한개씩 꺼내서 출력하지 말고
          // 그 문자열을 만들어주는 메서드를 호출하자(getMemberName)
          getMemberNames(project.getMembers()));
    }
  }

  // project.getMembers()에 담긴 배열을 이름만 뽑아 문자열로 만들어달라!
  private String getMemberNames(List<Member> members) {
    StringBuilder names = new StringBuilder();
    for (Member member : members) {
      if (names.length() > 0) {
        names.append(",");
      }
      names.append(member.getName());
    }
    // names값을 문자열로 만들어 리턴해라
    return names.toString();
  }

  public void detail() {
    System.out.println("[프로젝트 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    System.out.printf("프로젝트명: %s\n", project.getTitle());
    System.out.printf("내용: %s\n", project.getContent());
    System.out.printf("시작일: %s\n", project.getStartDate());
    System.out.printf("종료일: %s\n", project.getEndDate());
    System.out.printf("만든이: %s\n", project.getOwner().getName());
    System.out.printf("팀원: %s\n", getMemberNames(project.getMembers()));
  }

  public void update() {
    System.out.println("[프로젝트 변경]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    if (project.getOwner().getNo() != AuthHandler.getLoginUser().getNo()) {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("프로젝트명(%s)? ", project.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", project.getContent()));
    Date startDate = Prompt.inputDate(String.format("시작일(%s)? ", project.getStartDate()));
    Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", project.getEndDate()));

    List<Member> members = memberHandler.promptMembers(String.format(
        "팀원(%s)?(완료: 빈 문자열) ", getMemberNames(project.getMembers())));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 변경을 취소하였습니다.");
      return;
    }

    project.setTitle(title);
    project.setContent(content);
    project.setStartDate(startDate);
    project.setEndDate(endDate);
    project.setMembers(members);

    System.out.println("프로젝트를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[프로젝트 삭제]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    if (project.getOwner().getNo() != AuthHandler.getLoginUser().getNo()) {
      System.out.println("삭제 권한이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }

    projectList.remove(project);

    System.out.println("프로젝트를 삭제하였습니다.");
  }

  public Project findByNo(int no) {
    for (Project project : projectList) {
      if (project.getNo() == no) {
        return project;
      }
    }
    return null;
  }

  public Project promptProject() {
    //  프로젝트를 선택해야한다.
    System.out.println("프로젝트: ");
    for (Project project : projectList) {
      System.out.printf(" %d. %s\n", project.getNo(), project.getTitle());
    }
    while (true) {
      int projectNo = Prompt.inputInt("프로젝트 번호선택?(취소: 0) ");
      //    Project selectedProject = projectList.get(projectNo);
      // projectNo 번호로 꺼낼 수 없다.
      // project.getNo() 으로 꺼내야 한다.
      // 프로젝트 번호로 프로젝트를 찾아야한다. -> findByNo 만듬
      if (projectNo == 0) {
        return null;
      }
      Project selectedProject = findByNo(projectNo);
      if (selectedProject != null) {
        return selectedProject;
      }
      System.out.println("프로젝트 번호가 옳지 않습니다.");
    }
  }

}





