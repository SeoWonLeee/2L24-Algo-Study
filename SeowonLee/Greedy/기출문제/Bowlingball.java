package Greedy;

import java.util.*;

public class Bowlingball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] weightCounts = new int[M + 1]; // 각 무게 별 공의 개수 배열

        for (int i = 0; i < N; i++) {
            int weight = scanner.nextInt();
            weightCounts[weight]++;
        }

        int totalCount = 0; // 두 사랑이 볼링공을 고르는 경우의 수

        for (int i = 1; i <= M; i++) {
            N -= weightCounts[i]; // 현재 무게의 공을 제외한 나머지 공의 개수

            // 두 번째 사람이 선택할 수 있는 공의 개수를 현재 무게의 공을 제외한 나머지 공의 개수와 곱하여 더함
            totalCount += weightCounts[i] * N;
        }

        System.out.println(totalCount);
    }
}
