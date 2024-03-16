package DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

public class AvoidSurveillance {
    static int n;
    static char[][] board;
    static ArrayList<int[]> teachers;
    static ArrayList<int[]> spaces;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean found = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();

        board = new char[n][n];
        teachers = new ArrayList<>();
        spaces = new ArrayList<>();

        // 보드의 상태 입력
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'T') { // 선생님이 있는 경우
                    teachers.add(new int[]{i, j}); // 선생님의 위치 추가
                } else if (board[i][j] == 'X') { // 빈 공간인 경우
                    spaces.add(new int[]{i, j}); // 빈 공간의 위치 추가
                }
            }
        }

        dfs(0, 0); // 장애물을 설치하고 감시를 피할 수 있는지 확인

        if (found) { // 감시를 피할 수 있는 경우
            System.out.println("YES");
        } else { // 감시를 피할 수 없는 경우
            System.out.println("NO");
        }
    }

    // 장애물 설치 및 탐색
    static void dfs(int index, int count) {
        if (count == 3) { // 장애물을 3개 설치했을 경우
            if (!detect()) { // 감시를 피할 수 있는지 확인
                found = true; // 피할 수 있다면 정답을 찾음
            }
            return;
        }

        // 모든 빈 공간에 대해 장애물 설치 시도
        for (int i = index; i < spaces.size(); i++) {
            int[] space = spaces.get(i);
            int x = space[0];
            int y = space[1];

            board[x][y] = 'O'; // 장애물 설치
            dfs(i + 1, count + 1); // 다음 장애물 설치 시도
            board[x][y] = 'X'; // 장애물 제거
        }
    }

    // 감시를 피할 수 있는지 확인
    static boolean detect() {
        for (int[] teacher : teachers) {
            int x = teacher[0];
            int y = teacher[1];
            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 'O') {
                        break; // 범위를 벗어나거나 장애물을 만나면 종료
                    }
                    if (board[nx][ny] == 'S') {
                        return false; // 학생 발견
                    }
                }
            }
        }
        return true; // 학생을 발견하지 못함
    }
}
