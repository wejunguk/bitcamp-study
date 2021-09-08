// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0740 {

  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir, "");
  }

  static void printClasses(File dir, String packageName) {


    File[] files = dir.listFiles
        pathname -> {
          if (pathname.isDirectory()
              || (pathname.isFile() && pathname.getName().endsWith(".class"))) {
            return true;
          }

          return false;
        }
      );

      for (File file : files) {
        if (file.isDirectory()) {
          printClasses(file, packageName + file.getName());
        } else {
          System.out.printf(packageName + file.getN);
        }
      }
  }

  //    File[] files = dir.listFiles();
  //    for (File f : files) {
  //      System.out.println(f.getName());
  //    }

}