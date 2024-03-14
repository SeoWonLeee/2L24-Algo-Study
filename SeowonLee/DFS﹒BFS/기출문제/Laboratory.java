package DFS_BFS;

import java.util.*;

public class Laboratory {
    static int N, M;
    static int[][] map;
    static int[][] tempMap;
    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};
    static int maxSafeZone = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N][M];
        tempMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        // 벽을 세울 수 있는 모든 경우의 수 계산 (DFS)
        buildWall(0);

        System.out.println(maxSafeZone);

        scanner.close();
    }

    // 벽을 세우는 모든 경우의 수 계산
    static void buildWall(int wallCount) {
        if (wallCount == 3) { // 벽을 3개 세웠으면
            spreadVirus(); // 바이러스를 퍼뜨리고
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { // 빈칸이면
                    map[i][j] = 1; // 벽을 세우고
                    buildWall(wallCount + 1); // 다음 벽을 세우러 이동
                    map[i][j] = 0; // 벽을 다시 없애고
                }
            }
        }
    }

    // 바이러스 퍼뜨리기 (BFS)
    static void spreadVirus() {
        Queue<int[]> queue = new LinkedList<>();

        // 임시 맵에 현재 상태 복사
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, M);
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 2) { // 바이러스가 있는 위치 추가
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // BFS로 바이러스 퍼뜨리기
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (tempMap[nx][ny] == 0) {
                        tempMap[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        // 안전 영역 크기 계산
        int safeZoneSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    safeZoneSize++;
                }
            }
        }

        maxSafeZone = Math.max(maxSafeZone, safeZoneSize);
    }
}
