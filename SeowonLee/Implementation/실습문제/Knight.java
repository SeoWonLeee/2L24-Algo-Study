package Greedy;

import java.util.Scanner;

public class Knight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String position = scanner.nextLine().trim();

        int column = position.charAt(0) - 'a' + 1;
        int row = position.charAt(1) - '0';

        System.out.println(countPossibleMoves(column, row));
    }

    // 가능한 이동 경로의 수
    public static int countPossibleMoves(int x, int y) {
        int[][] directions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
        int count = 0;

        // 가능한 이동 경로
        for (int i = 0; i < directions.length; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            // 이동한 위치가 체스판 내에 있는지 확인
            if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
                count++;
            }
        }

        return count;
    }
}