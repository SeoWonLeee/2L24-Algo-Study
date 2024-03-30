package HayanLee.다이나믹프로그래밍.기출문제.Q31_금광;

import java.util.*;

public class Gold {

    static int T;
    static int n;
    static int m;
    static int[][] arr;
    static int[][] TD;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        System.out.println();

        for (int tc = 0; tc < T; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();

            arr = new int[20][20];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            TD = new int[20][20];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    TD[i][j] = arr[i][j];
                }
            }

            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    int LUp;
                    int LDown;
                    int L;

                    if (i == 0) {
                        LUp = 0;
                    } else {
                        LUp = TD[i - 1][j - 1];
                    }

                    if (i == n - 1) {
                        LDown = 0;
                    } else {
                        LDown = TD[i + 1][j - 1];
                    }
                    L = TD[i][j - 1];
                    TD[i][j] = TD[i][j] + Math.max(LUp, Math.max(LDown, L));
                }
            }

            int result = 0; //결과값
            for (int i = 0; i < n; i++) {
                result = Math.max(result, TD[i][m - 1]);
            }
            System.out.println(result);
        }
    }
}
