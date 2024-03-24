package DynamicProgramming;

import java.util.Scanner;

public class MakeItOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();

        int[] dp = new int[X + 1];

        // Bottom-up 방식
        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);

            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);

            if (i % 5 == 0)
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
        }

        System.out.println(dp[X]);
    }
}
