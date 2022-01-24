package com.eomcs.o14_c_d_e_f.pms.handler;

public class AuthLogoutHandler implements Command {
  public void execute() {
    System.out.println("[로그아웃]");

    AuthLoginHandler.loginUser = null;
    System.out.println("로그아웃 하였습니다.");
  }
}







