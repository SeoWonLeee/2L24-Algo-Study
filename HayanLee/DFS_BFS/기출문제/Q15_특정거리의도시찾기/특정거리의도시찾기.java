package HayanLee.DFS_BFS.기출문제.Q15_특정거리의도시찾기;

//오후 1시 50분 ~ 2시 14분
/*
알고리즘
- N, M, K, X 입력받기
- 버퍼 비우기
- 배열 입력받기(String)
- BFS 구현
 */
import java.util.*;
public class 특정거리의도시찾기 {
    static int N;
    static int M;
    static int K;
    static int X;
    static int [][]arr;
    static boolean[] visited;

    static ArrayList<Integer> map = new ArrayList<>();

    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();

        sc.nextLine();

        arr = new int[N + 1][M + 1];
        visited = new boolean[N + 1];

        /*for(int i=0; i<N; i++){
            String map = sc.nextLine();
            Arrays.fill(arr[i], -1);
            for(int j=0; j<M; j++){
                //arr[i][j] = map.charAt(j) - '0';
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[a-1][b-1] = 1;
            }
        }*/


        //도로 정보 입력
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }
        bfs(X);

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for(int i=0; i<result.size(); i++) {
                System.out.println(result.get(i));
            }
        }
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;

        int depth = 0;
        while (!queue.isEmpty() && depth <= K) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (depth == K) {
                    result.add(current);
                }
                for (int j = 1; j <= N; j++) {
                    if (arr[current][j] == 1 && !visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }
            depth++;
        }
    }
}
