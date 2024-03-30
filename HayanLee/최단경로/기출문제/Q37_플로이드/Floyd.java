package HayanLee.최단경로.기출문제.Q37_플로이드;

import java.util.*;

public class Floyd {

    static final int INF = (int) 1e9;
    static int n;
    static int m;

    public static int[][] TD;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        TD = new int[101][101];

        for (int i = 0; i < 101; i++) {
            Arrays.fill(TD[i], INF);
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) TD[a][b] = 0;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    TD[a][b] = Math.min(TD[a][b], TD[a][k] + TD[k][b]);
                }
            }
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (TD[a][b] == INF) {
                    System.out.print(0 + " ");
                }
                else {
                    int result = TD[a][b];
                    System.out.print(result + " ");
                }
            }
            System.out.println();
        }
    }
}
