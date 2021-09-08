// 활용 - 지정한 폴더를 삭제하라.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0720_02 {

  public static void main(String[] args) throws Exception {

    // temp 디렉토리를 삭제하기
    File dir = new File("temp");

    // 재귀메서도 호출
    deleteFile(dir);
  }

  static void deleteFile(File dir) {

  }

}


