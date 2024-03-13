package HayanLee.DFS_BFS.실전문제.미로탈출;

//오후 3시 26분 ~ 4시 5분

/*
[알고리즘]
0. 전역변수 선언하기(N, M, arr, dx, dy, queue)
1. N과 M 입력받기
2. 버퍼 비우기
3. 문자열 입력받기(String)
4. BFS 계산하기(queue로 구현)
  - 큐 초기화 : Queur LinkendList
  - 큐가 비어있을 때까지 bfs 반복(하나의 좌표 당 상,하,좌,우 네방향 이동하며 확인)
  - 종료 조건 : 공간 밖, 벽
  - 정상 삽입 : 현재 위치에서 1 더한 값을 해당 위치에 저장하기
  - return : n-1, m-1까지 모두 순회 후 저장된 값
 */
import java.util.*;
public class 미로탈출 {

    //0. 전역변수 선언하기(N, M, arr, dx, dy, queue)
    static int N;
    static int M;
    static int[][] arr;

    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

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
                arr[i][j] = map.charAt(j) - '0';
            }
        }

        // 4. BFS 계산하기 및 결과 출력
        System.out.println(bfs(0,0));

    }

    /*4. BFS 계산하기(dequeue로 구현)
  - 상,하,좌,우 방문
  - 종료 조건 : 공간 밖, 벽*/
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

                //공간 밖
                if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                    continue;
                }
                //벽
                if(arr[nx][ny] == 0){
                    continue;
                }

                //정상 삽입
                if(arr[nx][ny] == 1){
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return arr[N-1][M-1];
    }
}
