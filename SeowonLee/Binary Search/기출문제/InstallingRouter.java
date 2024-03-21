package Binary_Search;

import java.util.*;

public class InstallingRouter {

    // 공유기 사이의 최대 거리
    public static int maxDistanceBetweenRouters(int[] houses, int C) {
        Arrays.sort(houses);
        int left = 1;
        int right = houses[houses.length - 1] - houses[0];
        int result = 0;

        // 이진 탐색
        while (left <= right) {
            int mid = left + (right - left) / 2; // 중간값
            int installed = 1;
            int prevHouse = houses[0];

            for (int i = 1; i < houses.length; i++) {
                int distance = houses[i] - prevHouse;
                if (distance >= mid) { // 공유기를 설치할 수 있는 경우
                    installed++;
                    prevHouse = houses[i];
                }
            }

            // 설치된 공유기의 개수가 주어진 공유기 개수보다 크거나 같으면 더 넓은 범위
            if (installed >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int C = scanner.nextInt();

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = scanner.nextInt();
        }

        int result = maxDistanceBetweenRouters(houses, C);
        System.out.println(result);
    }
}
