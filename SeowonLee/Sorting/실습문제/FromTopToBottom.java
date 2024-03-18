package Sorting;

import java.util.Scanner;

public class FromTopToBottom {
    public static final int MAX_VALUE = 100001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[MAX_VALUE];

        // 계수 정렬
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            array[x]++;
        }

        // 큰 수부터 작은 수 순서
        for (int i = MAX_VALUE - 1; i >= 0; i--) {
            for (int j = 0; j < array[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
