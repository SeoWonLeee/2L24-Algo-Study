package Graph;

import java.util.*;

public class FinalRanking {
    static int[] indegree;
    static ArrayList<Integer>[] graph;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            n = scanner.nextInt();
            indegree = new int[n + 1];
            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            int[] lastYearRank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                lastYearRank[i] = scanner.nextInt();
            }

            // 작년 순위를 바탕으로 그래프를 생성하고 진입 차수를 계산
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    graph[lastYearRank[i]].add(lastYearRank[j]);
                    indegree[lastYearRank[j]]++;
                }
            }

            int m = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                if (graph[a].contains(b)) {
                    graph[a].remove(Integer.valueOf(b));
                    graph[b].add(a);
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    graph[b].remove(Integer.valueOf(a));
                    graph[a].add(b);
                    indegree[b]++;
                    indegree[a]--;
                }
            }

            ArrayList<Integer> result = topologicalSort();

            if (result.size() == 0) { // 불가능한 경우
                sb.append("IMPOSSIBLE").append("\n");
            } else if (result.size() < n) { // 결과가 여러 개인 경우
                sb.append("?").append("\n");
            } else { // 가능한 경우
                for (int i = 0; i < n; i++) {
                    sb.append(result.get(i)).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    // 위상 정렬
    static ArrayList<Integer> topologicalSort() {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            if (queue.size() > 1) return new ArrayList<>();
            int current = queue.poll();
            result.add(current);

            for (int next : graph[current]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return result;
    }
}
