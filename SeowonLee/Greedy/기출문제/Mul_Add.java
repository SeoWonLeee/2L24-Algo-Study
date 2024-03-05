package Greedy;

import java.util.Scanner;

public class Mul_Add {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.nextLine();

        // 첫 번째 숫자로 초기화
        long result = S.charAt(0) - '0';

        // 문자열 순서대로 연산
        for (int i = 1; i < S.length(); i++) {
            int num = S.charAt(i) - '0'; // 현재 숫자

            // 현재 숫자와 이전 결과 중에서 큰 값 선택
            if (num <= 1 || result <= 1) {
                result += num;
            } else {
                result *= num;
            }
        }

        System.out.println(result);
    }
}

