package DynamicProgramming;

import java.util.Scanner;

public class IntegerTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[][] triangle = new int[N][N];

        // 삼각형의 숫자
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = scanner.nextInt();
            }
        }

        int[][] dp = new int[N][N];

        // 첫 번째 줄
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = triangle[N - 1][i];
        }

        // 바닥부터 꼭대기까지 올라가면서 최대 합 계산
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }

        System.out.println(dp[0][0]);
    }
}
