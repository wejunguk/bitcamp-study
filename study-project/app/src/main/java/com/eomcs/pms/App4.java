package com.eomcs.pms;

//1) 사용자로부터 입력 받는 일을 하는 메서드를 별도의 클래스로 분류한다.
//4) 작업 정보를 다루는 메서드를 별도의 클래스로 분류한다.
//5) 키보드 스캐너를 닫는 일은 그 스캐너를 갖고 있는 클래스에서 수행한다. ->프롬포트에 키보드를 다는다.
//   => GRASP에서 Information Expert 설계 기법 적용
public class App4 {

  public static void main(String[] args) {

    while (true) {
      String input = Prompt.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        //멤버핸들러로 옮긴 add를 실행하라
        MemberHandler.add(); 

      } else if (input.equals("/member/list")) {
        MemberHandler.list();

      }  else if (input.equals("/project/add")) {
        Project.add();

      }  else if (input.equals("/project/list")) {
        Project.list();

      }  else if (input.equals("/task/add")) {
        Task.add();

      }  else if (input.equals("/task/list")) {
        Task.list();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    // Prompt가 소유하고 관리하고 있는 자원을 닫으라고 명령한다.
    Prompt.close();
  }


}












