package com.eomcs.o15.pms.handler;

import com.eomcs.o15.menu.Menu;

public class AuthLogoutHandler implements Command {
  public void execute() {
    System.out.println("[로그아웃]");

    AuthLoginHandler.loginUser = null;
    AuthLoginHandler.userAccessLevel = Menu.ACCESS_LOGOUT;
    System.out.println("로그아웃 하였습니다.");
  }
}







