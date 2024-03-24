package HayanLee.다이나믹프로그래밍.실전문제.개미전사;

// 10시 58분 ~ 11시 12분

/*
[알고리즘]
1. N 입력받기
2. 배열 입력받기
3. 배열 오름차순 정렬하기
4. 가장 큰 값 2개의 합을 구하기
 */

import java.util.*;

public class AntWarrior {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int sum = arr[N - 1] + arr[N - 2];

        System.out.println(sum);

    }
}
