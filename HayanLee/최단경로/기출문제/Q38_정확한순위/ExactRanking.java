package HayanLee.최단경로.기출문제.Q38_정확한순위;

import java.util.*;

public class ExactRanking {

    static final int INF = (int) 1e9;
    static int N;
    static int M;
    public static int[][] TD = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            Arrays.fill(TD[i], INF);
        }

        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                if (a == b) TD[a][b] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            TD[a][b] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    TD[a][b] = Math.min(TD[a][b], TD[a][k] + TD[k][b]);
                }
            }
        }

        int result = 0;
        int count  = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (TD[i][j] != INF || TD[j][i] != INF) {
                    count += 1;
                }
            }
            if (count == N) {
                result ++;
            }
        }
        System.out.println(result);
    }
}