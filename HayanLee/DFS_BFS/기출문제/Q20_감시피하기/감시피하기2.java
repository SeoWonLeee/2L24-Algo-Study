package HayanLee.DFS_BFS.기출문제.Q20_감시피하기;

import java.util.*;

public class 감시피하기2 {

    static int N;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받기
        N = sc.nextInt();
        sc.nextLine();

        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String map = sc.nextLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = map.charAt(j);
            }
        }

        // dfs 계산
        result = dfs(0);

        // 결과 출력
        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // DFS 계산하는 메서드
    public static boolean dfs(int count) {
        if (count == 3) { // 장애물을 3개 설치했으면 감시를 피할 수 있는지 확인
            return check();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'X') { // 빈 공간에만 장애물을 설치할 수 있음
                    arr[i][j] = 'O'; // 장애물 설치
                    if (dfs(count + 1)) return true; // 재귀 호출
                    arr[i][j] = 'X'; // 장애물 제거 (백트래킹)
                }
            }
        }

        return false;
    }

    // 감시를 피할 수 있는지 확인하는 메서드
    public static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'T') { // 각 선생님 위치에서
                    for (int k = 0; k < 4; k++) { // 4방향을 확인하여
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        while (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 내에서 반복
                            if (arr[nx][ny] == 'S') return true; // 학생이 발견되면 감시 피할 수 없음
                            if (arr[nx][ny] == 'O') return false; // 장애물이 있으면 더 이상 볼 수 없는 방향
                            nx += dx[k];
                            ny += dy[k];
                        }
                    }
                }
            }
        }
        return true; // 모든 선생님이 학생을 발견하지 못하면 감시 피할 수 있음
    }
}
