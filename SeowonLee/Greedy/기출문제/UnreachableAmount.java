package Greedy;

import java.util.*;

public class UnreachableAmount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        Arrays.sort(coins); // 동전 오름차순으로 정렬

        int target = 1; // 만들어야 하는 최소 금액
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            // 현재 동전으로 만들 수 있는 금액이 target보다 작다면 target
            if (coin > target) {
                break;
            }
            target += coin;
        }

        System.out.println(target);
    }
}
