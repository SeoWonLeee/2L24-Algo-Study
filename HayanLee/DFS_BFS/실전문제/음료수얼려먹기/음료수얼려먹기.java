package HayanLee.DFS_BFS.실전문제.음료수얼려먹기;

//오후 1시 17분 ~ 1시 57분

/*
[알고리즘]
1. N과 M 입력받기
2. 배열 입력받기
3. 상,하,좌,우 위치 선언하기
4. DFS를 사용해 방문한 지점 표시하기(방문하지 않은 개수가 정답)
   - 만약 0이면 -> 구멍이 뚫려 있는 것으로 간주
   - 그렇지 않다면(1) -> 칸막이로 간주
 */

import java.util.*;

public class 음료수얼려먹기 {

    static int N = 0;
    static int M = 0;
    static int[][] arr;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //1. N과 M 입력받기
        N = sc.nextInt();
        M = sc.nextInt();
        //**버퍼 삭제**
        sc.nextLine();

        //2. 배열 입력받기
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String count = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = count.charAt(j) - '0';
            }
        }


        int result = 0;

        //3. 상,하,좌,우 위치 선언하기
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(dfs(i,j)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    //4. DFS를 사용해 방문한 지점 표시하기(방문하지 않은 개수가 정답)
    //   - 만약 0이면 -> 구멍이 뚫려 있는 것으로 간주
    //   - 그렇지 않다면(1) -> 칸막이로 간주
    public static boolean dfs(int i, int j){
        if( i<= -1 || i>=N || j<=-1 || j>=M){//틀 밖으로 나갈 경우
            return false;
        }

        if(arr[i][j] == 0) {
            arr[i][j] = 1; //방문

            dfs(i + 1, j);
            dfs(i - 1, j);
            dfs(i, j + 1);
            dfs(i, j - 1);

            return true;
        }
        return false;
    }
}
