package com.eomcs.o10_i.pms.handler;

public abstract class AbstractList implements List {
  protected int size;

  @Override
  public int size() {
    return this.size;
  }
}
