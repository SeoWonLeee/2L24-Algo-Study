package HayanLee.DFS_BFS.실전문제.미로탈출;

//오후 3시 26분 ~ 4시 5분

/*
[알고리즘]
0. 전역변수 선언하기(N, M, arr, dx, dy, visited, queue)
1. N과 M 입력받기
2. 버퍼 비우기
3. 문자열 입력받기(String)
4. BFS 계산하기(queue로 구현)
  - 상,하,좌,우 방문
  - 종료 조건 : 공간 밖, 벽
 */
import java.util.*;
public class 미로탈출 {

    //0. 전역변수 선언하기(N, M, arr, dx, dy, visited, queue)
    static int N;
    static int M;
    static int[][] arr;

    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[] visited = new boolean[N];

    static ArrayList<Integer> map = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //1. N과 M 입력받기
        N = sc.nextInt();
        M = sc.nextInt();

        //2. 버퍼 비우기
        sc.nextLine();

        //3. 문자열 입력받기(String)
        arr = new int[N][M];
        for(int i=0; i<N; i++){
            String map = sc.nextLine();
            for(int j=0; j<M; j++){
                arr[i][j] = map.charAt(0);
            }
        }

        // 4. BFS 계산하기 및 결과 출력
        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(bfs(i,j)) {
                    result++;
                }
            }
        }
        System.out.println(result);

    }

    /*4. BFS 계산하기(dequeue로 구현)
  - 상,하,좌,우 방문
  - 종료 조건 : 공간 밖, 벽*/
    public static boolean bfs(int x, int y){
        Queue<String> queue = new LinkedList<>();
        queue.offer(new String(x,y));

        while(!queue.isEmpty()){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    int nx = x + dx[i];
                    int ny = y + dx[j];

                    //공간 밖
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                        continue;
                    }
                    //벽
                    if(map[nx][ny] == 0){
                        continue;
                    }

                    //정상 삽입
                    if(map[nx][ny] == 1){
                        map[nx][ny] = map[x][y] + 1;
                        queue.offer(new String(nx, ny));
                    }
                }
            }
        }
        return map[N-1][M-1];
    }
}
