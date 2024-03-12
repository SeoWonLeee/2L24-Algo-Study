# CH5. DFS/BFS

## 1️⃣ 꼭 필요한 자료구조 기초
- 탐색(search) : 많은 양의 데이터 중에서 원하는 데이터를 찾는 과정
- DFS/BFS를 제대로 이해하려면 기본 자료 구조인 **스택과 큐**에 대한 이해가 전제되어야 함.
- 자료구조(Data Structure) : 데이터를 표현하고 관리하고 처리하기 위한 구조를 의미
- 그 중 스택과 큐는 **2가지**의 핵심 함수로 구성됨.
> - 삽입(Push) : 데이터 삽입
> - 삭제(Pop) : 데이터 삭제
- 실제 스택과 큐 사용 시 **오버플로**와 **언더플로**를 고민해야 함.
  - ```오버플로(Overflow)``` : 특정한 자료구조가 수용할 수 있는 데이터의 크기를 이미 가득 찬 상태에서 삽입 연산 수행 시 발생
  - ```언더플로(Underflow)``` : 특정한 자료구조에 데이터가 전혀 들어 있지 않은 상태에서 삭제 연산 수행 시 데이터가 전혀 없는 상태이기 때문에 발생

<br>

### 💭스택
- 스택(Stack) : ```선입후출(FILO)``` or ```후입선출(LIFO)``` 구조
- 예시
> 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
> - step 0 : 초기 단계
>   ```
>   ```
>   
> - step 1 : 삽입(5)
>   ```
>   5
>   ```
>
> - step 2 : 삽입(5) - 삽입(2)
>   ```
>   5 2
>   ```
>
> - step 3 : 삽입(5) - 삽입(2) - 삽입(3)
>   ```
>   5 2 3
>   ```
>
> - step 4 : 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7)
>   ```
>   5 2 3 7
>   ```
>
> - step 5 : 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제()
>   ```
>   5 2 3 
>   ```
>
> - step 6 : 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1)
>   ```
>   5 2 3 1 
>   ```
>
> - step 7 : 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4)
>   ```
>   5 2 3 1 4
>   ```
>
> - step 8 : 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
>   ```
>   5 2 3 1
>   ```

- 코드 예시
  ```java
  import java.util.*;
  
  public class Main {
  
      public static void main(String[] args) {
          Stack<Integer> s = new Stack<>();
  
          // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
          s.push(5);
          s.push(2);
          s.push(3);
          s.push(7);
          s.pop();
          s.push(1);
          s.push(4);
          s.pop();
          // 스택의 최상단 원소부터 출력
          while (!s.empty()) {
              System.out.println(s.peek());
              s.pop();
          }
      }
  
  }
  ```

<br>

### 💭 큐
- 큐(Queue) : ```선입선출(FIFO)```
- 예시
> 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
> - step 0 : 초기 단계
>   ```
>   ```
>
> - step 1 : 삽입(5)
>   ```
>   5
>   ```
>
> - step 2 : 삽입(5) - 삽입(2)
>   ```
>   2 5
>   ```
>
> - step 3 : 삽입(5) - 삽입(2) - 삽입(3)
>   ```
>   3 2 5
>   ```
>
> - step 4 : 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7)
>   ```
>   7 3 2 5
>   ```
>
> - step 5 : 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제()
>   ```
>   7 3 2 
>   ```
>
> - step 6 : 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1)
>   ```
>   1 7 3 2 
>   ```
>
> - step 7 : 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4)
>   ```
>   4 1 7 3 2
>   ```
>
> - step 8 : 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
>   ```
>   4 1 7 3
>   ```

- 코드 예시
  ```java
  import java.util.*;
  
  public class Main {
  
      public static void main(String[] args) {
          Queue<Integer> q = new LinkedList<>();
  
          // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
          q.offer(5);
          q.offer(2);
          q.offer(3);
          q.offer(7);
          q.poll();
          q.offer(1);
          q.offer(4);
          q.poll();
          // 먼저 들어온 원소부터 추출
          while (!q.isEmpty()) {
              System.out.println(q.poll());
          }
      }
  
  }
  ```
<br>

### 💭 재귀함수
- 재귀함수(Recursive Funciton) : 자기 자신을 다시 호출하는 함수
  ```java
  import java.util.*;
  
  public class Main {
  
      public static void recursiveFunction() {
          System.out.println("재귀 함수를 호출합니다.");
          recursiveFunction();
      }
  
      public static void main(String[] args) {
          recursiveFunction();
      }
  
  }
  ```
- ```recursive_funtion()``` : 자기 자신을 계속해서 추가로 불러옴.
- 어느 정도 출력을 하다가 다음과 같은 오류 메시지를 출력하고 멈출 것.
  <img width="1438" alt="image" src="https://github.com/hayannn/2L24-Algo-Study/assets/102213509/b8c28c9d-0bd8-4497-9418-89df5d009000">
- 프랙털 구조와 흡사함.

<br>

#### 재귀함수의 종료 조건📍
- 재귀함수를 100번 호출하도록 작성한 코드

  ```java
  import java.util.*;
  
  public class Main {
  
      public static void recursiveFunction(int i) {
          // 100번째 호출을 했을 때 종료되도록 종료 조건 명시
          if (i == 100) return;
          System.out.println(i + "번째 재귀 함수에서 " + (i + 1) + "번째 재귀함수를 호출합니다.");
          recursiveFunction(i + 1);
          System.out.println(i + "번째 재귀 함수를 종료합니다.");
      }
  
      public static void main(String[] args) {
          recursiveFunction(1);
      }
  
  }
  ```
  <img width="1436" alt="image" src="https://github.com/hayannn/2L24-Algo-Study/assets/102213509/80069439-30dd-4b65-b1f4-92f696cbeef6">
- 컴퓨터 내부에서 재귀 함수의 수행은 스택 자료구조를 이용함.
- 재귀 함수는 내부적으로 스택 자료구조와 동일함. -> ```DFS```가 대표적
- 대표 예시 : ```팩토리얼(Factorial)```
  - n!
  ```java
  import java.util.*;
  
  public class Main {
  
      // 반복적으로 구현한 n!
      public static int factorialIterative(int n) {
          int result = 1;
          // 1부터 n까지의 수를 차례대로 곱하기
          for (int i = 1; i <= n; i++) {
              result *= i;
          }
          return result;
      }
  
      // 재귀적으로 구현한 n!
      public static int factorialRecursive(int n) {
          // n이 1 이하인 경우 1을 반환
          if (n <= 1) return 1;
          // n! = n * (n - 1)!를 그대로 코드로 작성하기
          return n * factorialRecursive(n - 1);
      }
  
      public static void main(String[] args) {
          // 각각의 방식으로 구현한 n! 출력(n = 5)
          System.out.println("반복적으로 구현:" + factorialIterative(5));
          System.out.println("재귀적으로 구현:" + factorialRecursive(5));
      }
  
  }
  ```
> 분석
  1. 재귀 함수의 코드가 더 간결
     - 재귀 함수가 수학의 점화식(재귀식)을 그대로 소스코드로 옮겼기 때문.
     - 수학에서의 점화식은 특정한 함수를 자신보다 더 작은 변수에 대한 함수와의 관계로 표현한 것을 의미
   
     - 팩토리얼을 수학적 점화식으로 표현
       -  ```n이 0 혹은 1일 때: factorial(n) = 1```
       - ```n이 1보다 클 때: factorial(n) = n x factorial(n-1)```
     2. 팩토리얼은 n이 양의 정수일 때에만 유효하기 때문에 n이 1 이하인 경우 1을 반환할 수 있도록 재귀 함수 작성해야 함.
     3. n의 값으로 음수가 들어왔을 때는 입력 범위 오류로, 오류 메시지를 띄우도록 코드 작성
     4. 반드시 **종료 조건** 구현하기!
---
<br>

## 2️⃣ 탐색 알고리즘 DFS/BFS
