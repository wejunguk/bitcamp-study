package com.eomcs.o16_a_b.pms;

import static com.eomcs.o16_a_b.menu.Menu.ACCESS_ADMIN;
import static com.eomcs.o16_a_b.menu.Menu.ACCESS_GENERAL;
import static com.eomcs.o16_a_b.menu.Menu.ACCESS_LOGOUT;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import com.eomcs.o16_a_b.menu.Menu;
import com.eomcs.o16_a_b.menu.MenuGroup;
import com.eomcs.o16_a_b.pms.domain.Board;
import com.eomcs.o16_a_b.pms.domain.Member;
import com.eomcs.o16_a_b.pms.domain.Project;
import com.eomcs.o16_a_b.pms.handler.AuthLoginHandler;
import com.eomcs.o16_a_b.pms.handler.AuthLogoutHandler;
import com.eomcs.o16_a_b.pms.handler.AuthUserInfoHandler;
import com.eomcs.o16_a_b.pms.handler.BoardAddHandler;
import com.eomcs.o16_a_b.pms.handler.BoardDeleteHandler;
import com.eomcs.o16_a_b.pms.handler.BoardDetailHandler;
import com.eomcs.o16_a_b.pms.handler.BoardListHandler;
import com.eomcs.o16_a_b.pms.handler.BoardSearchHandler;
import com.eomcs.o16_a_b.pms.handler.BoardUpdateHandler;
import com.eomcs.o16_a_b.pms.handler.Command;
import com.eomcs.o16_a_b.pms.handler.MemberAddHandler;
import com.eomcs.o16_a_b.pms.handler.MemberDeleteHandler;
import com.eomcs.o16_a_b.pms.handler.MemberDetailHandler;
import com.eomcs.o16_a_b.pms.handler.MemberListHandler;
import com.eomcs.o16_a_b.pms.handler.MemberPrompt;
import com.eomcs.o16_a_b.pms.handler.MemberUpdateHandler;
import com.eomcs.o16_a_b.pms.handler.ProjectAddHandler;
import com.eomcs.o16_a_b.pms.handler.ProjectDeleteHandler;
import com.eomcs.o16_a_b.pms.handler.ProjectDetailHandler;
import com.eomcs.o16_a_b.pms.handler.ProjectListHandler;
import com.eomcs.o16_a_b.pms.handler.ProjectPrompt;
import com.eomcs.o16_a_b.pms.handler.ProjectUpdateHandler;
import com.eomcs.o16_a_b.pms.handler.TaskAddHandler;
import com.eomcs.o16_a_b.pms.handler.TaskDeleteHandler;
import com.eomcs.o16_a_b.pms.handler.TaskDetailHandler;
import com.eomcs.o16_a_b.pms.handler.TaskListHandler;
import com.eomcs.o16_a_b.pms.handler.TaskUpdateHandler;
import com.eomcs.o16_a_b.util.Prompt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class App {
  List<Board> boardList = new ArrayList<>();
  List<Member> memberList = new LinkedList<>();
  List<Project> projectList = new ArrayList<>();

  HashMap<String,Command> commandMap = new HashMap<>();

  MemberPrompt memberPrompt = new MemberPrompt(memberList);
  ProjectPrompt projectPrompt = new ProjectPrompt(projectList);

  class MenuItem extends Menu {
    String menuId;

    public MenuItem(String title, String menuId) {
      super(title);
      this.menuId = menuId;
    }

    public MenuItem(String title, int accessScope, String menuId) {
      super(title, accessScope);
      this.menuId = menuId;
    }

    @Override
    public void execute() {
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
    loadObjects("board.json", boardList, Board.class);
    loadObjects("member.json", memberList, Member.class);
    loadObjects("project.json", projectList, Project.class);

    createMainMenu().execute();
    Prompt.close();

    saveObjects("board.json", boardList);
    saveObjects("member.json", memberList);
    saveObjects("project.json", projectList);
  }

  // JSON ???????????? ????????? ???????????? ????????? ????????? ?????????.
  private <E> void loadObjects(
      String filepath, // ???????????? ?????? ??? ?????? ?????? 
      List<E> list, // ????????? ???????????? ????????? ?????? ??? ????????? ?????? 
      Class<E> domainType // ????????? ????????? ????????????
      ) {

    try (BufferedReader in = new BufferedReader(
        new FileReader(filepath, Charset.forName("UTF-8")))) {

      StringBuilder strBuilder = new StringBuilder();
      String str;
      while ((str = in.readLine()) != null) { // ?????? ????????? ?????????.
        strBuilder.append(str);
      }

      // StringBuilder??? ?????? ??? JSON ???????????? ????????? ?????????.
      Type type = TypeToken.getParameterized(Collection.class, domainType).getType(); 
      Collection<E> collection = new Gson().fromJson(strBuilder.toString(), type);

      // JSON ???????????? ????????? ????????? ??????????????? ?????? List ??? ????????????.
      list.addAll(collection);

      System.out.printf("%s ????????? ?????? ??????!\n", filepath);

    } catch (Exception e) {
      System.out.printf("%s ????????? ?????? ??????!\n", filepath);
    }
  }

  // ????????? JSON ???????????? ????????????.
  private void saveObjects(String filepath, List<?> list) {
    try (PrintWriter out = new PrintWriter(
        new BufferedWriter(
            new FileWriter(filepath, Charset.forName("UTF-8"))))) {

      out.print(new Gson().toJson(list));

      System.out.printf("%s ????????? ?????? ??????!\n", filepath);

    } catch (Exception e) {
      System.out.printf("%s ????????? ?????? ??????!\n", filepath);
      e.printStackTrace();
    }
  }

  Menu createMainMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("??????");
    mainMenuGroup.setPrevMenuTitle("??????");

    mainMenuGroup.add(new MenuItem("?????????", ACCESS_LOGOUT , "/auth/login"));
    mainMenuGroup.add(new MenuItem("?????????", ACCESS_GENERAL, "/auth/userinfo"));
    mainMenuGroup.add(new MenuItem("????????????", ACCESS_GENERAL, "/auth/logout"));

    mainMenuGroup.add(createBoardMenu());
    mainMenuGroup.add(createMemberMenu());
    mainMenuGroup.add(createProjectMenu());
    mainMenuGroup.add(createTaskMenu());
    mainMenuGroup.add(createAdminMenu());

    return mainMenuGroup;
  }

  private Menu createBoardMenu() {
    MenuGroup boardMenu = new MenuGroup("?????????");
    boardMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/board/add"));
    boardMenu.add(new MenuItem("??????", "/board/list"));
    boardMenu.add(new MenuItem("????????????", "/board/detail"));
    boardMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/board/update"));
    boardMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/board/delete"));
    boardMenu.add(new MenuItem("??????", "/board/search"));
    return boardMenu;
  }

  private Menu createMemberMenu() {
    MenuGroup memberMenu = new MenuGroup("??????");
    memberMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/member/add"));
    memberMenu.add(new MenuItem("??????", "/member/list"));
    memberMenu.add(new MenuItem("????????????", "/member/detail"));
    memberMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/member/update"));
    memberMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/member/delete"));
    return memberMenu;
  }

  private Menu createProjectMenu() {
    MenuGroup projectMenu = new MenuGroup("????????????");
    projectMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/project/add"));
    projectMenu.add(new MenuItem("??????", "/project/list"));
    projectMenu.add(new MenuItem("????????????", "/project/detail"));
    projectMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/project/update"));
    projectMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/project/delete"));
    return projectMenu;
  }

  private Menu createTaskMenu() {
    MenuGroup taskMenu = new MenuGroup("??????");
    taskMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/task/add"));
    taskMenu.add(new MenuItem("??????", "/task/list"));
    taskMenu.add(new MenuItem("????????????", "/task/detail"));
    taskMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/task/update"));
    taskMenu.add(new MenuItem("??????", ACCESS_GENERAL, "/task/delete"));
    return taskMenu;
  }

  private Menu createAdminMenu() {
    MenuGroup adminMenu = new MenuGroup("?????????", ACCESS_ADMIN);
    adminMenu.add(new MenuItem("?????? ??????", "/member/add"));
    adminMenu.add(new MenuItem("???????????? ??????", "/project/add"));
    adminMenu.add(new MenuItem("?????? ??????", "/task/add"));
    adminMenu.add(new MenuItem("????????? ??????", "/board/add"));
    return adminMenu;
  }
}












