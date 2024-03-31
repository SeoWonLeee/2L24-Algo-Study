package HayanLee.그래프이론.실전문제.A3_커리큘럼;

import java.util.*;

public class Curriculum {

    static int V;
    public static int[] InDegree; //진입차수
    static ArrayList<ArrayList<Integer>> D = new ArrayList<ArrayList<Integer>>();
    static int[] LectureTime;

    static int[] Result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        InDegree = new int[501];
        LectureTime = new int[501];

        V = sc.nextInt();

        for (int i = 0; i <= V; i++) {
            D.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= V; i++) {
            int x = sc.nextInt();
            LectureTime[i] = x;
            while (true) {
                x = sc.nextInt();
                if (x == -1) {
                    break;
                }
                InDegree[i] ++;
                D.get(x).add(i);
            }
        }

        TopologicalSort();
    }

    // 위상 정렬
    public static void TopologicalSort() {

        Result = new int[501];

        for (int i = 1; i <= V; i++) {
            Result[i] = LectureTime[i];
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= V; i++) {
            if (InDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : D.get(now)) {
                Result[next] = Math.max(Result[next], Result[now] + LectureTime[next]);
                if (--InDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            System.out.println(Result[i]);
        }
    }
}