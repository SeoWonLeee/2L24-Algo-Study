package DynamicProgramming;

import java.util.Scanner;

public class Resignation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            T[i] = scanner.nextInt();
            P[i] = scanner.nextInt();
        }

        // Bottom-Up 다이나믹 프로그래밍
        for (int i = N; i > 0; i--) {
            int nextDay = i + T[i]; // 다음 상담 날짜
            if (nextDay <= N + 1) {
                // 다음 상담 날짜가 퇴사 전이라면
                dp[i] = Math.max(P[i] + dp[nextDay], dp[i + 1]); // 현재 상담을 하는 경우 vs 하지 않는 경우 중 큰 값 선택
            } else {
                // 다음 상담 날짜가 퇴사 후라면
                dp[i] = dp[i + 1]; // 현재 상담을 할 수 없으므로 다음날로 넘어감
            }
        }

        System.out.println(dp[1]);
    }
}
