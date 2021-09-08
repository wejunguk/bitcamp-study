// 익명 클래스로 FileFilter 만들기
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0640 {


  public static void main(String[] args) throws Exception {

    File dir = new File(".");

    // 익명 클래스를 정의할 때
    // 객체를 사용할 위치에 익명 클래스를 정의하는 것이
    // 코드를 더 읽기 쉽게 만든다.
    //
    // Exam630과의 차이?!
    // 한번만 사용하는 값을 익명클래스로 바로 넣어 바로 실행하자
    File[] files = dir.listFiles(new FileFilter() {
      @Override
      public boolean accept(File file) {
        if (file.isFile() && file.getName().endsWith(".java"))
          return true;
        return false;
      }
    });

    for (File file : files) {
      System.out.printf("%s %12d %s\n", file.isDirectory() ? "d" : "-", file.length(),
          file.getName());
    }
  }
}


