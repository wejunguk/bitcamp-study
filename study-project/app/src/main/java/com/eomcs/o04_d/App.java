package com.eomcs.o04_d;

import com.eomcs.o04_d.hadler.MemberHandler;
import com.eomcs.o04_d.hadler.ProjectHandler;
import com.eomcs.o04_d.hadler.TaskHandler;
import com.eomcs.o04_d.util.Prompt;

public class App {

  public static void main(String[] args) {

    while (true) {
      String input = Prompt.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        MemberHandler.add();

      } else if (input.equals("/member/list")) {
        MemberHandler.list();

      }  else if (input.equals("/project/add")) {
        ProjectHandler.add();

      }  else if (input.equals("/project/list")) {
        ProjectHandler.list();

      }  else if (input.equals("/task/add")) {
        TaskHandler.add();

      }  else if (input.equals("/task/list")) {
        TaskHandler.list();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    // Prompt 가 소유하고 관리하고 있는 자원을 닫으라고 명령한다. 
    Prompt.close();
  }
}
