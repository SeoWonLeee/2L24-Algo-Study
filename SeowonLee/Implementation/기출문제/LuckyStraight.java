package Implementation;

import java.util.Scanner;

public class LuckyStraight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        // 각 자릿수의 합을 저장할 변수
        int leftSum = 0, rightSum = 0;

        // 입력받은 숫자의 자릿수를 계산
        int digitsCount = 0;
        int temp = N;
        while (temp > 0) {
            digitsCount++;
            temp /= 10;
        }

        // 왼쪽 부분과 오른쪽 부분의 합 계산
        for (int i = 0; i < digitsCount; i++) {
            if (i < digitsCount / 2) {
                leftSum += N % 10;
            } else {
                rightSum += N % 10;
            }
            N /= 10;
        }

        if (leftSum == rightSum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
