package HayanLee.구현.기출문제.Q12_기둥과보설치;

//오후 7시 45분 ~
import java.util.*;

/*
- 입력받은 배열에서 [x,y,a,b] 형식으로 기둥과 보 설치or삭제하기
- 기둥을 설치
- 기둥을 삭제
- 보를 설치
- 보를 삭제
- 벽면을 벗어나지 않는다 + 바닥에 보를 설치하지 않는다.즉, (n,0)의 좌표에서는 보 설치 금지(시작점인 (1,0)은 제외)
*/


class Solution {
    public int[][] solution(int n, int[][] build_frame) {

        //1. 기둥과 보 정보 선언
        boolean[][] leng = new boolean[n+1][n+1]; //기둥
        boolean[][] wid = new boolean[n+1][n+1]; //보

        int count = 0; //설치할 때마다 추가하고, 삭제할 때마다 빼주기

        //2. [x,y,a,b] 형식 선언
        for(int i=0; i<build_frame.length; i++){
            int x = build_frame[i][0]; //점의 x좌표
            int y = build_frame[i][1]; //점의 y좌표
            int a = build_frame[i][2]; //a = 설치 또는 삭제할 구조물(0=기둥, 1=보)
            int b = build_frame[i][3]; //b = 구조물을 설치 or 삭제 결정(0=삭제, 1=삭제)
        }

        //3. 기둥 설치
        if(a == 0){
            if(b == 1){
                leng[x][y] = true;
                count++;
            }
        }
        //4. 기둥 삭제
        if(a == 0){
            if(b == 0)
                leng[x][y] = false;
            count--;
        }

        //5. 보 설치
        if(a == 1){
            if(b == 1)
                wid[x][y] = true;
            count--;
        }

        //6. 보 삭제
        if(a == 1){
            if(b == 0)
                wid[x][y] = false;
            count--;
        }


        //7. 벽면을 벗어나지 않는다 + 바닥에 보를 설치하지 않는다.즉, (n,0)의 좌표에서는 보 설치 금지(시작점인 (1,0)은 제외)
        if(y == 0){
            return true;
        }

        //8. 결과 리턴
        int[][] answer = new int[count][3];
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(leng[i][j]){
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 0;
                }
                if(wid[i][j]){
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 1;
                }
            }

        }
        return answer;
    }
}
