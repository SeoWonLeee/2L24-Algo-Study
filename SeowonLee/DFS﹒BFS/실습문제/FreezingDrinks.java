package DFS_BFS;

import java.util.Scanner;

public class FreezingDrinks {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static int[][] iceFrame;
    private static boolean[][] visited;

    // 얼음 틀의 형태를 DFS로 탐색
    private static void dfs(int x, int y, int n, int m) {
        visited[x][y] = true;

        // 상하좌우 위치 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크 및 구멍이 뚫려 있는지 확인
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && iceFrame[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(nx, ny, n, m);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        iceFrame = new int[n][m];
        visited = new boolean[n][m];

        // 얼음 틀의 형태
        for (int i = 0; i < n; i++) {
            String input = scanner.next();
            for (int j = 0; j < m; j++) {
                iceFrame[i][j] = input.charAt(j) - '0';
            }
        }

        int iceCreamCount = 0;

        // 모든 위치에 대해 DFS 수행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 구멍이 뚫려 있고 방문하지 않은 경우에만 DFS 수행
                if (iceFrame[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j, n, m);
                    iceCreamCount++;
                }
            }
        }

        System.out.println(iceCreamCount);
    }
}
