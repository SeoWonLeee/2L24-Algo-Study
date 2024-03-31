package HayanLee.그래프이론.실전문제.A2_도시분할계획;

import java.util.*;

class Edge implements Comparable<Edge> {

    private int A;
    private int B;
    private int distance;

    public Edge(int distance, int A, int B) {
        this.A = A;
        this.B = B;
        this.distance = distance;
    }
    public int getA() {
        return this.A;
    }
    public int getB() {
        return this.B;
    }
    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class CityDiv {

    static int V;
    static int E;
    public static int[] P;
    static ArrayList<Edge> edge = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        P = new int[100001];
        V = sc.nextInt();
        E = sc.nextInt();

        for (int i = 1; i <= V; i++) {
            P[i] = i;
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edge.add(new Edge(cost, a, b));
        }

        Collections.sort(edge);
        int last = 0;

        for (Edge e : edge) {
            int cost = e.getDistance();
            int a = e.getA();
            int b = e.getB();
            if (find(a) != find(b)) {
                union(a, b);
                result += cost;
                last = cost;
            }
        }

        int answer = result - last;
        System.out.println(answer);
    }

    public static int find(int X) {
        if (X == P[X]) {
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