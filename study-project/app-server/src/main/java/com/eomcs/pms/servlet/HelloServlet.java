package com.eomcs.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 이 프로그램의 대한 이름 넣기 (board/add 느낌?!)
@WebServlet("/hi")
public class HelloServlet implements Servlet{

  @Override
  public void init(ServletConfig config) throws ServletException {


  }

  @Override
  public ServletConfig getServletConfig() {

    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("Hello!");
    out.println("안녕!");

  }

  @Override
  public String getServletInfo() {

    return null;
  }

  @Override
  public void destroy() {


  }

}
