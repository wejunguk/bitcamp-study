package com.eomcs.pms.handler;

public class MenuGroup extends Menu {
  Menu[] childs = new Menu[100];
  int size;
  boolean disablePrevMenu;
  String prevMenuTitle = "이전 메뉴";
}