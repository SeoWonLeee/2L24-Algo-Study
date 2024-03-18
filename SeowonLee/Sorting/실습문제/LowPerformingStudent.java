package Sorting;

import java.util.*;

public class LowPerformingStudent {
    static class Student implements Comparable<Student> {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student other) {
            return Integer.compare(this.score, other.score);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }

        // 퀵 정렬
        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.print(student.name + " ");
        }
    }
}
