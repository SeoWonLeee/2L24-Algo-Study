package HayanLee.DFS_BFS.기출문제.Q22_블록이동하기;

//알고리즘 출처 : https://thdbs523.tistory.com/263

import java.util.LinkedList;
import java.util.Queue;

class 블록이동하기2 {

    static int N;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        N = board.length;
        visited = new boolean[2][N][N];

        return bfs(board);
    }

    static int bfs(int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int d = current[2];
            int time = current[3];

            if ((d == 0 && (x == N - 1 && y + 1 == N - 1 || x == N - 1 && y == N - 1)) || (d == 1 && (x + 1 == N - 1 && y == N - 1 || x == N - 1 && y == N - 1))) {
                return time;
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isMoved(nx, ny, d, board)) {
                    visited[d][nx][ny] = true;
                    queue.offer(new int[]{nx, ny, d, time + 1});
                }
            }

            // 가로 방향일 때 회전
            if (d == 0) {
                for (int i = 2; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (isMoved(nx, ny, 1, board)) {
                        visited[1][nx][ny] = true;
                        queue.offer(new int[]{nx, ny, 1, time + 1});
                    }
                }
            }

            // 세로 방향일 때 회전
            if (d == 1) {
                for (int i = 0; i < 2; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (isMoved(nx, ny, 0, board)) {
                        visited[0][nx][ny] = true;
                        queue.offer(new int[]{nx, ny, 0, time + 1});
                    }
                }
            }
        }
        return -1;
    }

    static boolean isMoved(int x, int y, int d, int[][] board) {
        if (x < 0 || x >= N || y < 0 || y >= N || visited[d][x][y] || board[x][y] == 1)
            return false;

        if (d == 0 && (y + 1 >= N || board[x][y + 1] == 1)) {
            return false;
        }

        if (d == 1 && (x + 1 >= N || board[x + 1][y] == 1)) {
            return false;
        }

        return true;
    }
}