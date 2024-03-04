package HayanLee.그리디.실전문제.큰수의법칙;

import java.util.*;

//실전문제
public class 큰수의법칙 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        //첫째줄 입력
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc. nextInt();

        //둘째줄 입력
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        /*첫번째 풀이.md
        int count = 0; //연속으로 더하고 있는 횟수 카운트
        int sum = 0; //총합

        int Max = arr[N-1]; //첫번째로 큰 수
        int nextMax = arr[N-2]; //두번째로 큰 수(연속 더하기하다가 끼워넣을 숫자)

        // 연속으로 더할 수 있는 횟수 : 최대 K번 -> 가장 큰 수를 K번 더하고 + 두번째 큰수 1개를 끼워넣는 것을 반복
        for(int i=0; i < M; i++){
            
            //계속 카운트
            count++;

            //1. count/k의 나머지가 0이 아닐 경우 -> 즉, 연속으로 더할 수 있는 횟수에 아직 도달 전
           if(count % K != 0){
               sum += Max;
           }
            //2. count/k의 나머지가 0일 경우 -> 즉, 연속 가능 횟수에 도달한 상태
           if(count % K == 0){
               sum += nextMax;
           }
       }
        System.out.println(sum);
        */

        //두번째 풀이.md(답안)
        //반복되는 수열에 대한 파악 -> 반복되는 수열의 길이를 파악하기
        //ex) {6,6,6,5} -> 6,6,6,5가 반복됨 -> 수열의 길이는? 4 -> 이걸 일반화하면 K+1


        int Max = arr[N-1]; //첫번째로 큰 수
        int nextMax = arr[N-2]; //두번째로 큰 수(연속 더하기하다가 끼워넣을 숫자)

        int count = (M / (K+1) ) * K; //M을 (K+1)로 나누 몫이 수열이 반복되는 횟수가 됨. 여기에 K를 곱해주면 가장 큰 수가 등장하는 횟수가 됨.
        count += (M % (K+1));

        int result = 0;
        result += count * Max; // 6 6 6 5 6 6 6 5 -> 6은 총 6번
        result += (M - count) * nextMax; // 6 6 6 5 6 6 6 5 -> M=8,count=6 -> 즉, 5는 M-count =2번 등장

        System.out.println(result);

    }
}
