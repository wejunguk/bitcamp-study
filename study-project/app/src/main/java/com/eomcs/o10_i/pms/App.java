package com.eomcs.o10_i.pms;

import com.eomcs.o10_i.pms.handler.ArrayList;
import com.eomcs.o10_i.pms.handler.BoardHandler;
import com.eomcs.o10_i.pms.handler.LinkedList;
import com.eomcs.o10_i.pms.handler.List;
import com.eomcs.o10_i.pms.handler.MemberHandler;
import com.eomcs.o10_i.pms.handler.ProjectHandler;
import com.eomcs.o10_i.pms.handler.TaskHandler;
import com.eomcs.o10_i.pms.menu.Menu;
import com.eomcs.o10_i.pms.menu.MenuGroup;
import com.eomcs.o10_i.util.Prompt;

public class App {

  List boardList = new ArrayList();
  List memberList = new LinkedList();
  List projectList = new LinkedList();
  List taskList = new ArrayList();

  // BoardHandler 왜 그냥 인스턴스 만들래? BoardHandler는 반드시 기본 생성자가 있어야해
  BoardHandler boardHandler = new BoardHandler(boardList);
  MemberHandler memberHandler = new MemberHandler(memberList);
  ProjectHandler projectHandler = new ProjectHandler(projectList, memberHandler);
  TaskHandler taskHandler = new TaskHandler(taskList, memberHandler);

  public App() {

  }

  public static void main(String[] args) {
    App app = new App();
    app.service();
  }

  void service() {
    createMenu().execute();
    Prompt.close();
  }

  Menu createMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);

    boardMenu.add(new Menu("등록") {
      public void execute() {
        boardHandler.add(); 
      }});
    boardMenu.add(new Menu("목록") {
      public void execute() {
        boardHandler.list(); 
      }});
    boardMenu.add(new Menu("상세보기") {
      public void execute() {
        boardHandler.detail(); 
      }});
    boardMenu.add(new Menu("변경") {
      public void execute() {
        boardHandler.update(); 
      }});
    boardMenu.add(new Menu("삭제") {
      public void execute() {
        boardHandler.delete(); 
      }});

    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);

    memberMenu.add(new Menu("등록") {
      public void execute() {
        memberHandler.add(); 
      }});
    memberMenu.add(new Menu("목록") {
      public void execute() {
        memberHandler.list(); 
      }});
    memberMenu.add(new Menu("상세보기") {
      public void execute() {
        memberHandler.detail(); 
      }});
    memberMenu.add(new Menu("변경") {
      public void execute() {
        memberHandler.update(); 
      }});
    memberMenu.add(new Menu("삭제") {
      public void execute() {
        memberHandler.delete(); 
      }});

    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    projectMenu.add(new Menu("등록") {
      public void execute() {
        projectHandler.add(); 
      }});
    projectMenu.add(new Menu("목록") {
      public void execute() {
        projectHandler.list(); 
      }});
    projectMenu.add(new Menu("상세보기") {
      public void execute() {
        projectHandler.detail(); 
      }});
    projectMenu.add(new Menu("변경") {
      public void execute() {
        projectHandler.update(); 
      }});
    projectMenu.add(new Menu("삭제") {
      public void execute() {
        projectHandler.delete(); 
      }});

    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);

    taskMenu.add(new Menu("등록") {
      public void execute() {
        taskHandler.add(); 
      }});
    taskMenu.add(new Menu("목록") {
      public void execute() {
        taskHandler.list(); 
      }});
    taskMenu.add(new Menu("상세보기") {
      public void execute() {
        taskHandler.detail(); 
      }});
    taskMenu.add(new Menu("변경") {
      public void execute() {
        taskHandler.update(); 
      }});
    taskMenu.add(new Menu("삭제") {
      public void execute() {
        taskHandler.delete(); 
      }});

    return mainMenuGroup;
  }
}












