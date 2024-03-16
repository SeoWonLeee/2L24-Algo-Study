package HayanLee.DFS_BFS.기출문제.Q20_감시피하기;

//오후 4시 33분 ~ 5시 25분
import java.util.*;
public class 감시피하기1 {

    static int N;
    static int[][] arr;

    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    static boolean result;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //입력받기
        N = sc.nextInt();

        sc.nextLine();

        arr = new int[N][N];
        for(int i=0; i<N; i++){
            String map = sc.nextLine();
            for(int j=0; j<N; j++){
                arr[i][j] = map.charAt(0) - '0';
            }
        }

        //bfs 계산
        result = bfs();


        //결과 출력
        if(result == true){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    //BFS 계산하는 메서드
    public static boolean bfs(){
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //공간 밖으로 나갈 경우
                if(nx < 0 || ny < 0 || nx >=N || ny >=N){
                    continue;
                }

                //장애물 설치
                arr[nx][ny] = 2;
                queue.offer(new int[]{nx,ny});
            }
        }

        //빈공간 확인하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
