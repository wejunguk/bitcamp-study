package com.eomcs.o08_b.pms;

import com.eomcs.o08_b.pms.hadler.BoardHandler;
import com.eomcs.o08_b.pms.hadler.MemberHandler;
import com.eomcs.o08_b.pms.hadler.ProjectHandler;
import com.eomcs.o08_b.pms.hadler.TaskHandler;
import com.eomcs.o08_b.pms.menu.BoardAddMenu;
import com.eomcs.o08_b.pms.menu.BoardDeleteMenu;
import com.eomcs.o08_b.pms.menu.BoardDetailMenu;
import com.eomcs.o08_b.pms.menu.BoardListMenu;
import com.eomcs.o08_b.pms.menu.BoardUpdateMenu;
import com.eomcs.o08_b.pms.menu.MemberAddMenu;
import com.eomcs.o08_b.pms.menu.MemberDeleteMenu;
import com.eomcs.o08_b.pms.menu.MemberDetailMenu;
import com.eomcs.o08_b.pms.menu.MemberListMenu;
import com.eomcs.o08_b.pms.menu.MemberUpdateMenu;
import com.eomcs.o08_b.pms.menu.Menu;
import com.eomcs.o08_b.pms.menu.MenuGroup;
import com.eomcs.o08_b.pms.menu.ProjectAddMenu;
import com.eomcs.o08_b.pms.menu.ProjectDeleteMenu;
import com.eomcs.o08_b.pms.menu.ProjectDetailMenu;
import com.eomcs.o08_b.pms.menu.ProjectListMenu;
import com.eomcs.o08_b.pms.menu.ProjectUpdateMenu;
import com.eomcs.o08_b.pms.menu.TaskAddMenu;
import com.eomcs.o08_b.pms.menu.TaskDeleteMenu;
import com.eomcs.o08_b.pms.menu.TaskDetailMenu;
import com.eomcs.o08_b.pms.menu.TaskListMenu;
import com.eomcs.o08_b.pms.menu.TaskUpdateMenu;
import com.eomcs.o08_b.util.Prompt;


public class App {

  static BoardHandler boardHandler = new BoardHandler();
  static MemberHandler memberHandler = new MemberHandler();
  static ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  static TaskHandler taskHandler = new TaskHandler(memberHandler);

  public static void main(String[] args) {

    Menu mainMenu = createMenu();
    mainMenu.execute();

    Prompt.close();
  }

  static Menu createMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);

    boardMenu.add(new BoardAddMenu(boardHandler));
    boardMenu.add(new BoardListMenu(boardHandler));
    boardMenu.add(new BoardDetailMenu(boardHandler));
    boardMenu.add(new BoardUpdateMenu(boardHandler));
    boardMenu.add(new BoardDeleteMenu(boardHandler));

    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);

    memberMenu.add(new MemberAddMenu(memberHandler));
    memberMenu.add(new MemberListMenu(memberHandler));
    memberMenu.add(new MemberDetailMenu(memberHandler));
    memberMenu.add(new MemberUpdateMenu(memberHandler));
    memberMenu.add(new MemberDeleteMenu(memberHandler));

    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    projectMenu.add(new ProjectAddMenu(projectHandler));
    projectMenu.add(new ProjectListMenu(projectHandler));
    projectMenu.add(new ProjectDetailMenu(projectHandler));
    projectMenu.add(new ProjectUpdateMenu(projectHandler));
    projectMenu.add(new ProjectDeleteMenu(projectHandler));

    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);

    taskMenu.add(new TaskAddMenu(taskHandler));
    taskMenu.add(new TaskListMenu(taskHandler));
    taskMenu.add(new TaskDetailMenu(taskHandler));
    taskMenu.add(new TaskUpdateMenu(taskHandler));
    taskMenu.add(new TaskDeleteMenu(taskHandler));

    return mainMenuGroup; 
  }
}
