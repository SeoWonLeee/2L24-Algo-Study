package HayanLee.다이나믹프로그래밍.기출문제.Q33_퇴사;

//오후 1시 6분 ~ 1시 20분
/*
[알고리즘]
1. N 입력받기
2. T, P 배열 입력받기
3. d로 테이블 초기화하기
4. 바텀업으로 구현
   - Math.max로 최대 이익 구현
   - 상담 기간 벗어나는 예외 조건 적용
 */
import java.util.*;
public class Resignation {

    static int N;
    static int[] T;
    static int[] P;
    static int[] d;
    static int maxCon; //최대 수익 -> 전역변수로 위치 변경
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        T = new int[N];
        P = new int[N];
        for(int i=0; i<N; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        d = new int[N + 1]; //d 크기를 N+1로 변경

        for(int i = N-1; i>=0; i--){

            int time = T[i] + i;

            if(time<=N){ //상담이 되는 경우
                //T[i]+i는 상담을 시작하는 날짜(T[i])부터 상담을 진행하는 데 걸리는 일 수(i)를 더한 값
                //상담을 시작하고 나면 그 일 수만큼은 무조건 상담이 불가하기 때문!
                d[i] = Math.max((P[i] + d[time]), maxCon);
                maxCon = d[i];
            } else {
                d[i] = maxCon;
            }
        }
        System.out.println(maxCon);
    }
}
