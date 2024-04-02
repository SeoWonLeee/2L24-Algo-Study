package HayanLee.그래프이론.기출문제.Q43_어두운길;

import java.util.*;

class Edge implements Comparable<Edge> {
    private int A;
    private int B;
    private int distance;

    public Edge(int A, int B, int distance) {
        this.A = A;
        this.B = B;
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getA() {
        return this.A;
    }

    public int getB() {
        return this.B;
    }

    @Override
    public int compareTo(Edge other) {
        return this.distance - other.distance;
    }
}

public class DarkRoad {
    static int[] P;
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int total = 0;

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int distance = sc.nextInt();
            pq.add(new Edge(A, B, distance));
            total += distance;
        }

        int nowDistance = kruskal(pq);

        int result = total - nowDistance;
        System.out.println(result);
    }

    static int kruskal(PriorityQueue<Edge> pq) {
        int savedCost = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int rootA = find(edge.getA());
            int rootB = find(edge.getB());

            if (rootA != rootB) {
                union(rootA, rootB);
                savedCost += edge.getDistance();
            }
        }

        return savedCost;
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            P[y] = x;
        }
    }

    static int find(int x) {
        if (P[x] == x) {
            return x;
        }
        return P[x] = find(P[x]);
    }
}
