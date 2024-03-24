package HayanLee.다이나믹프로그래밍.실전문제._1로만들기;

// 10시 35분 ~10시45분
// 재풀이 : ~ 10시 55분
/*
[알고리즘]
1. X 입력받기
2. X가 5로 나누어떨어지면, 5로 나눈다.
3. X가 3으로 나누어떨어지면, 3으로 나눈다.
4. X가 2로 나누어떨어지면, 2로 나눈다.
5. X에서 1을 뺸다.
 */

import java.util.*;

public class MakeOne {

    static int[] d = new int[30001];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        for(int i=2; i<=X; i++){
            d[i] = d[i - 1] + 1;

            if(i % 5 == 0){
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }
            if(i % 3 == 0){
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            if(i % 2 == 0){
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
        }

        System.out.println(d[X]);
    }
}
