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
### 💭 DFS
- Depth-First Search(깊이 우선 탐색) : 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘
> 그래프의 기본 구조
> ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/2206cc34-5fef-4c95-9008-dc2e8109bc63)
> - ```노드(Node) or 정점(Vertex)```와 ```간선(Edge)```으로 표현
> - 그래프 탐색 : 하나의 노드를 시작으로 다수의 노드를 방문하는 것
> - 두 노드가 간선으로 연결되어 있다면 ```'두 노드는 인접하다(Adjacent)'```

<br>

- 코딩테스트에서 이 2가지 방식을 이용
  - ```인접 행렬(Adjacency Matrix)``` : 2차원 배열로 그래프의 연결 관계를 표현하는 방식
  - ```인접 리스트(Adjacency List)``` : 리스트로 그래프의 연결 관계를 표현하는 방식
    ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/0b77e36e-8f06-4c2c-96d8-00f2160cf326)

<br>

#### 인접 행렬(Adjacency Matrix) 방식
- 2차원 배열에 각 노드가 연결된 형태를 기록하는 방식
- 2차원 리스트로 구현
- 인접 행렬 방식의 처리 시, 데이터 초기화 방법
  ```java
  import java.util.*;
  
  public class Main {
      
      // 무한의 비용 표현  
      public static final int INF = 999999999;
      
      // 2차원 리스트를 이용해 인접 행렬 표현
      public static int[][] graph = {
          {0, 7, 5},
          {7, 0, INF},
          {5, INF, 0}
      };
  
      public static void main(String[] args) {
          // 그래프 출력
          for (int i = 0; i < 3; i++) {
              for (int j = 0; j < 3; j++) {
                  System.out.print(graph[i][j] + " ");
              }
              System.out.println();
          }
      }
  
  }
  ```
  > [출력] <br>
  > 0 7 5 <br>
  > 7 0 999999999 <br>
  > 5 999999999 0 <br>

<br>

#### 인접 리스트(Adjacency List) 방식
![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/f76c304a-97b3-463c-ac1f-bf21d3072739)
- 모든 노드에 연결된 노드에 대한 정보를 차례대로 연결하여 저장
- 인접 리스트는 '연결 리스트'라는 자료구조를 이용해 구현
- C++, 자바와 같은 프로그래밍 언어에서는 별도로 연결 리스트 기능을 위한 표준 라이브러리 제공
- 파이썬은 기본 자료형인 리스트 자료형이 append()와 메소드를 제공

  ```java
  import java.util.*;
  
  class Node {
  
      private int index;
      private int distance;
  
      public Node(int index, int distance) {
          this.index = index;
          this.distance = distance;
      }
  
      public void show() {
          System.out.print("(" + this.index + "," + this.distance + ") ");
      }
  }
  
  public class Main {
  
      // 행(Row)이 3개인 인접 리스트 표현
      public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
  
      public static void main(String[] args) {
          // 그래프 초기화
          for (int i = 0; i < 3; i++) {
              graph.add(new ArrayList<Node>());
          }
  
          // 노드 0에 연결된 노드 정보 저장 (노드, 거리)
          graph.get(0).add(new Node(1, 7));
          graph.get(0).add(new Node(2, 5));
  
          // 노드 1에 연결된 노드 정보 저장 (노드, 거리)
          graph.get(1).add(new Node(0, 7));
  
          // 노드 2에 연결된 노드 정보 저장 (노드, 거리)
          graph.get(2).add(new Node(0, 5));
  
          // 그래프 출력
          for (int i = 0; i < 3; i++) {
              for (int j = 0; j < graph.get(i).size(); j++) {
                  graph.get(i).get(j).show();
              }
              System.out.println();
          }
      }
  
  }
  ```
  > [출력] <br>
  > (1,7) (2,5) <br>
  > (0,7) <br>
  > (0,5)

<br>

#### 인접 행렬(Adjacency Matrix) ```VS``` 인접 리스트(Adjacency List)
- 메모리 측면
  - ```인접 행렬``` < ```인접 리스트```(낭비가 적다.)
    - 인접 행렬 방식은 모든 관계를 저장하므로 노드 개수가 많을수록 메모리가 불필요하게 낭비됨.
    - 인접 리스트 방식은 연결된 정보만 저장하기 때문에 메모리를 효율적으로 사용함.
      - 다만, 인접 리스트 방식은 인접 행렬 방식에 비해 특정한 두 노드가 연결되어 있는지에 대한 정보를 얻는 속도가 느림.
    - 특정한 노드와 연결된 모든 인접 노드를 순회해야 하는 경우, 인접 리스트 방식이 인접 행렬 방식에 비해 메모리 공간 낭비가 적음.

<br>

#### DFS의 동작 과정
- DFS는 스택 자료구조 이용
1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문 처리를 한다.<br>방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
3. 2의 과정을 더 이상 수행할 수 없을 때까지 반복한다.
> 방문 처리 : 스택에 한 번 삽입되어 처리된 노드가 다시 삽입되지 않게 체크하는 것을 의미

<br>

- 그래프
![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/078c24de-39f1-4424-983d-e4f1828d32a4)

<br>

- DFS 풀이
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/d77188ed-b8db-49f8-a732-156c13060558)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/860430b0-0613-4465-9b3f-cc202de4e4f5)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/902a2bde-13c1-4af9-ac68-633aa3be8c62)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/7d257954-798f-45f0-a7d5-2783695dde63)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/c8b12889-3f25-4992-beb3-d155c20ef1f8)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/076fdae4-05bc-4156-9d3c-711ae3f25463)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/b9967313-2722-451b-914f-f130ce7cb494)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/e7fae729-847c-4269-829e-079e6baec07f)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/b9bc00c6-2465-4f0b-980b-da2aca6a66df)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/c4cb845b-0e9e-4637-bb65-f4eef071870d)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/8bf0a5fe-b541-44c5-b37b-23612ece2937)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/318ff99b-c10c-4f06-8608-6ccbc3d0968b)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/06042208-7543-40f8-ae98-4ac1fdd5ff8b)

<br>

- 노드의 탐색 순서(스택에 들어간 순서) : ```1 -> 2 -> 7 -> 8 -> 3 -> 4 -> 5```
- 실제로는 스택을 쓰지 않아도 되며 탐색을 수행함에 있어서 데이터의 개수가 N개인 경우 **O(N)** 의 시간이 소요된다는 특징이 있음.
- 또한, **DFS**는 스택을 이용하는 알고리즘 -> 실제 구현은 **재귀 함수**를 이용했을 때 매우 간결히 표현 가능

  ```java
  import java.util.*;
  
  public class Main {
  
      public static boolean[] visited = new boolean[9];
      public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
  
      // DFS 함수 정의
      public static void dfs(int x) {
          // 현재 노드를 방문 처리
          visited[x] = true;
          System.out.print(x + " ");
          // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
          for (int i = 0; i < graph.get(x).size(); i++) {
              int y = graph.get(x).get(i);
              if (!visited[y]) dfs(y);
          }
      }
  
      public static void main(String[] args) {
          // 그래프 초기화
          for (int i = 0; i < 9; i++) {
              graph.add(new ArrayList<Integer>());
          }
  
          // 노드 1에 연결된 노드 정보 저장 
          graph.get(1).add(2);
          graph.get(1).add(3);
          graph.get(1).add(8);
          
          // 노드 2에 연결된 노드 정보 저장 
          graph.get(2).add(1);
          graph.get(2).add(7);
          
          // 노드 3에 연결된 노드 정보 저장 
          graph.get(3).add(1);
          graph.get(3).add(4);
          graph.get(3).add(5);
          
          // 노드 4에 연결된 노드 정보 저장 
          graph.get(4).add(3);
          graph.get(4).add(5);
          
          // 노드 5에 연결된 노드 정보 저장 
          graph.get(5).add(3);
          graph.get(5).add(4);
          
          // 노드 6에 연결된 노드 정보 저장 
          graph.get(6).add(7);
          
          // 노드 7에 연결된 노드 정보 저장 
          graph.get(7).add(2);
          graph.get(7).add(6);
          graph.get(7).add(8);
          
          // 노드 8에 연결된 노드 정보 저장 
          graph.get(8).add(1);
          graph.get(8).add(7);
  
          dfs(1);
      }
  
  }
  ```
  > [출력] <br>
  > 1 2 7 6 8 3 4 5

<br>
<br>

### 💭 BFS
- Breadth First Search : 너비 우선 탐색
- 가까운 노드부터 탐색하는 알고리즘
- 선입선출 방식인 ```큐``` 자료구조 이용

<br>

#### BFS의 동작 과정
1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리를 한다.
3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.


- 그래프
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/078c24de-39f1-4424-983d-e4f1828d32a4)

<br>

- BFS 풀이
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/48f3a082-d22a-45fc-8c5e-e7bf515d8506)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/e402e9d7-09ae-4178-9014-344405a93352)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/a1040458-4e3c-49c2-b7e1-ad9b0394e4d9)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/697586ab-8ed2-4288-999b-1dd1ceed3a5f)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/aa758887-c398-4407-85e8-441bacbd7f8a)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/7bf52125-9448-4005-9b2d-0309d3018a05)
  ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/a877d5f5-eec1-4f71-833c-54c3d9f902a9)

  ```java
  import java.util.*;
  
  public class Main {
  
      public static boolean[] visited = new boolean[9];
      public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
  
      // BFS 함수 정의
      public static void bfs(int start) {
          Queue<Integer> q = new LinkedList<>();
          q.offer(start);
          // 현재 노드를 방문 처리
          visited[start] = true;
          // 큐가 빌 때까지 반복
          while(!q.isEmpty()) {
              // 큐에서 하나의 원소를 뽑아 출력
              int x = q.poll();
              System.out.print(x + " ");
              // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
              for(int i = 0; i < graph.get(x).size(); i++) {
                  int y = graph.get(x).get(i);
                  if(!visited[y]) {
                      q.offer(y);
                      visited[y] = true;
                  }
              }
          }
      }
  
      public static void main(String[] args) {
          // 그래프 초기화
          for (int i = 0; i < 9; i++) {
              graph.add(new ArrayList<Integer>());
          }
  
          // 노드 1에 연결된 노드 정보 저장 
          graph.get(1).add(2);
          graph.get(1).add(3);
          graph.get(1).add(8);
          
          // 노드 2에 연결된 노드 정보 저장 
          graph.get(2).add(1);
          graph.get(2).add(7);
          
          // 노드 3에 연결된 노드 정보 저장 
          graph.get(3).add(1);
          graph.get(3).add(4);
          graph.get(3).add(5);
          
          // 노드 4에 연결된 노드 정보 저장 
          graph.get(4).add(3);
          graph.get(4).add(5);
          
          // 노드 5에 연결된 노드 정보 저장 
          graph.get(5).add(3);
          graph.get(5).add(4);
          
          // 노드 6에 연결된 노드 정보 저장 
          graph.get(6).add(7);
          
          // 노드 7에 연결된 노드 정보 저장 
          graph.get(7).add(2);
          graph.get(7).add(6);
          graph.get(7).add(8);
          
          // 노드 8에 연결된 노드 정보 저장 
          graph.get(8).add(1);
          graph.get(8).add(7);
  
          bfs(1);
      }
  
  }
  ```
  > [출력] <br>
  > 1 2 3 8 7 4 5 6

- 실제 구현 : 파이썬의 경우 deque 라이브러리를 사용하는 것이 좋으며, 탐색을 수행함에 있어 O(N)의 시간이 소요된다.
- 일반적인 경우 실제 수행 시간은 DFS보다 좋은 편이라는 점 기억하기!

<br>

### 💭 정리

| - | DFS |    BFS    |
|:----:|:-----:|:---------:|
|동작 원리 | 스택 |     큐     |
| 구현 방법 | 재귀 함수 이용 | 큐 자료구조 이용 |

- 1차원 배열, 2차원 배열 또한 그래프 형태로 생각하면 수월하게 문제 풀이 가능(특히나 DFS, BFS 문제 유형이 그러함)
- ```코딩 테스트에서 탐색 문제를 보면 그래프 형태로 표현한 다음 풀이법을 고민하기!```
> 예시
> - 게임 맵이 3 X 3 형태의 2차원 배열이고 각 데이터를 좌표라고 생각하기 (게임 캐릭터가 (1,1) 좌표에 있다고 표현할 때처럼)
> - 이때 각 좌표를 상하좌우로만 이동할 수 있다면 -> 모든 좌표의 형태를 그래프의 형태로 바꿔서 생각할 수 있음!
> ![image](https://github.com/hayannn/2L24-Algo-Study/assets/102213509/02ad920e-8cec-45ca-9194-89118011fb32)
