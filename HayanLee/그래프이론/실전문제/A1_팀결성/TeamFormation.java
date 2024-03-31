package HayanLee.그래프이론.실전문제.A1_팀결성;

import java.util.*;

public class TeamFormation {

    static int N;
    static int M;
    static int[] P;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        P = new int[100001];
        N = sc.nextInt();
        M = sc.nextInt();

        System.out.println();

        for (int i = 1; i <= N; i++) {
            P[i] = i;
        }

        for (int i = 0; i <M; i++) {
            //0: 팀을 결성하는 연산
            //1: 두 학생이 같은 팀에 속해 있는지 확인하는 연산
            int OT = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (OT == 0) {
                union(a, b);
            }

            else if (OT == 1) {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static int find(int X) {
        if (X == P[X]){
            return X;
        }
        return P[X] = find(P[X]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) P[b] = a;
        else P[a] = b;
    }
}
