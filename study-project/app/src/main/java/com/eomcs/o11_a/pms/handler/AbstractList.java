package com.eomcs.o11_a.pms.handler;

public abstract class AbstractList implements List {
  protected int size;

  @Override
  public int size() {
    return this.size;
  }
}
