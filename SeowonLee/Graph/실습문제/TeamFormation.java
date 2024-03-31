package Graph;

import java.util.Scanner;

public class TeamFormation {
    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int operation = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (operation == 0) {
                union(a, b); // 팀 합치기
            } else {
                if (find(a) == find(b)) { // 같은 팀 여부 확인
                    sb.append("YES").append("\n"); // 같은 팀에 속해 있으면
                } else {
                    sb.append("NO").append("\n"); // 같은 팀에 속해 있지 않으면
                }
            }
        }

        System.out.print(sb.toString());
    }

    // 두 학생이 속한 팀 합치기
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a; // b가 속한 팀을 a가 속한 팀에 합치기
        } else {
            parent[a] = b; // a가 속한 팀을 b가 속한 팀에 합치기
        }
    }

    // 학생이 속한 팀 찾기
    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
