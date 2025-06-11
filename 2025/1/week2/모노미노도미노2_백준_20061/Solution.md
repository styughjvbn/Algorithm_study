# 모노미노도미노2

## 문제 설명
- 문제 링크: [링크](https://www.acmicpc.net/problem/20061)
- 핵심 사항:
---

## 풀이 과정

### 1. **접근 방법**
- 연결 리스트로 중간 지점 삭제 연산 O(n)
- 각 줄을 비트로 저장하여 비교 연산 O(n)
- 빨간 지역에서 생성되는 블록을 초록 지역과 파란 지역에서 올바르게 전달하는 것이 핵심

### 2. **구현 단계**
1. 입력값 파싱
2. 한쪽방향으로 차곡차곡 쌓이는 동작
    - ~~아래에서부터 비트연산을 통해 해당 블럭이 위치할 수 있는지 검사~~
      - 아래처럼 구멍이 뚤린 부분을 체크하지 못하고 1*2 블럭을 잘못 놓는 경우가 생김  
        oxxx    
        xoxx  
        v  
        oxxx  
        ooxx
    - 위에서부터 비트연산을 통해 해당 블럭이 위치할 수 있는지 검사
3. 한줄이 꽉 차서 사라지는 동작
    - 비트연산을 통해 값 검사 후 연결리스트 삭제 연산
4. 연한 부분에 블럭이 존재하여 아래에서부터 줄을 없애는 동작
    - 연결리스트를 통해 삭제 연산

### Java 연산
* LinkedList `ListIterator`
  * **list 의 size 가 n일때 ListIterator(n)는 맨 뒤에서부터 접근하여 Iterator 객체를 생성한다.**
    * list 의 크기에 따라 더 빠르게 해당 인덱스로 접근하기 위한 최적화가 되어 있다.
  * ListIterator 의 next 메소드는 현재 커서의 원소값을 출력하고 커서를 다음 인덱스로 옮긴다.
  * ListIterator 의 previous 메소드는 현재 커서의 인덱스를 이전으로 옮긴다음에 원소값을 출력한다.
  * 따라서 커서가 1번째를 가르킬 때 
    * next call 이후에 previous call 을 한다면 1번째 원소값만을 출력하고 커서는 다시 1번째를 가르키게 된다.
    * previous call 이후에 next call 을 한다면 0번째 원소값만을 출력하고 커서는 다시 1번째를 가르키게 된다.
  ```java
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);

        ListIterator<Integer> listIterator = list.listIterator(1);
        System.out.println(listIterator.next());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.nextIndex());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.next());
        System.out.println(listIterator.nextIndex());
  //   1
  //   1
  //   1
  //   0
  //   0
  //   1
```