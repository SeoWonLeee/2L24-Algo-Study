package HayanLee.정렬.실전문제.두_배열의_원소_교체;

//오후 7시 19분 ~ 7시 27분
// 재풀이 : ~7시 42분
/*
[알고리즘]
1. N, K 입력받기
2. 배열 A 입력받기
3. 배열 B 입력받기
4. 최종 배열 C 만들기
5. 두 배열을 오름차순 정렬
6. 배열 A와 B의 원소를 비교
   - A > B 라면 A 원소를 C에 넣기
   - A < B 라면 B 원소를 C에 넣기
7. C의 배열의 합 구해서 출력하기
 */

import java.util.*;
public class ChangeElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Integer[] A = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        //int[] C = new int[N];

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for (int i = 0; i < K; i++) {
            if (A[i] < B[i]) {
                A[i] = B[i];
            } else {
                break;
            }
        }

        int sum = 0;

        for(int i=0; i<N; i++){
            sum += A[i];
        }

        System.out.print(sum);
    }
}
