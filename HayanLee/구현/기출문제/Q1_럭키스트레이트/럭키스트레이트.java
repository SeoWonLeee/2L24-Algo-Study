package HayanLee.구현.기출문제.Q1_럭키스트레이트;

// 새벽 2시 2분 시작 ~ 2시 19분

import java.util.*;
public class 럭키스트레이트 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //1. N 입력받기
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        //2. N을 절반으로 자르기
        int mid = arr.length / 2;
        int[] first = Arrays.copyOfRange(arr, 0, mid);
        int[] end = Arrays.copyOfRange(arr, mid, arr.length);

        //3. 각 합 구하기
        int firstSum = Arrays.stream(first).sum();
        int endSum = Arrays.stream(end).sum();


        //4. 두 합 비교하기
        //  - 만약, 두 합이 일치한다면 LUCKY 출력
        //  - 두 합이 일치하지 않는다면 READY 출력
        if(firstSum == endSum){
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}