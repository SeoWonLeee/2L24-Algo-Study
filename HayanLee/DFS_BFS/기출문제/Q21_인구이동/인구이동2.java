package HayanLee.DFS_BFS.기출문제.Q21_인구이동;

// 오후 9시 34분 ~ 10시 46분

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인구이동2 {
    static int N;
    static int L;
    static int R;

    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 인구 이동 발생 수 리스트
    static ArrayList<int[]> union;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        sc.nextLine();

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(move());
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        union = new ArrayList<>();

        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int sum = arr[x][y];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            x = current[0];
            y = current[1];

            union.add(current); // 현재 좌표를 연합에 추가

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {

                    // 인구 차이 계산
                    int population = Math.abs(arr[x][y] - arr[nx][ny]);

                    // 인구 차이가 L 이상 R 이하인 경우에만 이동 가능
                    if (L <= population && population <= R) {
                        queue.offer(new int[]{nx, ny}); // BFS 탐색 계속하기
                        visited[nx][ny] = true;
                        sum += arr[nx][ny]; // 인구 이동 발생 수 합 구하기
                    }
                }
            }
        }
        return sum;
    }

    public static int move() { // 더 이상 인구이동이 일어나지 않을 때까지 반복
        int result = 0;
        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N]; // visited 배열 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j); // bfs 탐색으로 열릴 수 있는 국경선 확인하며 인구 이동할 총 인구수 반환
                        if (union.size() > 1) {
                            change(sum); // 열린 국경선 내의 노드들 인구 변경
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) return result;
            result++;
        }
    }

    public static void change(int sum) {
        int average = sum / union.size();
        for (int[] coord : union) {
            arr[coord[0]][coord[1]] = average;
        }
    }
}
