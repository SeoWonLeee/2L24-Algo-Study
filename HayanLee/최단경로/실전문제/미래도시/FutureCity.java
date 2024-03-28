package HayanLee.최단경로.실전문제.미래도시;

/*
[알고리즘]
1. N, M, X, K 입력받기
2. 2차원 배열 입력받기(TD)
3. 배열 초기화하기
3. 플로이드 워셜 알고리즘 구현하기(N의 범위가 100 이하로 매우 한정적이기 때문)
 */

import java.util.*;

public class FutureCity {
    public static final int INF = (int) 1e9;
    static int N;
    static int M;
    static int X;
    static int K;

    static int[][] TD;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        TD = new int[N+1][N+1];
        for(int i=0; i<N; i++){
            Arrays.fill(TD[i], INF);
            TD[i][i] = 0;
        }

        //++ 각 간선들의 정보를 받아서, 그 값으로 초기화하기
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            TD[a][b] = 1;
            TD[b][a] = 1;
        }

        X = sc.nextInt();
        K = sc.nextInt();

        // 플로이드 워셜 알고리즘 구현
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    TD[a][b] = Math.min(TD[a][b], TD[a][k] + TD[k][b]);
                }
            }
        }

        // 결과 출력
        int path = TD[1][K] + TD[K][X];
        if (path < INF) {
            System.out.println(path);
        } else {
            System.out.println("-1"); // 경로가 없는 경우
        }
    }
}
