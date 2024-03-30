package Shortest_Path;

import java.util.*;

public class AccuratingRanking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int INF = 1000000000;

        int[][] graph = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        // 두 학생 간의 비교
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
        }

        // 플로이드 와샬
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int count = 0;

        // 각 학생에 대해 정확한 순위를 알 수 있는지 확인
        for (int i = 1; i <= n; i++) {
            boolean accurate = true;
            for (int j = 1; j <= n; j++) {
                // i에서 j로 갈 수 없고, j에서 i로 갈 수 없으면 순위를 정확하게 알 수 없는 경우
                if (graph[i][j] == INF && graph[j][i] == INF) {
                    accurate = false;
                    break;
                }
            }
            if (accurate) count++;
        }

        System.out.println(count);
    }
}
