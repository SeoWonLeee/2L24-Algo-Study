package HayanLee.정렬.기출문제.Q26_카드정렬하기;
// 14:34 ~ 14: 42
//재풀이 ~ 3시 10분
/*
[알고리즘]
1. N 입력받기
2. 배열 입력받기
3. 배열을 내림차순 정렬하기 -> 오름차순으로 정렬해야 함!
4. 카드 합치기
    - 우선순위 큐를 이용해 매번 가장 작은 두 카드를 선택해 합치기
5. 결과 출력

 */
import java.util.*;

public class CardSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        //Arrays.sort(arr);

        int result = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.offer(arr[i]);
        }

        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            result += sum;
            pq.offer(sum);
        }
        System.out.println(result);
    }
}
