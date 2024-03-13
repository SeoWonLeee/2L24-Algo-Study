# **🏷️  DFS/BFS;** 사전 학습 (1)

**1. 탐색**
- 많은 양의 데이터 중에서 원하는 데이터를 찾는 과정
- 탐색 대표 문제 : 그래프, 트리 → 그 중에서 대표적인 탐색 알고리즘 **DFS/BFS**
- **DFS/BFS**를 이해하기 위해 스택﹒큐에 대한 개념이 전제되어 있어야 함
<br/>

**2. 자료구조**
- 데이터를 표현하고 관리하고 처리하기 위한 구조
- 스택﹒큐 자료구조의 삽입﹒삭제 함수로 구성 및 오버플로﹒언더플로 고려
  - 삽입 Push : 데이터 삽입
  - 삭제 Pop : 데이터 삭제
  - 오버플로 Overflow : 특정한 자료구조가 수용할 수 있는 데이터의 크기를 이미 가득 찬 상태에서 삽입 연산을 수행할 때 발생
  - 언더플로 Underflow : 특정한 자료구조에 데이터가 전혀 들어 있지 않은 상태에서 삭제 연산을 수행하면 데이터가 전혀 없는 상태
<br/>

**3. 스택**
- ex) 아래부터 위로 박스 쌓기
- **선입후출** First In Last Out 구조 or **후입선출** Last In First Out 구조
- 스택 연산 수행 예시
<img width="486" alt="stack" src="https://github.com/SeoWonLeee/2L24-Algo-Study/assets/148112372/0938695a-9c24-425b-9ecc-461c1cf738d2">
<br/>
<br/>

**4. 큐**
- ex) 대기 줄서기
- **선입선출** Fisrt In First Out 구조
- 큐 연산 수행 예시
<img width="486" alt="Queue" src="https://github.com/SeoWonLeee/2L24-Algo-Study/assets/148112372/e0bbe8bc-b55b-47ff-98a2-565b149df177">
<br/>
<br/>

**5. 재귀 함수**
- 자기 자신을 다시 호출하는 함수
- 재귀 함수 예시
    - “재귀 함수를 호출합니다” 문자열 무한히 출력 → recursive_function()이 자기 자신을 계속 호출하기 때문
        
        ```java
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
        
    - 호출 스택의 한계(호출 스택 오버플로우 (StackOverflowError)가 발생)으로 오류 메시지 출력
        
        ```java
        Exception in thread "main" java.lang.StackOverflowError
            at Main.recursiveFunction(Main.java:4)
            at Main.recursiveFunction(Main.java:4)
            at Main.recursiveFunction(Main.java:4)
            ...
        ```
        
- 재귀 함수의 종료 조건
    - 함수의 무한 호출을 대비하기 위해 종료 조건 꼭 명시
    - 재귀 함수 종료 예제
 
      ```java
      public class Main {
          public static final int MAX_DEPTH = 10; // 최대 재귀 호출 횟수
    
          public static void recursiveFunction(int depth) {
              System.out.println("재귀 함수를 호출합니다. (호출 횟수: " + depth + ")");
              if (depth < MAX_DEPTH) {
                  recursiveFunction(depth + 1); // 깊이를 증가시키며 재귀 호출
              } else {
                  System.out.println("최대 재귀 호출 횟수에 도달하여 종료합니다.");
              }
          }
    
          public static void main(String[] args) {
              recursiveFunction(1); // 초기 호출 깊이는 1로 시작
          }
      }
      ```
    
- 재귀 함수는 내부적으로 스택 자료구조와 동일
    - 컴퓨터 내부에서 재귀 함수의 수행은 스택 자료구조를 이용
    - 함수를 계속 호출했을 때 가장 마지막에 호출한 함수가 먼저 수행을 끝내야 그 앞의 함수 호출이 종료되기 때문
    - (컴퓨터 구조 시점) 연속해서 호출되는 함수는 메인 메모리의 스택 공간에 적재됨
<br/>

**6. 재귀 함수를 이용하는 대표적인 예제 → 팩토리얼 Factorial 문제**
    
```java
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
        // 종료 조건: n이 1 이하인 경우 1을 반환
        if (n <= 1) return 1;
        // 재귀 호출: n! = n * (n - 1)!를 그대로 코드로 작성
        return n * factorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        // 각각의 방식으로 구현한 n! 출력(n = 5)
        System.out.println("반복적으로 구현: " + factorialIterative(5));
        System.out.println("재귀적으로 구현: " + factorialRecursive(5));
    }
}

```
    
  - 팩토리얼을 반복적으로 구현한 방식과 재귀적으로 구현 방식의 실행 결과는 동일
  - 그러나, 재귀 함수를 사용했을 때 얻을 수 있는 장점
    - 재귀 함수의 코드가 더 간결함
    - 간결해진 이유 → 재귀 호출을 사용하여 반복적인 작업을 수행하는 방법 때문 (재귀 함수는 자기 자신을 호출함으로써 반복을 대신함)
