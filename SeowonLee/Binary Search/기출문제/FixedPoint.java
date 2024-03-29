package Binary_Search;

import java.util.Scanner;

public class FixedPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int fixedPoint = findFixedPoint(arr);

        System.out.println(fixedPoint);
    }

    // 고정점 찾기
    private static int findFixedPoint(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == mid) { // 고정점을 찾았을 경우
                return mid;
            } else if (arr[mid] < mid) { // 현재 인덱스의 값이 인덱스보다 작으면 오른쪽 탐색
                start = mid + 1;
            } else { // 현재 인덱스의 값이 인덱스보다 크면 왼쪽 탐색
                end = mid - 1;
            }
        }

        // 고정점이 없을 경우
        return -1;
    }
}
