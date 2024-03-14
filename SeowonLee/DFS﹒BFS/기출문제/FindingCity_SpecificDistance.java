package DFS_BFS;

import java.util.*;

public class FindingCity_SpecificDistance {
    static class Graph {
        int V;
        ArrayList<Integer>[] adj;

        Graph(int v) {
            V = v;
            adj = new ArrayList[v + 1];
            for (int i = 1; i <= v; i++)
                adj[i] = new ArrayList<>();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        // BFS 알고리즘을 사용하여 특정 거리의 도시를 찾기
        ArrayList<Integer> BFS(int s, int k) {
            boolean[] visited = new boolean[V + 1]; // 방문 여부
            ArrayList<Integer> result = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            int[] distance = new int[V + 1]; // 출발 도시로부터의 거리

            visited[s] = true; // 시작 도시 방문 처리
            queue.offer(s);

            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (int v : adj[u]) {
                    if (!visited[v]) { // 방문하지 않은 도시인 경우
                        visited[v] = true; // 도시 방문 처리
                        distance[v] = distance[u] + 1;
                        queue.offer(v);
                        if (distance[v] == k) // 목표 거리에 도달한 경우
                            result.add(v);
                    }
                }
            }
            return result;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 도시의 수
        int M = scanner.nextInt(); // 도로의 수
        int K = scanner.nextInt(); // 목표 거리
        int X = scanner.nextInt(); // 출발 도시 번호

        Graph graph = new Graph(N);

        for (int i = 0; i < M; i++) { // 도로 정보
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            graph.addEdge(A, B);
        }

        ArrayList<Integer> citiesAtDistanceK = graph.BFS(X, K); // BFS 실행

        if (citiesAtDistanceK.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(citiesAtDistanceK);
            for (int city : citiesAtDistanceK) {
                System.out.println(city);
            }
        }
    }
}
