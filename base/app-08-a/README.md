# 08-a. `Composite` 디자인 패턴 : 적용 전

사용자가 직접 명령어를 입력하는 대신에 메뉴를 통해 명령을 실행하도록 변경해 보자.

## 훈련 목표

- `Composite` 디자인 패턴의 용도와 실행 원리를 이해한다.

## 훈련 내용

- 메뉴를 출력하는 기능을 추가한다.
- 사용자로부터 긴 명령어를 입력받는 대신에 메뉴 번호를 입력 받는다.  
- 메뉴 번호에 따라 기능을 수행한다.

## 실습

### 1단계 - 메인 메뉴를 출력하고 번호를 입력 받는다.

- `App`을 실행하면 다음과 같이 메인 메뉴를 출력한다.
- 0 번을 입력하면 `quit` 명령을 실행한다.

```
[메인]
1. 게시판
2. 회원
3. 프로젝트
4. 작업
0. 종료
메인> 0     <--- 사용자가 메뉴 번호를 입력
안녕!       <--- 출력 후 프로그램 실행 종료
```
#### 작업 파일

- com.eomcs.pms.App 클래스 변경
  - 백업: App.java.01

### 2단계 - 게시판 메뉴를 출력하고 번호를 입력 받는다.

- 입력 받은 번호에 따라 명령어를 설정하여 처리한다.
- 0 번을 입력하면 이전 메뉴로 간다.

```
[메인]
1. 게시판
2. 회원
3. 프로젝트
4. 작업
0. 종료
메인> 1     <--- 사용자가 메뉴 번호를 입력

[메인/게시판]
1. 등록
2. 목록
3. 상세보기
4. 변경
5. 삭제
0. 이전메뉴
게시판> 0

[메인]
1. 게시판
2. 회원
3. 프로젝트
4. 작업
0. 종료
메인>
```

#### 작업 파일

- com.eomcs.pms.App 클래스 변경
  - 백업: App.java.02



### 3단계 - 회원/프로젝트/작업 메뉴를 출력하고 번호를 입력 받는다.

- 입력 받은 번호에 따라 명령어를 설정하여 처리한다.
- 0 번을 입력하면 이전 메뉴로 간다.

#### 작업 파일

- com.eomcs.pms.App 클래스 변경
  - 백업: App.java.03

### 4단계 - 메뉴 번호를 입력했을 때 해당 기능을 바로 실행하게 한다.

- 번호를 입력하면 핸들러를 이용하여 해당 번호의 명령을 바로 처리한다.

#### 작업 파일

- com.eomcs.pms.App 클래스 변경
  - 백업: App.java.04

### 5단계 - 각각의 메인 메뉴를 다루는 코드를 별도의 메서드로 추출한다.

- 각 명령을 처리하는 코드를 분리하여 메서드로 정의한다.

#### 작업 파일

- com.eomcs.pms.App 클래스 변경
  - 백업: App.java.05

## 실습 결과

- src/main/java/com/eomcs/pms/App.java 변경