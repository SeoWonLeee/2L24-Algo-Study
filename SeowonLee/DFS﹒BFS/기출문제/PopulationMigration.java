package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PopulationMigration {
    static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        L = scanner.nextInt();
        R = scanner.nextInt();

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int moveCount = 0;

        // 인구 이동이 없을 때까지 반복
        while (true) {
            boolean moved = false;
            visited = new boolean[N][N];

            // 모든 국가에 대해 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (dfs(i, j)) { // 국경 열기
                            moved = true; // 인구 이동 발생
                        }
                    }
                }
            }

            // 인구 이동이 없으면
            if (!moved) {
                break;
            }

            moveCount++;
        }

        System.out.println(moveCount);
    }

    // 인구 이동 시도 DFS
    static boolean dfs(int x, int y) {
        LinkedList<Node> union = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        int population = 0;

        queue.offer(new Node(x, y));
        visited[x][y] = true;

        // BFS
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentX = currentNode.row;
            int currentY = currentNode.col;

            union.add(new Node(currentX, currentY)); // 연합에 국가 추가
            population += map[currentX][currentY]; // 연합 인구 수 합산

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                // 범위 내에 있고 방문하지 않았으며, 인구 차이가 조건에 맞을 경우
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N
                        && !visited[nextX][nextY]
                        && Math.abs(map[currentX][currentY] - map[nextX][nextY]) >= L
                        && Math.abs(map[currentX][currentY] - map[nextX][nextY]) <= R) {
                    queue.offer(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }

        // 연합 국가 수가 2개 이상인 경우
        if (union.size() > 1) {
            int avgPopulation = population / union.size(); // 평균 인구 수 계산
            // 연합 국가의 인구 수를 평균값으로 변경
            for (Node node : union) {
                map[node.row][node.col] = avgPopulation;
            }
            return true; // 인구 이동 발생
        }

        return false; // 인구 이동 없음
    }
}
