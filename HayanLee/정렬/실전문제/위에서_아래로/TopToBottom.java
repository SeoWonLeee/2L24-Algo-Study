package HayanLee.정렬.실전문제.위에서_아래로;

//오후 5시 36분 ~ 5시 45분

import java.util.*;

public class TopToBottom {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        //int[] arr = new int[N];
        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }


        Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0; i<N; i++) {
            System.out.println(arr[i] + " ");
        }


    }
}
