package Greedy;

import java.util.Scanner;
import java.util.Arrays;

public class NumCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 숫자 카드 배열 입력
        System.out.println("배열 입력");
        String input = scanner.nextLine();
        String[] parts = input.split(" / "); // 행과 열로 분리

        // 행과 열의 개수 파악
        String[] row1 = parts[0].split(" ");
        int n = Integer.parseInt(row1[0]); // 행의 개수
        int m = Integer.parseInt(row1[1]); // 열의 개수

        // 배열 생성
        int[][] cards = new int[n][m];

        // 입력된 배열 저장
        for (int i = 0; i < n; i++) {
            String[] nums = parts[i + 1].split(" ");
            int len = Math.min(nums.length, m); // 열의 개수와 입력된 행의 길이 중 작은 값 선택
            for (int j = 0; j < len; j++) {
                cards[i][j] = Integer.parseInt(nums[j]);
            }
        }

        // 입력 받은 배열 출력
        System.out.println("배열 :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(cards[i][j] + " ");
            }
            System.out.println();
        }

        // 각 행의 최솟값을 저장할 배열 생성
        int[] minInRows = new int[n];

        // 각 행의 최솟값 계산하여 배열에 저장
        for (int i = 0; i < n; i++) {
            Arrays.sort(cards[i]); // 행 정렬
            minInRows[i] = cards[i][0]; // 최솟값 저장
        }

        // 최솟값 중 가장 큰 값 찾기
        int maxOfMin = minInRows[0];
        for (int i = 1; i < n; i++) {
            if (minInRows[i] > maxOfMin) {
                maxOfMin = minInRows[i];
            }
        }

        // 결과 출력
        System.out.println("결과 : " + maxOfMin);

        scanner.close();
    }
}
