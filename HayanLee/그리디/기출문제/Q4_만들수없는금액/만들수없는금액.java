package HayanLee.그리디.기출문제.Q4_만들수없는금액;

import java.util.Arrays;
import java.util.Scanner;
//오후 3시 20분 시작 ~ 4시 25분 종료
public class 만들수없는금액 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //1. N과 그 배열(arr) 입력받기
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        //2. 배열 정렬하기
        Arrays.sort(arr);

        //3. 만들 수 없는 금액을 찾은 경우 종료하기

        int result = 1;
        for(int i=0; i<N; i++) {
            if (result < arr[i]) {
                break;
            }
            result += arr[i];
        }
        System.out.println(result);
    }
}