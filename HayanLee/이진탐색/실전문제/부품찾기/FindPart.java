package HayanLee.이진탐색.실전문제.부품찾기;

//오후 3시 18분 ~

/*
[알고리즘]
1. N 입력받기(부품의 개수)
2. 배열 입력받기
3. M 입력받기(부품 종류)
4. 배열 입력받기
5. 이진 탐색을 위해 정렬 먼저 하기
6. 부품 번호 확인 -> 있으면 yes, 없으면 no 출력
7. 별도 메서드로 이진 탐색 구현하기
 */

import java.util.*;


public class FindPart {

    static int N;
    static int M;
    static int[] arrOne;
    static int[] arrTwo;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arrOne = new int[N];
        for(int i=0; i<N; i++){
            arrOne[i] = sc.nextInt();
        }

        Arrays.sort(arrOne);

        M = sc.nextInt();
        arrTwo = new int[M];
        for(int i=0; i<M; i++){
            arrTwo[i] = sc.nextInt();
        }

        int result = binarySearch(arrOne, arrTwo[i], 0, N-1);

        for(int i=0; i<M; i++) {
            if (result == -1) {
                System.out.print("no" + " ");
            } else {
                System.out.print("yes" + " ");
            }
        }


    }

    public static class binarySearch (int[] arrOne, int[] arrTwo, int start, int end){
        while (start <= end){
            int middle = (start + end) / 2;
            if(arrOne[middle] == arrTwo[middle]){
                return middle;
            }
            if(arrOne[middle] > arrTwo[middle]){
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
