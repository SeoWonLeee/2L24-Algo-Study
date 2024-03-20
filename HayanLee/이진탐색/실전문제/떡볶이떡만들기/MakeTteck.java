package HayanLee.이진탐색.실전문제.떡볶이떡만들기;

//오후 5시 50분 ~ 6시 3분
//재풀이 : ~ 6시 14분
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
        int end = Arrays.stream(arr).max().getAsInt(); // 최대 높이부터 시작
        int result = binarySearch(arr, M, start, end);

        System.out.println(result);


    }


    public static int binarySearch(int[] arrOne, int target, int start, int end){
        int result = 0;

        while (start <= end){
            int total = 0;
            int middle = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                if (arr[i] > middle) {
                    total += arr[i] - middle;
                }
            }
            if (total < target) {
                end = middle - 1;
            } else {
                result = middle;
                start = middle + 1;
            }
        }
        return result;
    }
}
