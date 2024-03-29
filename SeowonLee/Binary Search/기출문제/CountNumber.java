package Binary_Search;

import java.util.Scanner;

public class CountNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int x = scanner.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // 특정 수가 처음 등장하는 인덱스 찾기
        int firstIdx = findFirstIndex(arr, x);
        // 특정 수가 마지막으로 등장하는 인덱스 찾기
        int lastIdx = findLastIndex(arr, x);

        // 특정 수가 배열에 존재하지 않는 경우
        if (firstIdx == -1 || lastIdx == -1) {
            System.out.println(-1);
        } else { // 특정 수가 배열에 존재하는 경우
            int count = lastIdx - firstIdx + 1;
            System.out.println(count);
        }
    }

    // 이진 탐색 - 특정 수가 처음 등장하는 인덱스 찾기
    private static int findFirstIndex(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] >= target) {
                end = mid - 1;
                if (arr[mid] == target) {
                    result = mid;
                }
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    // 이진 탐색 - 특정 수가 마지막으로 등장하는 인덱스를 찾기
    private static int findLastIndex(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] <= target) {
                start = mid + 1;
                if (arr[mid] == target) {
                    result = mid;
                }
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
