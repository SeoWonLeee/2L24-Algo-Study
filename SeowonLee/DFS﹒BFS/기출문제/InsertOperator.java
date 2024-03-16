package DFS_BFS;

import java.util.Scanner;

public class InsertOperator {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4];

    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = scanner.nextInt();
        }

        dfs(numbers[0], 1); // DFS

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    // 가능한 연산자 조합 계산 DFS
    static void dfs(int result, int index) {
        if (index == N) { // 모든 숫자에 대한 연산이 완료되면
            maxResult = Math.max(maxResult, result); // 최댓값 갱신
            minResult = Math.min(minResult, result); // 최솟값 갱신
            return; // 종료
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) { // 해당 연산자를 사용할 수 있는지 확인
                operators[i]--; // 해당 연산자 사용 횟수 감소
                switch (i) {
                    case 0:
                        dfs(result + numbers[index], index + 1); // 덧셈
                        break;
                    case 1:
                        dfs(result - numbers[index], index + 1); // 뺄셈
                        break;
                    case 2:
                        dfs(result * numbers[index], index + 1); // 곱셈
                        break;
                    case 3:
                        dfs(result / numbers[index], index + 1); // 나눗셈
                        break;
                }
                operators[i]++; // 연산자 사용 횟수 복구
            }
        }
    }
}
