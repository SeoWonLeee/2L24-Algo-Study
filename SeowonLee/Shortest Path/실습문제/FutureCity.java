package Shortest_Path;

import java.util.*;

public class FutureCity {

    static final int INF = (int) 1e9; // 무한

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 회사의 개수, 경로의 개수
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] graph = new int[N + 1][N + 1];

        // 그래프 무한으로 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                graph[i][j] = INF;
            }
        }

        // 연결된 회사
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // 소개팅 상대의 위치와 방문 판매원이 가야 할 곳
        int X = sc.nextInt();
        int K = sc.nextInt();

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int distance = graph[1][K] + graph[K][X];
        if (distance >= INF) {
            System.out.println("-1");
        } else {
            System.out.println(distance);
        }
    }
}
