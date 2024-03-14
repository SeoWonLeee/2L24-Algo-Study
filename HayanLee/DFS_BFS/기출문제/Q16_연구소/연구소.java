package HayanLee.DFS_BFS.기출문제.Q16_연구소;

//오후 3시 53분 ~ 4시 45분

/*
0. 전역 변수 선언(N, M, arr, dx, dy, result)
1. N과 M 입력받기
2. 배열 입력받기
3. DFS 메서드로 로직 작성하기
4. 안전 영역 크기 구하는 메서드 작성하기
5. 벽을 세우는 모든 경우의 수 탐색하는 메서드 작성하기
   - 바이러스 퍼뜨리기
   - 안전 영역 크기 구하기
   - 조합으로 벽의 위치를 뽑는 메서드 작성하기
 */
import java.util.*;

public class 연구소 {
    static int N, M;
    static int[][] arr;
    static int result = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        combination(0);
        System.out.println(result);
    }

    // DFS
    public static void dfs(int[][] vi, int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(vi[nx][ny] == 0) {
                    vi[nx][ny] = 2;
                    dfs(vi, nx, ny);
                }
            }
        }
    }

    // 안전 영역 크기 구하기
    public static int getSafeArea(int[][] vi) {
        int safeArea = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(vi[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        return safeArea;
    }

    // 벽을 세우는 모든 경우의 수 탐색
    public static void combination(int count) {
        if(count == 3) { // 벽을 3개 세운 경우
            int[][] vi = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    vi[i][j] = arr[i][j];
                }
            }

            // 바이러스 퍼뜨리기
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(vi[i][j] == 2) {
                        dfs(vi, i, j);
                    }
                }
            }

            // 안전 영역 크기 구하기
            result = Math.max(result, getSafeArea(vi));
            return;
        }

        // 조합 탐색
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    combination(count + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }
}
