package HayanLee.이진탐색.기출문제.Q29_공유기설치;

// 오후 3시 10분 ~ 3시 23분
/*
[알고리즘]
1. N과 C 입력받기
2. 배열 입력받기
3. 이진탐색을 위한 정렬하기
4. 이진탐색 진행하기
5. 별도 메서드 - 이진탐색 구현
 */

import java.util.*;
public class WiFiInstall {

    static int N;
    static int C;
    static int[] arr;

    static int gap;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        C = sc.nextInt();

        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int start = 1;
        int end = Arrays.stream(arr).max().getAsInt(); // 최대 높이부터 시작
        int result = binarySearch(arr, C, start, end);

        System.out.println(result);
    }

    public static int binarySearch(int[] arr, int gap, int start, int end){
        int result = 0;

        while (start <= end){
            int total = 0;
            int middle = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                if (arr[i] > middle) {
                    total += arr[i] - middle;
                }
            }
            if (total < gap) {
                end = middle - 1;
            } else {
                result = middle;
                start = middle + 1;
            }
        }
        return result;
    }
}
