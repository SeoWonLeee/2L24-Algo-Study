package HayanLee.최단경로.실전문제.전보;

/*
[알고리즘]
1. N, M, C 입력받기
2. 배열 입력받기(d)
3. 배열 초기화하기
4. 개선된 다익스트라 알고리즘 구현하기
 */
import java.util.*;

class Telegram implements Comparable<Telegram> {
    int idx;
    int d;

    public Telegram(int idx, int d) {
        this.idx = idx;
        this.d = d;
    }

    @Override
    public int compareTo(Telegram other) {
        return Integer.compare(this.d, other.d);
    }
}

public class Telegraphy {
    static final int INF = (int) 1e9;
    static int N;
    static int M;
    static int C;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        C = scanner.nextInt();

        ArrayList<ArrayList<Telegram>> dList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            dList.add(new ArrayList<>());
        }

        //++ 간선 정보 추가 및 초기화하기
        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            dList.get(x).add(new Telegram(y, z));
        }

        int[] d = new int[N + 1];
        Arrays.fill(d, INF);

        // 4. 개선된 다익스트라 알고리즘 구현하기
        PriorityQueue<Telegram> pq = new PriorityQueue<>();
        pq.offer(new Telegram(C, 0));
        d[C] = 0;

        while (!pq.isEmpty()) {
            Telegram T = pq.poll();
            int now = T.idx;
            int dist = T.d;

            if (d[now] < dist) continue;

            for (Telegram nextT : dList.get(now)) {
                int cost = dist + nextT.d;

                if (cost < d[nextT.idx]) {
                    d[nextT.idx] = cost;
                    pq.offer(new Telegram(nextT.idx, cost));
                }
            }
        }

        // 결과 출력
        int count = 0;
        int max= 0;
        for (int i = 1; i <= N; i++) {
            if (d[i] != INF && i != C) {
                count++;
                max = Math.max(max, d[i]);
            }
        }

        System.out.println(count + " " + max);
    }
}

