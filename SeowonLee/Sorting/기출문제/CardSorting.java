package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class CardSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextInt();
        }

        Arrays.sort(cards);

        // 최소 비교 횟수
        long totalComparisons = 0;
        for (int i = 1; i < N; i++) {
            // 묶음 크기의 합
            long sum = (long) cards[i - 1] + cards[i];
            totalComparisons += sum;
            cards[i] = (int) sum; 
            // 새로운 묶음 크기 정렬
            int j = i;
            while (j > 0 && cards[j] < cards[j - 1]) {
                // Swap
                int temp = cards[j];
                cards[j] = cards[j - 1];
                cards[j - 1] = temp;
                j--;
            }
        }

        System.out.println(totalComparisons);

        scanner.close();
    }
}
