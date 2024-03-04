package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class LargeNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 배열 입력
        System.out.print("배열을 입력하세요(공백 구분): ");
        String inputArray = scanner.nextLine();
        String[] arrayValues = inputArray.split(" ");

        int N = arrayValues.length;

        // 배열 변환 및 정렬
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(arrayValues[i]);
        }

        Arrays.sort(arr);

        // M값 입력
        System.out.print("M : ");
        int M = scanner.nextInt();

        // K값 입력
        int K;
        do {
            System.out.print("K : ");
            K = scanner.nextInt();
            if (K > M) {
                System.out.print("K는 M보다 작거나 같아야 합니다. 다시 입력하세요. ");
            }
        } while (K > M);

        // 가장 큰 수와 두 번째로 큰 수
        int firstMax = arr[N - 1];
        int secondMax = arr[N - 2];

        // 결과 출력
        int count = (M / (K + 1)) * K + (M % (K + 1));

        int result = count * firstMax + (M - count) * secondMax;

        System.out.println("결과 : " + result);
    }
}
