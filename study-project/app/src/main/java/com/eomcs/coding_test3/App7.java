package com.eomcs.coding_test3;

import java.sql.Date;
import java.util.Scanner;


//1) 회원 데이터를 입력 받는 코드를 별도의 메서드로 분리한다.
//  => addMember() 메서드 정의 및 회원 등록 코드를 가져오기
//  => main()과 addMember()가 서로 공유하는 변수는 클래스 변수로 만든다.
//2)입력된 회원 데이터의 목록을 출력하는 코드를 별도의 메서드로 분리한다.
//  =>listMember()메서드 정의 및 관련된 코드를 가져오기
//3)회원 데이터를 입력 받는 코드를 별도의 메서드로 분리한다.
//  =>addProject() 메서드 정의 및 관련 코드를 가져오기
//  =>main()과 addProject()가 서로 공유하는 변수는 클래스 변수로 만든다.
//4)입력된 프로젝트 데이터의 목록을 출력하는 코드를 별도의 메서드로 분리한다.
//  =>listProjects() 메서드 정의 및 관련된 코드를 가져오기
//5) 작업 데이터를 입력 받는 코드를 별도의 메서드로 분리한다.
//=> addTask() 메서드 정의 및 관련 코드를 가져오기
//=> main()과 addTask()가 서로 공유하는 변수는 클래스 변수로 만든다.
//6) 입력된 작업 데이터의 목록을 출력하는 코드를 별도의 메서드로 분리한다.
//=> listTasks() 메서드 정의 및 관련된 코드를 가져오기
//7) 사용자로부터 명령어를 입력 받는 코드를 별도의 메서드로 분리한다.
//  => prompt() 메서드를 정의하고 관련된 코드를 가져오기
//8) 명령어 뿐만 아니라 사용자로부터 입력을 받는 기능을 모두 prompt()를 사용하여  처리한다.
//=>prompt()를 호출할 때 사용자에게 출력할 프롬포트 메시지를 아규먼트로 넘긴다.
//=>prompt()는 호출할 때 넘어온 프롬프트 메시지 값을 파라미터로 받는다.
public class App7 {
  static Scanner keyboardScan = new Scanner(System.in);

  // 회원 정보 -> 로컬변수를 옮긴후 클래스 변수로 사용하기, 앞에 static을 붙여야 함 , 
  static final int LENGTH = 100;
  static int[] no = new int[LENGTH];
  static String[] name = new String[LENGTH];
  static String[] email = new String[LENGTH];
  static String[] password = new String[LENGTH];
  static String[] photo = new String[LENGTH];
  static String[] tel = new String[LENGTH];
  static  Date[] registeredDate = new Date[LENGTH];
  static int size = 0;

  //프로젝트 정보 -> 클래스 변수로 바꿈!
  static final int PROJECT_LENGTH = 1000;
  static int[] pNo = new int[PROJECT_LENGTH];
  static String[] pTitle = new String[PROJECT_LENGTH];
  static String[] pContent = new String[PROJECT_LENGTH];
  static Date[] pStartDate = new Date[PROJECT_LENGTH];
  static Date[] pEndDate = new Date[PROJECT_LENGTH];
  static String[] pOwner = new String[PROJECT_LENGTH];
  static String[] pMembers = new String[PROJECT_LENGTH];
  static int pSize = 0;

  // 작업 정보
  static final int TASK_LENGTH = 100;
  static int[] tNo = new int[TASK_LENGTH];
  static String[] tContent = new String[TASK_LENGTH];
  static Date[] tDeadline = new Date[TASK_LENGTH];
  static String[] tOwner = new String[TASK_LENGTH];
  static int[] tStatus = new int[TASK_LENGTH];
  static int tSize = 0;

  static String input; //사용자가 입력한 값을 보관하는 변수, 서로 공유하기로 한 값이여서 여기로 꺼냄

  public static void main(String[] args) {



    while (true) { //->사용자로부터 값을 받는 부분!
      prompt("명령> ");//prompt를 출력할때 제목을 주면서 사용자에게 입력을 받아라!

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        //메서드로 분리한 코드를 실행하기(메서드 호출)
        //=>메서드명();
        addMember();


      } else if (input.equals("/member/list")) {
        listMember();
      }

    } else if (input.equals("/project/add")) {
      addProject (); //ctrl + 클릭시 addProject  변수부분이로 바로 이동

    } else if (input.equals("/project/list")) {
      listProjects();
    }

  }  else if (input.equals("/task/add")) {
    addTask();

  }  else if (input.equals("/tasks/list")) {
    listTasks();
  }

} else {
  System.out.println("실행할 수 없는 명령입니다.");
}
System.out.println();
}

keyboardScan.close();
}
private static void addMember() {
  // TODO Auto-generated method stub

}
static void addMemer() { //기능단위로 관리하기 쉽게 코드를 분리시키기 위해 사용 1)
  System.out.println("[회원 등록]"); // 에러뜸 - 다른코드에 있는 변수 사용 불가능 1)
  prompt("번호? ");
  no[size] = Integer.parseInt(input);

  prompt("이름? ");
  name[size] = input;

  prompt("이메일? ");
  email[size] = input;

  prompt("암호? ");
  password[size] = input;

  prompt("사진? ");
  photo[size] = input;

  prompt("전화? ");
  tel[size] = input;

  registeredDate[size] = new Date(System.currentTimeMillis());

  size++;
}

//여기에 static void 추가
static void listMember() {
  System.out.println("[회원 목록]");
  for (int i = 0; i < size; i++) {
    // 번호, 이름, 이메일, 전화, 가입일
    System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
        no[i], name[i], email[i], tel[i], registeredDate[i]);

  }
  static void addProject() {
    System.out.println("[프로젝트 등록]");

    prompt("번호? "); //로컬변수로 설정되어서 접금할수없음 ->프로젝트변수를 클래스변수로 바꾸자!
    pNo[pSize] = Integer.valueOf(input);

    prompt("프로젝트명? ");
    pTitle[pSize] = input;

    prompt("내용? ");
    pContent[pSize] = input;

    prompt("시작일? ");
    pStartDate[pSize] = Date.valueOf(input);

    prompt("종료일? ");
    pEndDate[pSize] = Date.valueOf(input);

    prompt("만든이? ");
    pOwner[pSize] = input;

    prompt("팀원? ");
    pMembers[pSize] = keyboardScan.nextLine();

    pSize++;
  }
  static void listProjects () {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < pSize; i++) {
      // 번호, 프로젝트명, 시작일, 종료일, 만든이
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          pNo[i], pTitle[i], pStartDate[i], pEndDate[i], pOwner[i]);
    }
    static void addTask () {
      System.out.println("[작업 등록]");

      prompt("번호? ");
      tNo[tSize] = Integer.parseInt(input);

      prompt("내용? ");
      tContent[tSize] = input;

      prompt("마감일? ");
      tDeadline[tSize] = Date.valueOf(input);

      System.out.println("상태?");
      System.out.println("0: 신규");
      System.out.println("1: 진행중");
      System.out.println("2: 완료");
      prompt("> ");
      tStatus[tSize] = Integer.valueOf(input);

      prompt("담당자? ");
      tOwner[tSize] = input;

      tSize++;
    }
    static void listTasks () {
      System.out.println("[작업 목록]");

      for (int i = 0; i < tSize; i++) {
        String stateLabel = null;
        switch (tStatus[i]) {
          case 1:
            stateLabel = "진행중";
            break;
          case 2:
            stateLabel = "완료";
            break;
          default:
            stateLabel = "신규";
        }
        // 번호, 작업명, 마감일, 프로젝트, 상태, 담당자
        System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
            tNo[i], tContent[i], tDeadline[i], stateLabel, tOwner[i]);
      }
    }
    //String메소드를 실행하려면 title을 줘라, 그래야지 prompt를 실행할 수 있다.
    //프롬포트 안에 아무것도 없으면 그냥 호출하게 됨, String title을 주면 반드시 문자열로 호출,위에 prompt("명령> "); 이부분
    static void prompt(String title) { //->prompt 변수 사용
      System.out.print(title); 

      input = keyboardScan.nextLine();  //return하면서 void->String을 리턴하게끔하자 ->사용자가 한줄을 치면 리턴한다.
    }
  }
}