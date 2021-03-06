package com.eomcs.o14_a_b.pms.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Project {
  private int no;
  private String title;
  private String content;
  private Date startDate;
  private Date endDate;
  private Member owner;
  // members는 멤버목록을 선택한 다음에 Array객체 리스트를 만들어서 리턴해준다.
  private List<Member> members;
  // tasks에 task를 add 하는 것이기 때문에 일단 size 0인 배열이라도 가지고 있어야 한다.
  private List<Task> tasks = new ArrayList<>();


  @Override
  public String toString() {
    return "Project [no=" + no + ", title=" + title + ", content=" + content + ", startDate="
        + startDate + ", endDate=" + endDate + ", owner=" + owner + ", members=" + members
        + ", tasks=" + tasks + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public Member getOwner() {
    return owner;
  }
  public void setOwner(Member owner) {
    this.owner = owner;
  }
  public List<Member> getMembers() {
    return members;
  }
  public void setMembers(List<Member> members) {
    this.members = members;
  }
  public List<Task> getTasks() {
    return tasks;
  }
  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

}
