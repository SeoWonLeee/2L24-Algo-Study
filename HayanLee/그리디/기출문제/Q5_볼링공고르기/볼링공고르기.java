package HayanLee.그리디.기출문제.Q5_볼링공고르기;

//오후 4시 45분 시작 ~ 5시 13분 종료
import java.util.*;
public class 볼링공고르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1. N, M, 배열 입력받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = combination(arr, N, 2);
        System.out.println(result);
    }

    //2. nCr 조합으로 계산하기(백트래킹 사용)
    static int combination(int[] arr, int N, int r) {
        int count = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] != arr[j]) { //문제의 조건에 두 사람은 서로 다른 무게를 골라야한다고 했기 때문.
                    count++;
                }
            }
        }
        return count;
    }
}