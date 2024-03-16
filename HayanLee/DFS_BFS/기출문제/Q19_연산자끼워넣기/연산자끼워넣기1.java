package HayanLee.DFS_BFS.기출문제.Q19_연산자끼워넣기;

//오후 2시 1분 ~ 2시 31분
/*
알고리즘
0. 수의 개수 N 입력받기
1. 수열 A 입력받기(String 또는 array)
2. 덧셈, 뺄샘, 곱셉, 나눗셈의 개수 입력받기(String 또는 array)
3. Max : 곱셈, 덧셈을 먼저 연산자 사이에 끼워넣어질 수 있도록 구현
4. Min : 나눗셈, 뺄셈을 먼저 연산자 사잉 끼워넣어질 수 있도록 구현
 */
import java.util.*;
public class 연산자끼워넣기1 {
    static int N;
    static int[] A;
    static int[] T;

    static int add;
    static int sub;
    static int mul;
    static int div;
    static int now;

    static int sum = Arrays.stream(A).sum();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }

        sc.nextLine();

        T = new int[3];
        for(int i=0; i<4; i++){
            T[i] = sc.nextInt();
        }

        int maxSum = Math.max(sum, now);
        int minSum = Math.min(sum, now);

        System.out.println(maxSum);
        System.out.println(minSum);


    }

    public static int maxSum(int i, int now) {
        int sum = Arrays.stream(A).sum();
        if(mul > 0){
            sum = sum+1;
        }
        if(add > 0){
            sum = sum+1;
        }
        return 0;
    }

    public static int minSum(int j, int now) {
        int sum = Arrays.stream(A).sum();
        if(div > 0){
            sum = sum+1;
        }
        if(sub > 0){
            sum = sum+1;
        }
        return 0;
    }
}
