package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class LargeNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 배열의 크기
        int M = scanner.nextInt(); // 총 더하는 횟수
        int K = scanner.nextInt(); // 연속해서 더할 수 있는 최대 횟수

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        // 배열을 내림차순으로 정렬
        Arrays.sort(array);
        int firstMax = array[N - 1]; // 가장 큰 수
        int secondMax = array[N - 2]; // 두 번째로 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        int count = (M / (K + 1)) * K + (M % (K + 1));

        int result = count * firstMax + (M - count) * secondMax;

        System.out.println(result);
    }
}
