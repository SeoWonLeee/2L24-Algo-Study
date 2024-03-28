package Shortest_Path;

import java.util.*;

public class MessageDelivery {

    static final int INF = Integer.MAX_VALUE; // 무한

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 도시의 개수, 통로의 개수, 메시지를 보내고자 하는 도시
        int N = sc.nextInt();
        int M = sc.nextInt();
        int C = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 통로 정보
        for (int i = 0; i < M; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int Z = sc.nextInt();
            graph.get(X).add(new Node(Y, Z));
        }

        // 최단 거리
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);

        // 다익스트라 알고리즘
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(C, 0));
        distance[C] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;
            int dist = node.distance;

            if (distance[now] < dist) continue;

            for (Node nextNode : graph.get(now)) {
                int cost = dist + nextNode.distance;

                if (cost < distance[nextNode.index]) {
                    distance[nextNode.index] = cost;
                    pq.offer(new Node(nextNode.index, cost));
                }
            }
        }

        int count = 0;
        int maxDistance = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] != INF && i != C) {
                count++;
                maxDistance = Math.max(maxDistance, distance[i]);
            }
        }
        System.out.println(count + " " + maxDistance);
    }
}
