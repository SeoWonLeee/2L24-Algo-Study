package HayanLee.최단경로.기출문제.Q40_숨바꼭질;

import java.util.*;

class Node implements Comparable<Node> {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
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

public class HideSeek {

    static final int INF = (int) 1e9;
    static int N;
    static int M;

    static int startNode = 1;
    static ArrayList<ArrayList<Node>> NodeList;

    static int[] D = new int[20001];

    static ArrayList<Integer> Result = new ArrayList<Integer>();
    static String Answer;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NodeList = new ArrayList<ArrayList<Node>>();

        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i <= N; i++) {
            NodeList.add(new ArrayList<Node>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            NodeList.get(a).add(new Node(b, 1));
            NodeList.get(b).add(new Node(a, 1));
        }

        dijkstra(startNode);

        int NowMaxIndex = 0;
        int NowMaxSave = 0;

        for (int i = 1; i <= N; i++) {
            if (NowMaxSave == D[i]) {
                Result.add(i);

            } else {
                NowMaxIndex = i;
                NowMaxSave = D[i];
                Result.clear();
                Result.add(NowMaxIndex);
            }
        }

        Answer = NowMaxIndex + " " + NowMaxSave + " " + Result.size();
        System.out.println(Answer);
    }

    public static int dijkstra(int start) {
        Arrays.fill(D, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        D[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int nodeDistance = node.getDistance();
            int Now = node.getIndex();

            if (D[Now] < nodeDistance) {
                continue;
            }

            for (Node adjNode : NodeList.get(Now)) {
                int distanceToAdjNode = D[Now] + adjNode.getDistance();

                if (distanceToAdjNode < D[adjNode.getIndex()]) {
                    D[adjNode.getIndex()] = distanceToAdjNode;
                    pq.offer(new Node(adjNode.getIndex(), distanceToAdjNode));
                }
            }
        }
        int NowMaxSave = 0;
        for (int i = 1; i <= N; i++) {
            NowMaxSave = Math.max(NowMaxSave, D[i]);
        }
        return NowMaxSave;
    }
}
