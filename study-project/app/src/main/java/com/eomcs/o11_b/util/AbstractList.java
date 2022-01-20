package com.eomcs.o11_b.util;

public abstract class AbstractList implements List {
  protected int size;

  @Override
  public int size() {
    return this.size;
  }
}
