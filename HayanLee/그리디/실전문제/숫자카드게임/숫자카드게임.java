package HayanLee.그리디.실전문제.숫자카드게임;

import java.util.*;
public class 숫자카드게임 {
    
    //처음 카드 선택 시 가장 높은 숫자의 카드 뽑기(뽑을 수 있는 숫자는 각 행의 가장 낮은 숫자)
    //즉, 각 행의 가장 작은 숫자를 먼저 뽑고, 그 작은 수들중에서는 가장 큰 수 출력
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); //행의 개수
        int M = sc.nextInt(); //열의 개수

        int[][] arr = new int[N][M]; // 배열
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        /*
        //1. 행 정렬(작은 수부터 정렬됨) 이용
        for(int i=0; i<N; i++){
            Arrays.sort(arr[i]);
        }

        //각 행의 가장 작은 수들 중에서 가장 큰 수
        int Max = 0;

        //각 행의 최대 값 구하기
        for(int i=0; i <N; i++){
            if(arr[i][0] > Max){ //각 행의 맨 앞에 있는 값과 max 비교 후 최대값 출력
                Max = arr[i][0];
            }
        }*/

        //2. 각 행의 최솟값을 직접 찾기
        int[] Min = new int[N];
        for(int i=0; i<N; i++){
            Min[i] = arr[i][0];
            for(int j=0; j<M; j++){
                if(arr[i][j] < Min[i]){
                    Min[i] = arr[i][j];
                }
            }
        }

        int Max = 0;
        for(int i=0; i<N; i++){
            if(Min[i] > Max){
                Max = Min[i];
            }
        }
        System.out.println(Max);
    }
}
