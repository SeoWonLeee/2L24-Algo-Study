package Greedy;

import java.util.Scanner;

public class GameDevelopment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 맵의 세로 크기
        int M = scanner.nextInt(); // 맵의 가로 크기
        int[][] map = new int[N][M];

        int x = scanner.nextInt(); // 캐릭터의 초기 x 위치
        int y = scanner.nextInt(); // 캐릭터의 초기 y 위치
        int direction = scanner.nextInt(); // 캐릭터가 바라보는 방향

        // 북, 동, 남, 서 방향의 이동 좌표
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int count = 1;
        map[x][y] = 1;

        // 캐릭터의 이동
        while (true) {
            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                direction = (direction + 3) % 4;
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                // 이동 가능한 경우
                if (map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    x = nx;
                    y = ny;
                    count++;
                    moved = true;
                    break;
                }
            }

            // 네 방향 모두 갈 수 없는 경우
            if (!moved) {
                int nx = x - dx[direction];
                int ny = y - dy[direction];
                // 뒤로 이동할 수 있으면 이동
                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else { // 뒤로 이동할 수 없으면 종료
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
