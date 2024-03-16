package HayanLee.DFS_BFS.기출문제.Q19_연산자끼워넣기;

//오후 2시 1분 ~ 2시 31분
/*
알고리즘
0. 전역변수 선언하기(N, A, T, 연산자(+,-,*,/), 최댓값, 최솟값)
1. 수의 개수 N 입력받기
2. 수열 A 입력받기(String 또는 array)
3. 덧셈, 뺄샘, 곱셉, 나눗셈의 개수 입력받기(String 또는 array)
4. Max : Math.max로 합의 최댓값 구현
5. Min : Math.min으로 합의 최솟값 구현
 */
import java.util.*;
public class 연산자끼워넣기2 {
    static int N;
    static int[] A;
    static int[] T;

    static int add;
    static int sub;
    static int mul;
    static int div;
    static int now;

    static int maxResult = Integer.MIN_VALUE; //가장 작은 값 저장하기 위한 초기화
    static int minResult = Integer.MAX_VALUE; //가장 큰 값 저장하기 위한 초기화
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }

        sc.nextLine();

        T = new int[4];
        for(int i=0; i<4; i++){
            T[i] = sc.nextInt();
        }

        add = T[0];
        sub = T[1];
        mul = T[2];
        div = T[3];

        now = A[0];

        maxSum(1);
        minSum(1);


        //int maxSum = Math.max(sum, now);
        //int minSum = Math.min(sum, now);

        System.out.println(maxResult);
        System.out.println(minResult);


    }

    public static void maxSum(int i) {
        if (i == N) {
            maxResult = Math.max(maxResult, now); // 둘 중 큰 값 리턴
            return;
        }

        if (add > 0) {
            add--;
            now += A[i];
            maxSum(i + 1);
            now -= A[i];
            add++;
        }
        if (sub > 0) {
            sub--;
            now -= A[i];
            maxSum(i + 1);
            now += A[i];
            sub++;
        }
        if (mul > 0) {
            mul--;
            now *= A[i];
            maxSum(i + 1);
            now /= A[i];
            mul++;
        }
        if (div > 0) {
            div--;
            now /= A[i];
            maxSum(i + 1);
            now *= A[i];
            div++;
        }
    }

    public static void minSum(int i) {
        if (i == N) {
            minResult = Math.min(minResult, now); //둘 중 작은 값 리턴
            return;
        }

        if (add > 0) {
            add--;
            now += A[i];
            minSum(i + 1);
            now -= A[i];
            add++;
        }
        if (sub > 0) {
            sub--;
            now -= A[i];
            minSum(i + 1);
            now += A[i];
            sub++;
        }
        if (mul > 0) {
            mul--;
            now *= A[i];
            minSum(i + 1);
            now /= A[i];
            mul++;
        }
        if (div > 0) {
            div--;
            now /= A[i];
            minSum(i + 1);
            now *= A[i];
            div++;
        }
    }
}

