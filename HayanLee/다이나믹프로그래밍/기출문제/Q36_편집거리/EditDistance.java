package HayanLee.다이나믹프로그래밍.기출문제.Q36_편집거리;

import java.util.*;

public class EditDistance {

    static String A;
    static String B;
    static int[][] TD;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.next();
        B = sc.next();

        int result = Edit(A,B);
        System.out.println(result);
    }

    static int Edit(String A, String B) {

        int ALength = A.length();
        int BLength = B.length();

        TD = new int[ALength + 1][BLength + 1];
        for (int i = 1; i <= ALength; i++) {
            TD[i][0] = i;
        }
        for (int j = 1; j <= BLength; j++) {
            TD[0][j] = j;
        }

        for (int i = 1; i <= ALength; i++) {
            for (int j = 1; j <= BLength; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    TD[i][j] = TD[i - 1][j - 1];
                } else {
                    TD[i][j] = 1 + Math.min(TD[i][j - 1], Math.min(TD[i - 1][j], TD[i - 1][j - 1]));
                }
            }
        }
        return TD[ALength][BLength];
    }
}
