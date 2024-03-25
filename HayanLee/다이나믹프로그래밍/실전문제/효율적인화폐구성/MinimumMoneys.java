package HayanLee.다이나믹프로그래밍.실전문제.효율적인화폐구성;

//오전 9시 37분 ~ 9시 48분
//재풀이 : ~
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

        int[] d = new int[10001];

        d[0] = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                d[i] = Math.min(d[i], d[i - arr[j]] + 1);

                if (d[i] == 10001) {
                    System.out.println(-1);
                }
            }
        }
        System.out.println(d[N]);
    }

}
