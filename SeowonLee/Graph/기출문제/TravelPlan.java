package Graph;

import java.util.Scanner;

public class TravelPlan {
    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 여행지 간의 연결 정보
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = scanner.nextInt();
                if (graph[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획
        int[] plan = new int[M];
        for (int i = 0; i < M; i++) {
            plan[i] = scanner.nextInt();
        }

        // 모든 여행지가 같은 집합에 속하는지 확인
        boolean possible = true;
        int root = find(plan[0]);
        for (int i = 1; i < M; i++) {
            if (find(plan[i]) != root) {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
