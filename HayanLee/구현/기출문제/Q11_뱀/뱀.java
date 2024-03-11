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

        /*
        - 이동한 칸에 사과 O -> 꼬리 그대로 두기
        - 이동한 칸에 사과 X -> 꼬리 칸 비우기
        */

        int dir = 0; //처음 이동
        int headX = 0; //뱀 머리
        int headY = 0; //뱀 머리
        int tail = 0; //뱀 꼬리
        int time = 0; //시간

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{headX, headY});

        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++) {
                if (kArr[i][j] !=0){
                    tail += 1;
                    x++;
                } else {
                    tail -= 1;
                }
            }
        }
        System.out.println(x);
    }

    public static int turn(int turn, char c){

    }
}
