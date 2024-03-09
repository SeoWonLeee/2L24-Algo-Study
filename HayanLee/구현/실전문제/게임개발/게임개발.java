package HayanLee.구현.실전문제.게임개발;

//오후 10시 33분 ~ 11시 5분

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

        Scanner sc = new Scanner(System.in);

        //1. N과 M 입력받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        //수정 : 버퍼 비우기
        sc.nextLine();

        //2. 캐릭터 초기 상태 입력받기(x, y, 방향)
        //String initState = sc.nextLine();
        int chX = sc.nextInt();
        int chY = sc.nextInt();
        int chDir = sc.nextInt();

        //버퍼 비우기
        sc.nextLine();

        //3. N개의 줄을 입력받기
        int[][] arr = new int [N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        //4. 맵 정보 설정(방향 정의) -> 시계 반대 방향인 북, 동, 남, 서 순서
        int[][] visited = new int[N][M];// ++ 방문 완료된 위치 저장!
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0 ,-1};



        int count = 1; //++ 시작한 경우 이미 그 위치는 방문된 위치이기 때문!
        int turn = 0;


        //5.캐릭터 완쪽 방향이 가보지 않은 칸이라면
        while(true){
            // - 캐릭터를 왼쪽으로 회전하기
            chDir -= 1;
            if(chDir == -1){
                chDir = 3;
            }

            int nextX = chX + dx[chDir];
            int nextY = chY + dy[chDir];

            // - 회전 후 가보지 않은 칸이 있다면 이동 O
            if(arr[nextX][nextY] == 0 && visited[nextX][nextY] == 0){ // ++ && visited[nextX][nextY] == 0 조건 추가!
                visited[nextX][nextY] = 1;
                chX = nextX;
                chY = nextY;
                count++;
                turn = 0;
            } else {  // - 회전 후 가보지 않은 칸이 없다면 이동 X
                turn += 1;
            }

            /*
            조건 추가
            - 네 방향 모두 갈 수 없는 경우
                - 뒤로 갈 수 있다면 이동!
             */
            if(turn == 4){
                nextX = chX - dx[chDir];
                nextY = chY + dy[chDir];

                if(arr[nextX][nextY] == 0){
                    chX = nextX;
                    chY = nextY;
                }else{
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
