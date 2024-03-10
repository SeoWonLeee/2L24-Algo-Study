package HayanLee.구현.기출문제.Q8_문자열재정렬;

//오전 2시 42분 ~ 3시
import java.util.*;
public class 문자열재정렬 {
    public static void main(String[] args){
        /*- 문자열 입력받기
                - 오름차순 정렬하기
                - 문자 출력하기
                - 만약, 숫자가 있다면 : 숫자의 합 구해서 뒤에 붙여 출력
        - 그렇지 않다면 : 문자만 출력*/
        Scanner sc = new Scanner(System.in);

        String N = sc.next();

        List<Character> chs = new ArrayList<>();
        int num = 0;

        for (int i = 0; i < N.length(); i++) {
            char ch = N.charAt(i);

            if (Character.isLetter(ch)) {
                chs.add(ch);
            }
            else {
                num += ch - '0';
            }
        }

        Collections.sort(chs);


        if(num != 0){
            System.out.print(num);
            System.out.println();
        }

    }
}
