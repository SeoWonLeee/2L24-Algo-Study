package Implementation;

import java.util.*;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 보드의 크기 입력
        int N = scanner.nextInt();
        int[][] board = new int[N + 1][N + 1];
        // 초기 사과 위치 설정
        int K = scanner.nextInt();
        for (int i = 0; i < K; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            board[row][col] = 1; // 사과 위치 표시
        }

        // 방향 변환 정보 입력
        int L = scanner.nextInt();
        Map<Integer, Character> directionChange = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int time = scanner.nextInt();
            char dir = scanner.next().charAt(0);
            directionChange.put(time, dir);
        }

        // 방향 설정
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int direction = 0;
        int time = 0;
        int x = 1, y = 1;
        Queue<int[]> snake = new LinkedList<>();
        snake.offer(new int[]{x, y});

        while (true) {
            time++;

            // 뱀의 다음 위치 계산
            x += dx[direction];
            y += dy[direction];

            // 게임 종료 조건 확인
            if (x < 1 || x > N || y < 1 || y > N || board[x][y] == -1) {
                break;
            }

            // 뱀의 머리를 추가
            snake.offer(new int[]{x, y});

            // 사과를 먹지 않은 경우 꼬리 제거
            if (board[x][y] == 0) {
                int[] tail = snake.poll();
                board[tail[0]][tail[1]] = 0; // 꼬리 제거
            }

            // 뱀이 현재 시간에 방향을 바꿀지 확인
            if (directionChange.containsKey(time)) {
                char dir = directionChange.get(time);
                if (dir == 'L') {
                    direction = (direction + 3) % 4; // 왼쪽으로 90도 회전
                } else if (dir == 'D') {
                    direction = (direction + 1) % 4; // 오른쪽으로 90도 회전
                }
            }

            // 뱀의 위치 표시
            board[x][y] = -1;
        }

        System.out.println(time);
    }
}
