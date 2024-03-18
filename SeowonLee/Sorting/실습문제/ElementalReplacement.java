package Sorting;

import java.util.*;

public class ElementalReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] A = new int[n];
        Integer[] B = new Integer[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }

        // 배열 A는 오름차순 정렬, 배열 B는 내림차순 정렬
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        // 최대 K번의 바꿔치기 연산 수행
        for (int i = 0; i < k; i++) {
            if (A[i] < B[i]) {
                int temp = A[i];
                A[i] = B[i];
                B[i] = temp;
            } else {
                break;
            }
        }

        int sum = 0;
        for (int num : A) {
            sum += num;
        }

        System.out.println(sum);
    }
}
