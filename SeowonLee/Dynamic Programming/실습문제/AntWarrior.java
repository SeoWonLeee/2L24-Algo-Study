package DynamicProgramming;

import java.util.Scanner;

public class AntWarrior {

    // 최대 음식 저장량
    public static int maxFoodStorage(int[] foodStorage) {
        int n = foodStorage.length;
        if (n == 0) return 0;
        if (n == 1) return foodStorage[0];

        int[] dp = new int[n];
        dp[0] = foodStorage[0];
        dp[1] = Math.max(foodStorage[0], foodStorage[1]);

        // 최대 저장량 계산
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + foodStorage[i]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] foodStorage = new int[n];

         for (int i = 0; i < n; i++) {
            foodStorage[i] = scanner.nextInt();
        }

         System.out.println(maxFoodStorage(foodStorage));
    }
}
