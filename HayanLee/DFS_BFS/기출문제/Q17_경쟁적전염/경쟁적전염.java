package HayanLee.DFS_BFS.기출문제.Q17_경쟁적전염;

//오후 4시 53분 ~오후 5시 13분
/*
알고리즘
0. 전역변수 선언(N, K, arr, dx, dy, result)
1. N과 K 입력받기
2. 배열 입력받기
3. 바이러스 입력 정보 정렬해 큐에 넣기
3. BFS 진행
   - 큐에서 바이러스 정보를 꺼내어 해당 위치에서 상하좌우로 전파 가능한 경우를 탐색하고, 전파된 바이러스 정보를 큐에 추가
   - 큐가 빌 때까지 반복
4. 목표 시간에 도달하면 해당 위치의 바이러스 번호 출력
 */
import java.util.*;

public class 경쟁적전염 {
    static int N;
    static int K;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N][N];
        List<Virus> viruses = new ArrayList<>(); // 바이러스 정보 저장을 위한 리스트

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] != 0) {
                    // 바이러스의 종류와 위치, 시간 정보 저장
                    viruses.add(new Virus(arr[i][j], i, j, 0));
                }
            }
        }

        Collections.sort(viruses); // 바이러스를 번호순으로 정렬
        int targetTime = sc.nextInt(); // 목표 시간 입력
        int targetX = sc.nextInt() - 1; // 목표 위치 입력 (0-based index로 변환)
        int targetY = sc.nextInt() - 1;

        bfs(viruses, targetTime, targetX, targetY);
    }

    public static void bfs(List<Virus> viruses, int targetTime, int targetX, int targetY) {
        Queue<Virus> queue = new LinkedList<>(viruses);

        while(!queue.isEmpty()){
            Virus current = queue.poll();
            int x = current.x;
            int y = current.y;
            int time = current.time;

            if(time == targetTime) {
                // 목표 시간 도달 시 종료
                System.out.println(arr[targetX][targetY]);
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                    continue;
                }

                if(arr[nx][ny] == 0){
                    arr[nx][ny] = current.type; // 해당 위치에 바이러스 전파
                    queue.offer(new Virus(current.type, nx, ny, time + 1));
                }
            }
        }
    }

    // Virus 클래스 정의 (바이러스 정보를 저장하기 위한 클래스)
    static class Virus implements Comparable<Virus> {
        int type;
        int x;
        int y;
        int time;

        public Virus(int type, int x, int y, int time) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.time = time;
        }

        // 바이러스 번호로 정렬하기 위한 compareTo 메서드 구현
        @Override
        public int compareTo(Virus o) {
            return Integer.compare(this.type, o.type);
        }
    }
}