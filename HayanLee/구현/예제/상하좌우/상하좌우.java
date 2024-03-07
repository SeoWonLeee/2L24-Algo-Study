package HayanLee.구현.예제.상하좌우;

import java.util.*;
public class 상하좌우 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //입력
        int N = sc.nextInt();
        sc.nextLine();

        String arr = sc.nextLine();
        /*char[] arr = new char[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.next().charAt(0);
        }*/

        //시작 좌표
        int x = 1;
        int y = 1;

        //이동방향 넣어주기(왼쪽, 오른쪽, 위, 아래 순)
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] move = {'L', 'R', 'U', 'D'};

        // 이동 좌표 구하기
        for (int i = 0; i < arr.length(); i++) {
            //char cMove = arr[i];
            char cMove = arr.charAt(i);

            //이동 방향에 따른 좌표 업데이트
            for(int j=0; j<4; j++){
                if(cMove == move[j]){
                    int nextX = x + dx[j];
                    int nextY = y + dy[j];

                    // 공간을 벗어나는 경우
                    if (nextX < 1 || nextY < 1 || nextX > N || nextY > N) {
                        continue;
                    }
                    x = nextX;
                    y = nextY;
                    break;
                }
            }
        }
        System.out.println(x + " " + y);
    }
}
