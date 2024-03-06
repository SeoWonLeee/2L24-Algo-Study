package HayanLee.그리디.기출문제.만들수없는금액;

import java.util.*;
//오후 3시 20분 시작
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

        //3. 없는 수를 저장할 배열 만들어주기
        int[] none = new int[N];

        int result = 0;

        //4. 1 ~ N까지의 수 중에서 배열에 없는 수 골라내기
        for(int i=0; i<arr.length; i++) {
            if (arr[i] <= none[i]) {
                none[i] += arr[i];
            }
        }

        //5. 만약, 배열에 있는 숫자를 조합해 더한 값 != 없는 숫자라면 그게 result
        for(int i=0; i<N; i++){
            int sum = Arrays.stream(arr).sum();
            if(sum != none[i]){
                break;
            }
            result += arr[i];
        }
        System.out.println(result);
    }
}