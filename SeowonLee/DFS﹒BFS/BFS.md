# **🏷️ BFS**

- 너비 우선 탐색
- 가까운 노드부터 우선적으로 탐색하는 알고리즘
- 탐색을 위해서 사용되는 탐색 알고리즘
- 선입선출 방식인 큐 자료구조를 이용하는 것의 정석
- 인접한 노드를 반복적으로 큐에 넣도록 알고리즘을 설계하면 자연스럽게 먼저 들어온 것이 먼저 나가게 되어, 가까운 노드부터 탐색을 진행
<br/>

**📌 Tip**

- 코딩테스트에서는 보통 DFS보다 BFS 구현이 조금 더 빠르게 동작 <br/>
  (‘재귀 함수로 DFS를 구현하면 컴퓨터 시스템의 동작 특성상 실제 프로그램의 수행 시간은 느려질 수 있기 때문)
<br/>

- BFS의 스택 자료구조를 이용한 동작 과정
    1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
    2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리를 한다.
    3. 2번의 과정을 더 이상 수행 할 수  없을 때까지 반복한다.
<br/>

- BFS를 이용한 탐색 예시 (노드 1을 시작 노드로 설정)
    
  <img width="300" alt="BFS" src="https://github.com/SeoWonLeee/2L24-Algo-Study/assets/148112372/58ff6ec4-3b35-410d-ac72-3d61fab34f11">
  
  <img width="858" alt="BFS 탐색 예시" src="https://github.com/SeoWonLeee/2L24-Algo-Study/assets/148112372/9d915dd9-a26f-47f9-9cce-3732a94c6135">

  - 결과적으로 노드의 탐색 순서 (큐에 들어간 순서) : 1 → 2 → 3 → 8 → 7 → 4 → 5 → 6
   <br/>
 
  - 너비 우선 탐색 알고리즘인 BFS는 큐 자료구조에 기초한다는 점에서 구현이 간단하다.
  - 실제로 구현함헤 있어 앞서 언급한 대로 deque 라이브러리를 사용하는 것이 좋으며 탐색을 수행함에 있어 $O(N)$의 시간이 소요된다.
  - 일반적인 경우 실제 수행 시간은 DFS보다 좋은 편이다.
<br/>

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // BFS 함수 정의
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        // 현재 노드를 방문 처리
        visited[start] = true;
        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            int current = queue.poll();
            System.out.print(current + " ");
            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for (int i = 0; i < graph.get(current).size(); i++) {
                int next = graph.get(current).get(i);
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드에 연결된 노드 정보 저장 
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        
        graph.get(2).add(1);
        graph.get(2).add(7);
        
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        graph.get(6).add(7);
        
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
    }
}
```
<br/>

### DFS﹒BFS 정리

|  | DFS | BFS |
| --- | --- | --- |
| 동작 원리 | 스택 | 큐 |
| 구현 방법 | 재귀 함수 이용 | 큐 자료구조 이용 |
