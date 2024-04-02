package HayanLee.그래프이론.기출문제.Q44_행성터널;

import java.util.*;

class Tunnel implements Comparable<Tunnel> {
    int PlanetA;
    int PlanetB;
    int distance;

    public Tunnel(int PlanetA, int PlanetB, int distance) {
        this.PlanetA = PlanetA;
        this.PlanetB = PlanetB;
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getPlanetA() {
        return this.PlanetA;
    }

    public int getPlanetB() {
        return this.PlanetB;
    }

    @Override
    public int compareTo(Tunnel other) {
        return this.distance - other.distance;
    }
}

public class PlanetTunnel {
    static int[] P;
    static int N;
    static Point[] points;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = i;
        }

        points = new Point[N];
        for (int i = 0; i < N; i++) { //x, y, z 좌표 각각
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            points[i] = new Point(x, y, z, i);
        }

        Tunnel[] tunnels = new Tunnel[N * (N - 1) / 2];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int cost = distance(points[i], points[j]);
                tunnels[index++] = new Tunnel(i, j, cost);
            }
        }

        int totalCost = kruskal(tunnels);
        System.out.println(totalCost);
    }

    static int distance(Point a, Point b) {
        return Math.min(Math.min(Math.abs(a.x - b.x), Math.abs(a.y - b.y)), Math.abs(a.z - b.z));
    }

    static int kruskal(Tunnel[] tunnels) {
        Arrays.sort(tunnels);

        int totalCost = 0;
        for (Tunnel tunnel : tunnels) {
            if (find(tunnel.PlanetA) != find(tunnel.PlanetB)) {
                union(tunnel.PlanetA, tunnel.PlanetB);
                totalCost += tunnel.distance;
            }
        }

        return totalCost;
    }

    static int find(int x) {
        if (P[x] == x) {
            return x;
        }
        return P[x] = find(P[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            P[b] = a;
        }
    }

    static class Point {
        int x, y, z, index;

        public Point(int x, int y, int z, int index) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.index = index;
        }
    }
}

