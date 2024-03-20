package Binary_Search;

import java.util.Scanner;

public class Tteokbokki {
    public static int cutTteok(int[] tteok, int target) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        int result = 0;

        // 이진 탐색
        while (left <= right) {
            int mid = (left + right) / 2; // 현재 절단기의 높이
            long total = 0;

            // 떡을 자른 결과 총 길이
            for (int i = 0; i < tteok.length; i++) {
                if (tteok[i] > mid) {
                    total += tteok[i] - mid;
                }
            }

            // 총 길이가 요청한 떡의 길이와 일치하거나 그 이상인 경우
            if (total >= target) {
                result = mid;
                left = mid + 1; // 절단기의 높이를 더 높여서 더 많이 자르기
            } else {
                right = mid - 1; // 절단기의 높이를 낮춰서 총 길이를 늘리기
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] tteok = new int[N];
        for (int i = 0; i < N; i++) {
            tteok[i] = scanner.nextInt();
        }

        int maxHeight = cutTteok(tteok, M);

        System.out.println(maxHeight);
    }
}
