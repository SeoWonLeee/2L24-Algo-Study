package HayanLee.그래프이론.기출문제.Q41_여행계획;

import java.util.*;

public class TravelPlan {
    static int N;
    static int M;
    static int[] P; //부모
    static int[][] Plan;

    static int[] hanulPlan;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        scanner.nextLine(); //버퍼 비우기

        P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            P[i] = i;
        }

        Plan = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                Plan[i][j] = scanner.nextInt();
                if (Plan[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int[] hanulPlan = new int[M];
        for (int i = 0; i < M; i++) {
            hanulPlan[i] = scanner.nextInt();
        }

        int root = find(hanulPlan[0]);
        boolean isPossible = true;
        for (int i = 1; i < M; i++) {
            if (find(hanulPlan[i]) != root) {
                isPossible = false;
                break;
            }
        }

        if(isPossible){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static int find(int x) {
        if (P[x] == x) {
            return x;
        }
        return P[x] = find(P[x]);
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            P[b] = a;
        }
        else P[a] = b;
    }
}
