package HayanLee.다이나믹프로그래밍.기출문제.Q35_못생긴수;

import java.util.*;

public class UglyNumber {

    static int N;
    static int[] U;

    static int nTwo = 2;
    static int nThree = 3;
    static int nFive = 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        U = new int[1000];

        int Two = 0;
        int Three = 0;
        int Five = 0;



        U[0] = 1;
        for (int i = 1; i < N; i++) {
            U[i] = Math.min(nTwo, Math.min(nThree, nFive));

            if (U[i] == nTwo) {
                Two ++;
                nTwo = U[Two] * 2;
            }
            if (U[i] == nThree) {
                Three ++;
                nThree = U[Three] * 3;
            }
            if (U[i] == nFive) {
                Five ++;
                nFive = U[Five] * 5;
            }
        }

        int result = U[N-1];
        System.out.println(result);
    }
}
