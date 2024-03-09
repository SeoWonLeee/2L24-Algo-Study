package HayanLee.구현.실전문제.게임개발;

//오후 10시 33분 ~

/* 입력
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1
*/


import java.util.*;
public class 게임개발 {
    public static void main(String[] args){
        /*
        - N과 M 입력받기(맵)
        - 캐릭터 초기 상태 입력받기(x, y, 방향)
        - N개의 줄을 입력받기

        - 맵 정보 설정(방향 정의)

        - 캐릭터 완쪽 방향이 가보지 않은 칸이라면
            - 캐릭터를 왼쪽으로 회전하기
            - 회전 후 가보지 않은 칸이 있다면 이동 O
            - 회전 후 가보지 않은 칸이 없다면 이동 X
         */

        Scanner sc = new Scanner(System.in);

        //1. N과 M 입력받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        //2. 캐릭터 초기 상태 입력받기(x, y, 방향)
        String initState = sc.nextLine();

        //3. N개의 줄을 입력받기
        int[][] arr = new int [N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        //4. 맵 정보 설정(방향 정의) -> 시계 반대 방향인 북, 동, 남, 서 순서
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0 ,-1};

        int chX = 0;
        int chY = 0;

        int count = 0;
        int turn = 0;


        //5.캐릭터 완쪽 방향이 가보지 않은 칸이라면
        while(true){

            // - 캐릭터를 왼쪽으로 회전하기
            int chTurnLeft = 0;
            chTurnLeft -= 1;
            if(chTurnLeft == -1){
                chTurnLeft = 3;
            }

            int nextX = dx[chTurnLeft];
            int nextY = dy[chTurnLeft];

            // - 회전 후 가보지 않은 칸이 있다면 이동 O

            if(arr[nextX][nextY] == 0){
                arr[nextX][nextY] = 1;
                chX = nextX;
                chY = nextY;

                count++;
                turn = 0;

                continue;
            } else {  // - 회전 후 가보지 않은 칸이 없다면 이동 X
                turn += 1;
                break;
            }
        }
        System.out.println(count);
    }
}