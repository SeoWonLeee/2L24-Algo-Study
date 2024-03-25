package HayanLee.다이나믹프로그래밍.실전문제.효율적인화폐구성;

//오전 9시 37분 ~ 9시 48분
//재풀이 : ~ 오전 10시 12분
/*
[알고리즘]
1. N, M 입력받기
2. 배열 입력받기
3. 다이나믹 프로그래밍 구현하기(BottomUp)
 */

import java.util.*;

public class MinimumMoneys {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int[] d = new int[M+1];

        //이전 배열 저장과 초기화를 위해 작성
        Arrays.fill(d, 10001);

        d[0] = 0;
        for(int i=0; i<N; i++){
            for(int j=arr[i]; j<=M; j++) { //j를 arr[i]를 기준으로 범위 설정하기
                d[j] = Math.min(d[j], d[j - arr[i]] + 1);
            }
        }

        if (d[M] != 10001) { //결과 M원 출력하기
            System.out.println(d[M]);
        }
        if (d[M] == 10001) { //불가능할 경우 -1 출력하는 조건 추가
            System.out.println(-1);
        }
    }
}
