package DynamicProgramming;

import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            int[][] gold = new int[N][M];

            // 금의 양
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    gold[i][j] = scanner.nextInt();
                }
            }

            int[][] dp = new int[N][M];

            // DP 테이블의 각 칸에 최대로 캘 수 있는 금의 양
            for (int i = 0; i < N; i++) {
                dp[i][0] = gold[i][0];
            }

            for (int j = 1; j < M; j++) {
                for (int i = 0; i < N; i++) {
                    int leftUp, leftDown, left;
                    leftUp = left = leftDown = 0;

                    // 대각선 위로 이동하는 경우
                    if (i - 1 >= 0) {
                        leftUp = dp[i - 1][j - 1];
                    }
                    // 왼쪽으로 이동하는 경우
                    left = dp[i][j - 1];
                    // 대각선 아래로 이동하는 경우
                    if (i + 1 < N) {
                        leftDown = dp[i + 1][j - 1];
                    }

                    // 현재 위치까지의 최대 금의 양은 왼쪽 위, 왼쪽, 왼쪽 아래에서 가장 많이 캘 수 있는 금의 양 + 현재 위치의 금의 양
                    dp[i][j] = gold[i][j] + Math.max(Math.max(leftUp, left), leftDown);
                }
            }

            // 마지막 열의 각 행에서 캘 수 있는 최대 금의 양 중 최댓값
            int maxGold = 0;
            for (int i = 0; i < N; i++) {
                maxGold = Math.max(maxGold, dp[i][M - 1]);
            }

            result.append(maxGold).append("\n");
        }

        System.out.println(result);
    }
}
