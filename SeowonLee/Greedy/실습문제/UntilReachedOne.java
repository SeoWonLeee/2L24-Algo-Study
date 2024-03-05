package Greedy;

import java.util.Scanner;

public class UntilReachedOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N과 K 입력
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int count = 0;

        // N이 K로 나누어 떨어지는 경우
        while (N != 1) {
            if (N % K == 0) {
                N /= K;
            } else {
                N -= 1;
            }

            count++;
        }

        // 결과 출력
        System.out.println(count);
    }
}
