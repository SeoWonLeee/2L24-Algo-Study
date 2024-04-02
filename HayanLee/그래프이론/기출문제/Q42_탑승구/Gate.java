package HayanLee.그래프이론.기출문제.Q42_탑승구;

import java.util.*;

public class Gate {

    static int[] Parent;
    static int G;
    static int P;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        G = scanner.nextInt();
        P = scanner.nextInt();

        Parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            Parent[i] = i;
        }

        int result = 0;

        for (int i = 0; i < P; i++) {
            int gate = scanner.nextInt();

            int dockingGate = find(gate);
            if (dockingGate == 0) {
                break;
            }

            union(dockingGate, dockingGate - 1);
            result++;
        }

        System.out.println(result);

        scanner.close();
    }

    static int find(int x) {
        if (Parent[x] == x) {
            return x;
        }
        return Parent[x] = find(Parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            Parent[a] = b;
        }
    }
}