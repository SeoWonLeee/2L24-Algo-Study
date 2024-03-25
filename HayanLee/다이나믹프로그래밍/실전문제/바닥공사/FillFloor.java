package HayanLee.다이나믹프로그래밍.실전문제.바닥공사;

// 오전 9시 15분 ~ 9시 25분
// 재풀이 : ~ 9시 29분
/*
[알고리즘]
1. N 입력받기
2. 다이나믹 프로그래밍 진행하기
   - BottomUp방식으로
 */

import java.util.*;

public class FillFloor {

    static int[] d = new int[1001];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        d[1] = 1;
        d[2] = 3;
        for(int i=3; i<=N; i++){
            d[i] = (d[i-1] + 2*d[i-2]);
        }
        System.out.println(d[N] % 796796);
    }
}
