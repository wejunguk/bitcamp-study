package com.eomcs.pms.handler;

public abstract class AbstractList implements List {
  protected int size; //기본은 package private

  @Override
  public int size() {
    return this.size;
  }

}
