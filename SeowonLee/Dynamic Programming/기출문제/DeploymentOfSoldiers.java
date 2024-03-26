package DynamicProgramming;

import java.util.Scanner;

public class DeploymentOfSoldiers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] soldiers = new int[N];
        for (int i = 0; i < N; i++) {
            soldiers[i] = scanner.nextInt();
        }

        int result = maxSurvivingSoldiers(N, soldiers);

        System.out.println(result);
    }

    // 최대로 남을 수 있는 병사 수
    private static int maxSurvivingSoldiers(int N, int[] soldiers) {
        int[] dp = new int[N];
        int maxSurviving = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 모든 병사를 자기 자신만으로 구성했을 때의 길이
            for (int j = 0; j < i; j++) {
                if (soldiers[i] < soldiers[j]) { // 현재 병사의 전투력이 이전 병사의 전투력보다 작으면
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 최대 증가 부분 수열의 길이
                }
            }
            maxSurviving = Math.max(maxSurviving, dp[i]); // 최대로 남을 수 있는 병사 수
        }

        return N - maxSurviving; // 열외시켜야 하는 병사 수
    }
}
