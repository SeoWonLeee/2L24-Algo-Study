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

public class MarsExploration {

    //상하좌우 초기값 설정
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static final int INF = (int) 1e9;
    static int[][] TD;
    static int[][] SD;
    static int T;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();

            TD = new int [125][125];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    TD[j][k] = sc.nextInt();
                }
            }

            SD = new int [125][125];
            
            for (int j = 0; j < N; j++) {
                Arrays.fill(SD[j], INF);
            }

            int x = 0;
            int y = 0;
            
            //우선순위 큐로 구현
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, TD[x][y]));
            SD[x][y] = TD[x][y];

            while(!pq.isEmpty()) {
                Node node = pq.poll();
                int distance = node.getDistance();
                x = node.getX();
                y = node.getY();
                if (TD[x][y] < distance) {
                    continue;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    int cost = distance + TD[nx][ny];

                    if (cost < SD[nx][ny]) {
                        SD[nx][ny] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                    //맵 범위 바깥
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }


                }
            }
            int result = SD[N-1][N-1];
            System.out.println(result);
        }
    }
}
