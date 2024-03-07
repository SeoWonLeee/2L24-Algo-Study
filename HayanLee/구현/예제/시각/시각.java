package HayanLee.구현.예제.시각;

import java.util.*;
public class 시각 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //N = 시간

        int count = 0; //실제 카운트하는 변수

        for(int i=0; i<=N; i++){
            for(int j=0; j<60; j++){ //59분까지
                for(int k=0; k<60; k++){ //59초까지
                    /*
                    00시 00분 00초의 형식으로 검사될 것임. %s는 일의 자리, /는 십의 자리로 OR 구성
                    단, 맨 앞의 시간은 최대 23까지 구성되어 있으니 굳이 시간의 십의 자리를 나눠 검사할 필요가 없음.
                    */
                    if (i % 10 == 3 || j / 10 == 3 || j % 10 == 3 || k / 10 == 3 || k % 10 == 3){
                        /*
                        - 시간의 일의 자리를 알기 위해 i % 10 == 3 사용
                        - 분의 십의 자리를 알기 위해 j / 10 == 3 사용
                        - 분의 일의 자리를 알기 위해 j % 10 == 3 사용
                        - 초의 십의 자리를 알기 위해 k / 10 == 3 사용
                        - 초의 일의 자리를 알기 위해 k % 10 == 3 사용
                         */
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
