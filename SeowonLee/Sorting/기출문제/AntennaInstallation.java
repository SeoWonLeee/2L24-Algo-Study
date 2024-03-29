package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class AntennaInstallation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = scanner.nextInt();
        }

        Arrays.sort(houses);

        // 안테나를 설치할 위치 선택
        int antennaPosition;
        if (N % 2 == 0) { // 짝수 개의 집이라면 중간 두 집 중 왼쪽에 설치
            antennaPosition = houses[N / 2 - 1];
        } else { // 홀수 개의 집이라면 중간 집에 설치
            antennaPosition = houses[N / 2];
        }

        System.out.println(antennaPosition);
    }
}
