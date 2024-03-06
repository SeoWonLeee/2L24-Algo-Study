package HayanLee.그리디.기출문제.Q5_볼링공고르기;

// 오후 4시 45분 시작
import java.util.*;

public class 볼링공고르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. N, M, 배열 입력받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int r = 2; // 볼링공 2개를 고르는 경우이므로 r은 2로 설정
        boolean[] visited = new boolean[N];

        // 3. nCr 조합으로 계산하기(백트래킹 사용)
        int result = combination(arr, visited, 0, N, r);
        System.out.println(result);
    }

    // 2. nCr 조합으로 계산하기(백트래킹 사용)
    static int combination(int[] arr, boolean[] visited, int start, int N, int r) {
        if (r == 0) {
            return 1; // 조합을 찾았을 때마다 1을 반환하여 개수를 세어줍니다.
        }

        int count = 0;

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                count += combination(arr, visited, i + 1, N, r - 1);
                visited[i] = false;
            }
        }

        return count;
    }
}
