package Greedy;

import java.util.Scanner;

public class FlipString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        scanner.close();

        int countZero = 0;
        int countOne = 0;

        // 첫 번째 원소에 대한 처리
        if (S.charAt(0) == '1') {
            countZero++;
        } else {
            countOne++;
        }

        // 두 번째 원소부터 마지막까지 탐색
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) != S.charAt(i + 1)) {
                // 현재 문자와 다음 문자가 다를 때
                if (S.charAt(i + 1) == '1') {
                    countZero++;
                } else {
                    countOne++;
                }
            }
        }

        System.out.println(Math.min(countZero, countOne));
    }
}





