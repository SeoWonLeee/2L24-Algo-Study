package HayanLee.최단경로.기출문제.Q39_화성탐사;

import java.util.*;

class Node implements Comparable<Node> {

    private int x;
    private int y;
    private int distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDistance() {
        return this.distance;
    }
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class MarsExploration2 {

    //상하좌우 초기값 설정
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static final int INF = (int) 1e9;
    static int[][] TD = new int[125][125];
    static int[][] SD = new int[125][125];
    static int T;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        System.out.println();

        for (int tc = 0; tc < T; tc++) {
            N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    TD[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < N; i++) {
                Arrays.fill(SD[i], INF);
            }

            int x = 0;
            int y = 0;

            //우선순위 큐로 구현
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, TD[x][y]));
            SD[x][y] = TD[x][y];

            while(!pq.isEmpty()) {
                Node node = pq.poll();
                int dist = node.getDistance();
                x = node.getX();
                y = node.getY();
                if (SD[x][y] < dist) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    //맵 범위 바깥
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }

                    int cost = dist + TD[nx][ny];
                    if (cost < SD[nx][ny]) {
                        SD[nx][ny] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                }
            }
            int result = SD[N-1][N-1];
            System.out.println(result);
        }
    }
}
