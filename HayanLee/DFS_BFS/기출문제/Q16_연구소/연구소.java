package HayanLee.DFS_BFS.기출문제.Q16_연구소;

//오후 3시 53분 ~

/*
알고리즘
0. 전역 변수 선언(N, M, dx, dy, result)
1. N과 M 입력받기
2. 버퍼 비우기
3. 배열 입력받기(String)
4. DFS 실행
   - 안전 영역 수를 세는 메서드
   - 조합으로 벽의 위치를 뽑는 메서드
 */
import java.util.*;
public class 연구소 {

    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int result = 0;
    static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        combination(0,0);
        System.out.println(result);
    }

    //DFS
    public static void dfs(int[][] vi, int x, int y){
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(vi[i][j] == 2) dfs(vi, i, j);
            }
        }

        for(int i=0; i<N; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >=0 && nx < N && ny < M){
                if(vi[nx][ny] == 0){
                    vi[nx][ny] = 2;
                    dfs(vi, nx, ny);
                }
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(vi[i][j] == 0){
                    count++;
                }
            }
        }
        //return count;
    }

    public static void combination(int x, int y) {
        if(x == 3) {
            int[][] vi = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    vi[i][j] = vi[i][j];
                }
            }
            result = Math.max(result, count);
            return;
        }

        for(int i = x; i < N * M; i++) {
            int nx = i / M;
            int ny = i % M;
            if(arr[nx][ny] == 0) {
                arr[nx][ny] = 1;
                combination(x + 1, i + 1);
                arr[nx][ny] = 0;
            }
        }
    }


}
