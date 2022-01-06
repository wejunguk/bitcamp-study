package com.eomcs.pms.o5_a.pms;

import com.eomcs.pms.o5_a.pms.hadler.BoardHandler;
import com.eomcs.pms.o5_a.pms.hadler.BoardHandler2;
import com.eomcs.pms.o5_a.pms.hadler.BoardHandler3;
import com.eomcs.pms.o5_a.pms.hadler.BoardHandler4;
import com.eomcs.pms.o5_a.pms.hadler.BoardHandler5;
import com.eomcs.pms.o5_a.pms.hadler.BoardHandler6;
import com.eomcs.pms.o5_a.pms.hadler.MemberHandler;
import com.eomcs.pms.o5_a.pms.hadler.ProjectHandler;
import com.eomcs.pms.o5_a.pms.hadler.TaskHandler;
import com.eomcs.pms.o5_a.util.Prompt;

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

      }  else if (input.equals("/board/add")) {
        BoardHandler.add();

      }  else if (input.equals("/board/list")) {
        BoardHandler.list();

      }  else if (input.equals("/board2/add")) {
        BoardHandler2.add();

      }  else if (input.equals("/board2/list")) {
        BoardHandler2.list();

      }  else if (input.equals("/board3/add")) {
        BoardHandler3.add();

      }  else if (input.equals("/board3/list")) {
        BoardHandler3.list();

      }  else if (input.equals("/board4/add")) {
        BoardHandler4.add();

      }  else if (input.equals("/board4/list")) {
        BoardHandler4.list();

      }  else if (input.equals("/board5/add")) {
        BoardHandler5.add();

      }  else if (input.equals("/board6/list")) {
        BoardHandler6.list();

      }  else if (input.equals("/board6/add")) {
        BoardHandler6.add();

      }  else if (input.equals("/board6/list")) {
        BoardHandler6.list();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    // Prompt 가 소유하고 관리하고 있는 자원을 닫으라고 명령한다. 
    Prompt.close();
  }
}
