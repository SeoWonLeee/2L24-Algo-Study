package Sorting;

import java.util.*;

public class FailureRate {

    static class Stage implements Comparable<Stage> {
        int index;
        double failureRate;

        // 스테이지
        public Stage(int index, double failureRate) {
            this.index = index;
            this.failureRate = failureRate;
        }

        // 스테이지 비교
        @Override
        public int compareTo(Stage other) {
            if (this.failureRate == other.failureRate) {
                return Integer.compare(this.index, other.index);
            }
            return Double.compare(other.failureRate, this.failureRate);
        }
    }

    // 퀵 정렬
    public static void quickSort(Stage[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // 퀵 정렬 파티션
    public static int partition(Stage[] arr, int low, int high) {
        Stage pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;

                Stage temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 피벗 위치 교환
        Stage temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // 실패율 계산
    public static int[] solution(int N, int[] stages) {
        int[] usersInStage = new int[N + 2];
        for (int stage : stages) {
            usersInStage[stage]++;
        }

        int totalUsers = stages.length;
        Stage[] failureRates = new Stage[N];

        // 각 스테이지별 실패율 계산
        for (int i = 1; i <= N; i++) {
            double failureRate = totalUsers == 0 ? 0 : (double) usersInStage[i] / totalUsers;
            failureRates[i - 1] = new Stage(i, failureRate);
            totalUsers -= usersInStage[i];
        }

        // 퀵 정렬: 실패율 내림차순으로 정렬
        quickSort(failureRates, 0, N - 1);

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = failureRates[i].index;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        String[] stagesStr = scanner.nextLine().split(", ");
        int[] stages = new int[stagesStr.length];
        for (int i = 0; i < stagesStr.length; i++) {
            stages[i] = Integer.parseInt(stagesStr[i]);
        }

        int[] result = solution(N, stages);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
            if (i != result.length - 1) {
                sb.append(' ');
            }
        }
        System.out.println(sb.toString());
    }
}
