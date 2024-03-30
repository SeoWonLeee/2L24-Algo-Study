package HayanLee.이진탐색.기출문제.Q28_고정점찾기;

import java.util.*;

public class FindFixedPoint2 {

    static int N;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = binarySearch(arr, 0, N - 1);

        System.out.println(result);
    }

    public static int binarySearch(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == mid) {
            return mid;
        } else if (arr[mid] > mid) {
            return binarySearch(arr, start, mid - 1);
        } else {
            return binarySearch(arr, mid + 1, end);
        }
    }
}