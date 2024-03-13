package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeEscape {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int[][] maze;
    private static boolean[][] visited;

    // BFS를 사용하여 미로를 탈출하는 최소 칸의 개수 계산
    private static int bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 출구에 도달한 경우 탐색 종료
            if (x == n - 1 && y == m - 1)
                return maze[x][y];

            // 상하좌우 위치 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크 및 이동 가능한 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    maze[nx][ny] = maze[x][y] + 1;
                }
            }
        }

        // 탈출 실패
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        maze = new int[n][m];
        visited = new boolean[n][m];

        // 미로의 형태
        for (int i = 0; i < n; i++) {
            String input = scanner.next();
            for (int j = 0; j < m; j++) {
                maze[i][j] = input.charAt(j) - '0';
            }
        }

        int result = bfs(n, m); // BFS로 최소 칸의 개수
        System.out.println(result);
    }
}
