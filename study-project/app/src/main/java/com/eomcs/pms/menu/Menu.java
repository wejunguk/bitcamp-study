package com.eomcs.pms.menu;

// MenuItem과 MenuGroup을 같은 타입으로 묶기 위해 정의한 클래스
// 이 클래스 자체는 직접 인스턴스를 만들어 사용하기 위함이 아니라
// 상속해주는 용도이기 때문에 추상 클래스로 정의한다.
public abstract class Menu {

  String title;

  public Menu(String title) {
    this.title = title;
  }

  // 서브 클래스에서 해야할 일을 정의한다.
  // 단, 서브 클래스에서 반드시 재정의 할 메서드이기 때문에
  // 구체적으로 구현하지 않는다.
  public abstract void execute();
}
