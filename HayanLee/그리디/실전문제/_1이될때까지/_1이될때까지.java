package HayanLee.그리디.실전문제._1이될때까지;

import java.util.*;

//주어진 N에 대한 최대한 많이 나누기 수행!
public class _1이될때까지 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        /*//첫번째 풀이
        int N = sc.nextInt();
        int K = sc.nextInt();

        int count = 0;

        while(N > 1){ // N이 아직 1이 안되었을 경우 계속 반복
            if( N % K == 0){ //2번 연산이 가능한 경우 : N / K 진행
                N /= K;
            }
            if(N % K != 0){ //1번 연산이 가능한 경우 : N-1 진행
                N -= 1;
            }
            count++; //N이 1이 될때까지(while문이 돌아가는 동안) 1번과 2번 연산의 모든 횟수 계속 더하기
        }
        System.out.println(count);*/

        //2번째 풀이
        int N = sc.nextInt();
        int K = sc.nextInt();
        int result = 0;

        //N이 K로 나누어 떨어지는 수가 될 때까지는 -> N-1 진행(1번 연산)
        while(true){
            int target = (N / K) * K; //target = 나누어 떨어지는 것이 가능한 수(그 수를 찾기 위해 이름이 target)
            result += (N - target);

            // N이 나누어 떨어지는 수가 된 경우
            N = target;
            if(N < K)
                break;
            //K로 나누기
            result += 1; //2번 연산 진행
            N /= K;
        }

        //그 다음 다시 어떤 연산을 할지 결정 : 이제는 또 다시 나누어 떨어지는 수가 되지 않으니 1번 연산인 남은 수에 대하여 1씩 빼기 진행
        result += (N - 1);
        System.out.println(result);
    }
}
