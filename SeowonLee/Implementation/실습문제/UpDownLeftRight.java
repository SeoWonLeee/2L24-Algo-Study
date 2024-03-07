package Greedy;

import java.util.Scanner;

public class UpDownLeftRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         int n = scanner.nextInt();
        scanner.nextLine();

         String plans = scanner.nextLine();

         int x = 1, y = 1;

         for (int i = 0; i < plans.length(); i++) {
            char move = plans.charAt(i);

             if (move == 'L' && y > 1) {
                y--;
            } else if (move == 'R' && y < n) {
                y++;
            } else if (move == 'U' && x > 1) {
                x--;
            } else if (move == 'D' && x < n) {
                x++;
            }
        }

         System.out.println(x + " " + y);
    }
}