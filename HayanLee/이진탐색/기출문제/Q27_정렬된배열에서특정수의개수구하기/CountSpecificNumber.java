package HayanLee.이진탐색.기출문제.Q27_정렬된배열에서특정수의개수구하기;

import java.util.*;

public class CountSpecificNumber {
    static int N;
    static int X;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        X = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int count = countByRange(arr, X, X);

        if (count == 0) System.out.println(-1);
        else System.out.println(count);
    }

    public static int Lower(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int Upper(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int countByRange(int[] arr, int left, int right) {
        int R = Upper(arr, right, 0, arr.length);
        int L = Lower(arr, left, 0, arr.length);
        return R - L;
    }
}
