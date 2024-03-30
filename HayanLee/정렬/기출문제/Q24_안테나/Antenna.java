package HayanLee.정렬.기출문제.Q24_안테나;

import java.util.*;

public class Antenna {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);

        System.out.println(arrayList.get((N - 1) / 2));
    }
}
