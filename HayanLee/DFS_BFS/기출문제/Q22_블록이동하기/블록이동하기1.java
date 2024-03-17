package HayanLee.DFS_BFS.기출문제.Q22_블록이동하기;

//알고리즘 출처 : https://thdbs523.tistory.com/263

import java.util.*;

class 블록이동하기1 {

    public int solution(int[][] board) {
        int N = board.length;
        boolean[][][] visited = new boolean[2][N][N];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Robot> queue = new LinkedList<>();
        queue.offer(new Robot(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Robot current = queue.poll();
            if ((current.d == 0 && current.x == N - 1 && current.y + 1 == N - 1) ||
                    (current.d == 1 && current.x + 1 == N - 1 && current.y == N - 1)) {
                return current.time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i], ny = current.y + dy[i];
                if (!isMoved(nx, ny, current.d, visited, board, N)){
                    continue;
                }
                visited[current.d][nx][ny] = true;
                queue.offer(new Robot(nx, ny, current.d, current.time + 1));
            }

            for (int i = 0; i < 2; i++) {
                int nextDir = (current.d + 1) % 2;
                int nx = current.x + dx[i], ny = current.y + dy[i];
                if (!isMoved(nx, ny, nextDir, visited, board, N)) continue;
                visited[nextDir][nx][ny] = true;
                queue.offer(new Robot(nx, ny, nextDir, current.time + 1));
            }
        }
        return -1;
    }

    static boolean isMoved(int x, int y, int d, boolean[][][] visited, int[][] board, int N) {
        if (x < 0 || x >= N || y < 0 || y >= N || visited[d][x][y] || board[x][y] == 1){
            return false;
        }

        if (d == 0 && (y + 1 >= N || board[x][y + 1] == 1)){
            return false;
        }

        if (d == 1 && (x + 1 >= N || board[x + 1][y] == 1)){
            return false;
        }

        return true;
    }

    static class Robot {
        int x, y, d, time;
        Robot(int x, int y, int d, int time) {
            this.x = x; this.y = y; this.d = d; this.time = time;
        }
    }
}
