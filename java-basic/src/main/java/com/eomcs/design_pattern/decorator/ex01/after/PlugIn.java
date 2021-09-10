package com.eomcs.design_pattern.decorator.ex01.after;

public abstract class PlugIn extends Printer {
  Printer origin;

  // 기능을 덧 붙이는, 따른 Printer을 가르킬 수 있도록 한다.
  public PlugIn(Printer origin) {
    this.origin = origin;
  };
}
