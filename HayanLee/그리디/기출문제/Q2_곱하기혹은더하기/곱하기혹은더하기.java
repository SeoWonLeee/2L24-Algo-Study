package HayanLee.그리디.기출문제.Q2_곱하기혹은더하기;

//오후 1시 8분 시작 ~ 1시 35분
import java.util.*;

public class 곱하기혹은더하기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int result = str.charAt(0) - '0'; //비교할 첫번째 수

        for(int i=0; i<str.length(); i++){
            int num = str.charAt(i) - '0'; //연산을 할 수
            if(num <= 1 || result <= 1){ // 두 수 중 하나라도 1 이하인 경우에는 더하기 연산!
                result += num;
            }else{
                result *= num;
            }
        }
        System.out.println(result);
    }
}
