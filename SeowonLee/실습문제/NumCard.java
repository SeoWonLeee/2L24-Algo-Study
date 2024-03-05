package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class NumCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] array= new int[N][M];
        int[] minInRow = new int[N]; // 각 행의 가장 작은 수의 배열

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                array[i][j] = scanner.nextInt();
            }

            Arrays.sort(array[i]);
            minInRow[i] = array[i][0]; // 각 행의 가장 작은 수
        }

        // 최솟값 중 가장 큰 값
        int maxOfMin = minInRow[0];
        for(int i=1; i<N; i++) {
            if(minInRow[i] > maxOfMin) {
                maxOfMin = minInRow[i];
            }
        }

        System.out.println(maxOfMin);
    }
}
