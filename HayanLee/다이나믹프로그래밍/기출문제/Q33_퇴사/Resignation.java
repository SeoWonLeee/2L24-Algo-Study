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
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for(int i=0; i<N; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        d = new int[16];

        // 바텀업으로 구현
        //   - Math.max로 최대 이익 구현
        //   - 상담 기간 벗어나는 예외 조건 적용

        int maxCon = 0; //최대 수익

        for(int i = N; i>0; i--){
            int time = T[i]; //상담 일정표 중 시간에 해당

            if(time<=N){ //상담이 되는 경우
                d[i] = Math.max(P[i] + d[time], maxCon);
            } else {
                d[i] = maxCon;
            }
        }
        System.out.println(maxCon);
    }
}
