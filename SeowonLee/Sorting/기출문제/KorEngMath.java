package Sorting;

import java.util.Scanner;

public class KorEngMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        String[][] students = new String[N][4]; // [이름, 국어, 영어, 수학]
        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            students[i] = input;
        }

        // 버블 정렬
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                // 정렬 조건에 따라 순서 변경
                if (compare(students[j], students[j + 1]) > 0) {
                    String[] temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        for (String[] student : students) {
            System.out.println(student[0]);
        }
    }

    // 학생 비교
    public static int compare(String[] s1, String[] s2) {
        int korean1 = Integer.parseInt(s1[1]);
        int english1 = Integer.parseInt(s1[2]);
        int math1 = Integer.parseInt(s1[3]);

        int korean2 = Integer.parseInt(s2[1]);
        int english2 = Integer.parseInt(s2[2]);
        int math2 = Integer.parseInt(s2[3]);

        if (korean1 != korean2) {
            return Integer.compare(korean2, korean1); // 국어 점수 감소 순서
        } else if (english1 != english2) {
            return Integer.compare(english1, english2); // 국어 점수가 같으면 영어 점수 증가 순서
        } else if (math1 != math2) {
            return Integer.compare(math2, math1); // 국어, 영어 점수가 같으면 수학 점수 감소 순서
        } else {
            return s1[0].compareTo(s2[0]); // 모든 점수가 같으면 이름이 사전 순으로 증가 순서
        }
    }
}
