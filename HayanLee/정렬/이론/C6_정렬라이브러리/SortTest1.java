package HayanLee.정렬.이론.C6_정렬라이브러리;

import java.util.Arrays;

import java.util.*;
public class SortTest1 {

    public static void main(String[] args) {

        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
