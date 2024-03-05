package HayanLee.그리디.기출문제.모험가길드;

import java.util.*;
public class 모험가길드 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //모험가
        int[] arr = new int[N]; //공포도

        for(int i=0; i < N; i++){ //배열 입력받기(공포도)
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); //입력받은 배열 정렬(오름차순)

        int result = 0; //총 그룹 수
        int count = 0; //그룹 안 모험가 수

        for(int i=0; i<N; i++){
            count += 1;
            if(count >= arr[i]){ // 현재 그룹 안 모험가수 >= 현재의 공포도 라면
                result += 1; //그룹만들기
                count = 0; //틀린 이유 -> 초기화를 진행하지 않아 '5'가 나옴 -> 그룹 안 모험가 수는 초기화히기(그래야 계속 루프를 돌며 그룹에 넣기 가능)
            }
        }
        System.out.println(result);
    }
}
