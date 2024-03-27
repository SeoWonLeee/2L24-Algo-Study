package HayanLee.다이나믹프로그래밍.기출문제.Q34_병사배치하기;

//오후 1시 30분 ~ 1시 50분
/*
[알고리즘]
1. N 입력받기
2. 병사 번호, 전투력 배열 입력받기
3. d로 테이블 초기화하기
4. 내림차순 정렬하기
5. 바텀업으로 구현
    - Math.max로 최대 병사의 수 구현
    - 전체 - 열외 병사 수로 출력
 */

import java.util.*;
public class SoldierDeploy {

    static int N;
    //static int[] arr;
    static int[] d;
    static int maxSol;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        d = new int[N];
        Arrays.fill(d, 1);

        for(int i = 1; i<N; i++){
            for(int j = 0; j< i; j++) {
                if(arr[j] > arr[i]){
                    d[i] = Math.max(d[i], d[j]+1);
                }
            }
        }

        for(int i=0; i<N; i++){
            maxSol = Math.max(maxSol, d[i]);
        }
        System.out.println(N - maxSol);

    }
}
