package DynamicProgramming;

import java.util.Scanner;

public class BuildingFloor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;

        // 바닥을 채우는 방법의 수를 계산
        for (int i = 3; i <= n; i++) {
            // 이전 층의 경우의 수에 현재 층의 높이가 1인 경우와 2인 경우 고려
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 796796;
        }

        int result = dp[n];
        System.out.println(result);
    }
}