package HayanLee.정렬.실전문제.성적이_낮은_순서로_학생_출력하기;

//오후 5시 50분 ~ 6시 2분

/*
[알고리즘]
1. N 입력받기
2. String형 배열 입력받기
3. 점수를 기준으로 정렬하기
4. 학생 이름 출력하기
 */

import java.util.*;
public class ScoreDesc {

    static class Students implements Comparable<Students> {

        private String name;
        private int score;

        public Students(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return this.name;
        }

        public int getScore() {
            return this.score;
        }

        @Override
        public int compareTo(Students other) {
            if (this.score < other.score) {
                return -1;
            }
            return 1;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        /*Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            students.add();
        }*/

        List<Students> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Students(name, score));
        }

        Collections.sort(students);

        for(int i=0; i<N; i++){
            System.out.print(students.get(i).getName() + " ");
        }

    }
}
