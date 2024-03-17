package HayanLee.정렬.이론.C6_정렬라이브러리.code;

import java.util.*;

public class SortedTest {

    public static void main(String[] args) {

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        int[] sortedArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArray);

        String result = Arrays.toString(sortedArray);
        System.out.println(result);
    }
}
