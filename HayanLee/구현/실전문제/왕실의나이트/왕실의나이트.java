package HayanLee.구현.실전문제.왕실의나이트;

//오후 9시 46분 시작 ~ 10시 17분

import java.util.*;
public class 왕실의나이트 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //1. 열과 행 입력받기
        String arr = sc.nextLine();

        /*
        2. 나이트의 이동 가능한 방향 설정

        나이트 이동은 L자 형태로만 가능(밖으로 이탈 불가)
            - 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
            - 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
         */


        //나이트가 임의의 칸에 있을 경우를 생각하면, 그 사각형을 둘러싸고 있는 8개의 방향이 존재. -> 즉, 8개의 경우가 있다.

        boolean[][] map = new boolean[8][8];
        int[][] nights = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};

        //시작 좌표
        int row = 0;
        int col = 0;

        int result = 0;

        for(int i=0; i<8; i++){
            int nextRow = row + nights[i][0];
            int nextCol = col + nights[i][1];

            //3. 위치 이동이 가능한 경우 이동(카운트++)
            if(nextRow >= 1 && nextRow <=8 && nextCol >= 1 && nextRow <=8){
                result ++;
            } else{
                break;
            }
        }
        System.out.println(result);
    }
}