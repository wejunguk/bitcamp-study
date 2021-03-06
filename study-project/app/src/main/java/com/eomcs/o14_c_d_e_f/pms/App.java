package com.eomcs.o14_c_d_e_f.pms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import com.eomcs.o14_c_d_e_f.menu.Menu;
import com.eomcs.o14_c_d_e_f.menu.MenuGroup;
import com.eomcs.o14_c_d_e_f.pms.domain.Board;
import com.eomcs.o14_c_d_e_f.pms.domain.Member;
import com.eomcs.o14_c_d_e_f.pms.domain.Project;
import com.eomcs.o14_c_d_e_f.pms.handler.AuthLoginHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.AuthLogoutHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.AuthUserInfoHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.BoardAddHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.BoardDeleteHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.BoardDetailHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.BoardListHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.BoardSearchHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.BoardUpdateHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.Command;
import com.eomcs.o14_c_d_e_f.pms.handler.MemberAddHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.MemberDeleteHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.MemberDetailHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.MemberListHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.MemberPrompt;
import com.eomcs.o14_c_d_e_f.pms.handler.MemberUpdateHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.ProjectAddHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.ProjectDeleteHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.ProjectDetailHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.ProjectListHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.ProjectPrompt;
import com.eomcs.o14_c_d_e_f.pms.handler.ProjectUpdateHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.TaskAddHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.TaskDeleteHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.TaskDetailHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.TaskListHandler;
import com.eomcs.o14_c_d_e_f.pms.handler.TaskUpdateHandler;
import com.eomcs.o14_c_d_e_f.util.Prompt;

public class App {
  List<Board> boardList = new ArrayList<>();
  List<Member> memberList = new LinkedList<>();
  List<Project> projectList = new ArrayList<>();

  HashMap<String,Command> commandMap = new HashMap<>();
  MemberPrompt memberPrompt = new MemberPrompt(memberList);
  ProjectPrompt projectPrompt = new ProjectPrompt(projectList);

  //Menu ?????? ???????????? ?????? ????????? PMS ???????????? ?????? ????????? ????????????.
  class MenuItem extends Menu {

    // inner ???????????? ???????????? ??? ?????? ???????????? ??????????????? ????????? ????????? ?????? ????????????.
    // ???????????? ?????? ????????? ????????? ??????.
    // ???) App this$0;

    // 1) ????????? ID??? ????????? ????????? ????????????.
    // - ??? ?????? ???????????? ????????? ????????? ?????? ??? ????????? ?????????.
    String menuId;

    // inner ???????????? ???????????? ????????? ??? ??? 
    // ?????? ???????????? ??????????????? ?????? ??????????????? ???????????? ????????????.
    // ???????????? ?????? ??????????????? ????????? ????????? ??????.
    public MenuItem(/*App outer,*/ String title, String menuId) {
      this(/*outer,*/ title, ENABLE_ALL, menuId); // ?????? ???????????? ????????? ?????? ????????? ?????? ???????????? ????????????.
    }

    public MenuItem(/*App outer,*/String title, int enableState, String menuId) {
      super(title, enableState);
      this.menuId = menuId;
      //this$0 = outer;
    }

    @Override
    public void execute() {
      // inner ???????????? ?????? ???????????? ??????????????? ?????? ????????? ?????? ?????? ?????????
      // inner ???????????? ????????? ???????????? ????????? ??? ??????.

      // ????????? ????????? ??? ?????? ???????????? ???????????? Map?????? Command ????????? ?????? ????????????.
      // commandMap?????? menuId??? ????????? command??? ????????? ????????????. 
      Command command = commandMap.get(menuId);
      command.execute();
    }
  }

  public static void main(String[] args) {
    App app = new App(); 
    app.service();
  }

  public App() {
    commandMap.put("/board/add", new BoardAddHandler(boardList));
    commandMap.put("/board/list", new BoardListHandler(boardList));
    commandMap.put("/board/detail", new BoardDetailHandler(boardList));
    commandMap.put("/board/update", new BoardUpdateHandler(boardList));
    commandMap.put("/board/delete", new BoardDeleteHandler(boardList));
    commandMap.put("/board/search", new BoardSearchHandler(boardList));

    commandMap.put("/member/add", new MemberAddHandler(memberList));
    commandMap.put("/member/list", new MemberListHandler(memberList));
    commandMap.put("/member/detail", new MemberDetailHandler(memberList));
    commandMap.put("/member/update", new MemberUpdateHandler(memberList));
    commandMap.put("/member/delete", new MemberDeleteHandler(memberList));

    commandMap.put("/project/add", new ProjectAddHandler(projectList, memberPrompt));
    commandMap.put("/project/list", new ProjectListHandler(projectList));
    commandMap.put("/project/detail", new ProjectDetailHandler(projectList));
    commandMap.put("/project/update", new ProjectUpdateHandler(projectList, memberPrompt));
    commandMap.put("/project/delete", new ProjectDeleteHandler(projectList));

    commandMap.put("/task/add", new TaskAddHandler(projectPrompt));
    commandMap.put("/task/list", new TaskListHandler(projectPrompt));
    commandMap.put("/task/detail", new TaskDetailHandler(projectPrompt));
    commandMap.put("/task/update", new TaskUpdateHandler(projectPrompt));
    commandMap.put("/task/delete", new TaskDeleteHandler(projectPrompt));

    commandMap.put("/auth/login", new AuthLoginHandler(memberList));
    commandMap.put("/auth/logout", new AuthLogoutHandler());
    commandMap.put("/auth/userinfo", new AuthUserInfoHandler());
  }

  void service() {
    createMainMenu().execute();
    Prompt.close();
  }

  Menu createMainMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("??????");
    mainMenuGroup.setPrevMenuTitle("??????");

    mainMenuGroup.add(new MenuItem("?????????", Menu.ENABLE_LOGOUT, "/auth/login"));
    mainMenuGroup.add(new MenuItem("?????????", Menu.ENABLE_LOGIN, "/auth/userinfo"));
    mainMenuGroup.add(new MenuItem("????????????", Menu.ENABLE_LOGIN, "/auth/logout"));

    mainMenuGroup.add(createBoardMenu());
    mainMenuGroup.add(createMemberMenu());
    mainMenuGroup.add(createProjectMenu());
    mainMenuGroup.add(createTaskMenu());

    return mainMenuGroup;
  }

  private Menu createBoardMenu() {
    MenuGroup boardMenu = new MenuGroup("?????????");
    boardMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/board/add"));
    boardMenu.add(new MenuItem("??????", "/board/list"));
    boardMenu.add(new MenuItem("????????????", "/board/detail"));
    boardMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/board/update"));
    boardMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/board/delete"));
    boardMenu.add(new MenuItem("??????", "/board/search"));
    return boardMenu;
  }

  private Menu createMemberMenu() {
    MenuGroup memberMenu = new MenuGroup("??????");
    memberMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/member/add"));
    memberMenu.add(new MenuItem("??????", "/member/list"));
    memberMenu.add(new MenuItem("????????????", "/member/detail"));
    memberMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/member/update"));
    memberMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/member/delete"));
    return memberMenu;
  }

  private Menu createProjectMenu() {
    MenuGroup projectMenu = new MenuGroup("????????????");
    projectMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/project/add"));
    projectMenu.add(new MenuItem("??????", "/project/list"));
    projectMenu.add(new MenuItem("????????????", "/project/detail"));
    projectMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/project/update"));
    projectMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/project/delete"));
    return projectMenu;
  }

  private Menu createTaskMenu() {
    MenuGroup taskMenu = new MenuGroup("??????");
    taskMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/task/add"));
    taskMenu.add(new MenuItem("??????", "/task/list"));
    taskMenu.add(new MenuItem("????????????", "/task/detail"));
    taskMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/task/update"));
    taskMenu.add(new MenuItem("??????", Menu.ENABLE_LOGIN, "/task/delete"));
    return taskMenu;
  }
}












