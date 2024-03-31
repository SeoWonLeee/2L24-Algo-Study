package Graph;

import java.util.*;

public class Curriculum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];
        int[] time = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            time[i] = sc.nextInt();
            while (true) {
                int prerequisite = sc.nextInt();
                if (prerequisite == -1) break;
                graph[prerequisite].add(i); // 선수 강의 -> 해당 강의
                indegree[i]++; // 해당 강의의 선수 강의 수 증가
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[n + 1];

        // 처음 시작할 때 선수 강의가 없는 강의
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                result[i] = time[i];
            }
        }

        // 위상 정렬
        while (!q.isEmpty()) {
            int now = q.poll();

            // 현재 강의를 듣고 나서 수강할 수 있는 강의들의 최소 수강 시간 갱신
            for (int next : graph[now]) {
                result[next] = Math.max(result[next], result[now] + time[next]);
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }
}
