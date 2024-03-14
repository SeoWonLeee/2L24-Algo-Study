package HayanLee.DFS_BFS.기출문제.Q17_경쟁적전염;

//오후 4시 53분 ~
/*
알고리즘
0. 전역변수 선언(N, K, arr, dx, dy, result)
1. N과 K 입력받기
2. 배열 입력받기
3. BFS 진행
   - 바이러스가 존재하는 경우 -> 바이러스 종류, 시간, 위치(x,y) 넣기
   - sort 후 큐로 옮기기
 */
import java.util.*;
public class 경쟁적전염 {
    static int N;
    static int K;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N][K];
        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        bfs(0,0);
        Arrays.sort(arr);
        System.out.println(result);

    }

    public static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            x = current[0];
            y = current[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= K){
                    continue;
                }

                if(arr[nx][ny] == 0){
                    continue;
                }

                if(arr[nx][ny] == 0){
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return arr[N-1][K-1];
    }
}
