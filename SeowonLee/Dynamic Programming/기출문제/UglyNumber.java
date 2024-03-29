package DynamicProgramming;

import java.util.Scanner;

public class UglyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] uglyNumbers = new int[N];
        uglyNumbers[0] = 1;

        int index2 = 0, index3 = 0, index5 = 0;

        // 다음 못생긴 수를 찾기
        for (int i = 1; i < N; i++) {
            int nextUgly = Math.min(uglyNumbers[index2] * 2, Math.min(uglyNumbers[index3] * 3, uglyNumbers[index5] * 5));
            uglyNumbers[i] = nextUgly;

            // 중복된 수 방지
            if (nextUgly == uglyNumbers[index2] * 2) index2++;
            if (nextUgly == uglyNumbers[index3] * 3) index3++;
            if (nextUgly == uglyNumbers[index5] * 5) index5++;
        }

        System.out.println(uglyNumbers[N - 1]);
    }
}
