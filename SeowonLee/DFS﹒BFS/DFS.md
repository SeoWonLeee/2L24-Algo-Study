# **🏷️ DFS**

- 깊이 우선 탐색
- 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘
- 탐색을 위해서 사용되는 탐색 알고리즘
- 특정한 경로로 탐색하다가 특정한 상황에서 최대한 깊숙이 들어가서 노드를 방문한 후, 다시 돌아가 다른 경로로 탐색하는 알고리즘
<br/>

**📌 Tip**

- ‘방문 처리’는 스택에 한 번 삽입되어 처리된 노드가 다시 삽입되지 않게 체크하는 것을 의미
- 방문 처리를 함으로써 각 노드를 한 번씩만 처리 가능
- DFS의 기능을 생각하면 순서와 상관없이 처리해도 되지만, 코딩테스트에서는 번호가 낮은 순서부터 처리하도록 명시하는 경우가 종종 있음 <br/> (관행적으로 번호가 낮은 순서부터 처리하도록 구현하는 편)
<br/>

- DFS의 스택 자료구조를 이용한 동작 과정
    1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
    2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문 처리를 한다. 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
    3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.
<br/>

- DFS를 이용한 탐색 예시 (노드 1을 시작 노드로 설정)
    
  <img width="300" alt="DFS" src="https://github.com/SeoWonLeee/2L24-Algo-Study/assets/148112372/991979d6-5e82-49d4-b1b9-d5cf8bd33f50">
  
  일반적으로 인접한 노드 중에서 방문하지 않은 노드가 여러 개 있으면 번호가 낮은 순서부터 처리
    
  <img width="755" alt="DFS 탐색 예시" src="https://github.com/SeoWonLeee/2L24-Algo-Study/assets/148112372/fc88d967-83e4-4327-90e0-2bc61ac2964c">
    
  - 결과적으로 노드의 탐색 순서 (스택에 들어간 순서) : 1 → 2 → 7 → 6 → 8 → 3 → 4 → 5
  <br/>
  
  - 깊이 우선 탐색 알고리즘인 **DFS**는 스택 자료구조에 기초한다는 점에서 구현이 간단하다.
  - 실제로는 스택을 쓰지 않아도 되며 탐색을 수행함에 있어서 데이터의 개수가 N개인 경우 $O(N)$의 시간이 소요된다.
<br/>

```java
import java.util.ArrayList;

public class Main {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    // DFS 함수 정의
    public static void dfs(int x) {
        // 현재 노드를 방문 처리
        visited[x] = true;
        System.out.print(x + " ");
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) {
                dfs(y);
            }
        }
    }

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<>());
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

        dfs(1);
    }

}
```
