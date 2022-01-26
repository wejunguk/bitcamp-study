package com.eomcs.o17_a_b_c.pms.handler;

import com.eomcs.o17_a_b_c.menu.Menu;

public class AuthLogoutHandler implements Command {
  @Override
  public void execute(CommandRequest request) {
    System.out.println("[로그아웃]");

    AuthLoginHandler.loginUser = null;
    AuthLoginHandler.userAccessLevel = Menu.ACCESS_LOGOUT;
    System.out.println("로그아웃 하였습니다.");
  }
}







