package Shortest_Path;

import java.util.Arrays;
import java.util.Scanner;

public class Floyd {
    static final int INF = 100000 * 100 + 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        // 버스 정보
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int c = scanner.nextInt();
            graph[a][b] = Math.min(graph[a][b], c);
        }

        // 플로이드 와샬
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) { // 출발
                for (int j = 0; j < n; j++) { // 도착
                    // i에서 j로 가는 경로가 i에서 k를 거쳐 j로 가는 경로보다 비용이 더 작은 경우
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == INF) {
                    System.out.print("0 ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
