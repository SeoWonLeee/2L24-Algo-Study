package HayanLee.정렬.기출문제.Q26_카드정렬하기;
// 14:34 ~ 14: 42
/*
[알고리즘]
1. N 입력받기
2. 배열 입력받기
3. 배열을 내림차순 정렬하기
4. 배열의 합 구하기
 */
import java.util.*;
public class CardSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int sum = 0;
        for(int i=0; i<N; i++){
            sum += arr[i];
        }

        System.out.print(sum);
    }
}
