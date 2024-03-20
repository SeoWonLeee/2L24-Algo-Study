package Binary_Search;

import java.util.Arrays;
import java.util.Scanner;

public class ElementalReplacement {
    // 이진 탐색을 이용한 부품 확인
    public static boolean binarySearch(int[] parts, int target) {
        int left = 0;
        int right = parts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 중간값
            if (parts[mid] == target) // 찾는 부품이 중간 값과 일치하면
                return true; // 부품이 존재
            else if (parts[mid] < target) // 찾는 부품이 중간 값보다 크면
                left = mid + 1; // 중간 값의 오른쪽을 탐색
            else
                right = mid - 1; // 찾는 부품이 중간 값보다 작으면 중간 값의 왼쪽을 탐색
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 부품 수
        int n = scanner.nextInt();
        int[] parts = new int[n];

        for (int i = 0; i < n; i++) {
            parts[i] = scanner.nextInt();
        }
        Arrays.sort(parts);

        // 요청 부품 수
        int m = scanner.nextInt();
        int[] requests = new int[m];

        for (int i = 0; i < m; i++) {
            requests[i] = scanner.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            if (binarySearch(parts, requests[i])) {
                sb.append("yes ");
            } else {
                sb.append("no ");
            }
        }
        System.out.println(sb.toString());
    }
}
