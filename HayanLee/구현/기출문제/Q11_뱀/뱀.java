package HayanLee.구현.기출문제.Q11_뱀;

//오후 5시 30분 ~ 6시 14분
import java.util.*;

public class 뱀 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*
        - 입력
          - N 입력받기
          - K 입력받기
          - K개의 행렬 입력받기
          - L 입력받기
          - L개의 행렬 입력받기
         */
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] kArr = new int[N][N];
        for(int i=0; i<K; i++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            kArr[row - 1][col - 1] = 1;//초기 사과 위치 1
        }

        int L = sc.nextInt();
        int[][] lArr = new int[N][L];
        for(int i=0; i<L; i++){
            lArr[i][0] = sc.nextInt();
            char c = sc.next().charAt(0);
            lArr[i][1] = (c == 'L') ? -1 : 1; //왼쪽회전 or 오른쪽 회전
        }

        int dir = 0; //처음 이동
        int headX = 0; //뱀 머리
        int headY = 0; //뱀 머리
        int tail = 0; //뱀 꼬리
        int time = 0; //시간

        int[] dx = {0, 1, 0, -1}; //상, 하, 좌, 우 순
        int[] dy = {1, 0, -1, 0};

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{headX, headY});

        while(true){
            time++;

            headX += dx[dir];
            headY += dy[dir];

            //벽에 부딪히는 경우 게임 종료
            if( headX<0 || headX >= N || headY<0 || headY >= N){
               break;
            }

            /*
            - 이동한 칸에 사과 O -> 꼬리 그대로 두기
            - 이동한 칸에 사과 X -> 꼬리 칸 비우기
            */
            if(kArr[headX][headY] == 1){
                int[] tailSpace = snake.pollLast();
                kArr[tailSpace[0]][tailSpace[1]] = 1;
            }

            kArr[headX][headY] = -1; //뱀이 위치한 칸
            snake.addFirst(new int[]{headX, headY}); //뱀 머리 위치 업데이트

            int i = 0;
            if(i < L && time == lArr[i][0]){
                dir = turn(dir, lArr[i][1]);//방향 전환
                i++;
            }
        }
        System.out.println(time);
    }

    public static int turn(int dir, int rotate){
        dir += rotate;
        if (dir < 0) dir += 4;
        if (dir >= 4) dir -= 4;
        return dir;
    }
}
