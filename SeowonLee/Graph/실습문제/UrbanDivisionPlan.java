package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UrbanDivisionPlan {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int node1;
        int node2;
        int cost;

        public Edge(int node1, int node2, int cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<Edge> edges = new ArrayList<>();
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);

        int totalCost = 0;
        int maxCost = 0;

        // 최소 신장 트리
        for (Edge edge : edges) {
            int node1 = edge.node1;
            int node2 = edge.node2;
            int cost = edge.cost;

            // 사이클이 발생하지 않는 경우에만 선택
            if (find(node1) != find(node2)) {
                union(node1, node2);
                totalCost += cost;
                maxCost = Math.max(maxCost, cost); // 가장 비싼 간선 비용 갱신
            }
        }

        System.out.println(totalCost - maxCost);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // 두 집이 속한 집합 합치기
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
