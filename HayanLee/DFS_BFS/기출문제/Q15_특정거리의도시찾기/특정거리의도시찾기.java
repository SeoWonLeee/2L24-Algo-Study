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

    static ArrayList<Integer> map = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();

        sc.nextLine();

        arr = new int[N][M];
        for(int i=0; i<N; i++){
            String map = sc.nextLine();
            for(int j=0; j<M; j++){
                arr[i][j] = map.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0,0));
    }

    public static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            x = current[0];
            y = current[1];
            for(int i=0; i<4; i++){
                if(x < 0 || y < 0 || x >= N || y >= M){
                    return -1;
                }

                if(arr[x][y] == 1){
                    arr[x][y] = arr[x][y] + 1;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return arr[N-1][M-1];
    }
}
