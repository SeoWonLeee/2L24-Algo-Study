package HayanLee.이진탐색.실전문제.떡볶이떡만들기;

//오후 5시 50분 ~ 6시 3분
/*
[알고리즘]
1. N 입력받기
2. M 입력받기
3. 배열 입력받기
4. 이진탐색 진행하기
5. 별도 메서드 - 이진탐색 구현
 */

import java.util.*;
public class MakeTteck {

    static int N;
    static int M;
    static int[] arr;

    static int target;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = (int) 1e9;
        int result = binarySearch(arr, target, 0, N - 1);

        System.out.println(result);


    }


    public static int binarySearch(int[] arrOne, int target, int start, int end){
        while (start <= end){
            int middle = (start + end) / 2;
            if(arr[middle] == target){
                return middle;
            }
            if(arr[middle] > target){
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
