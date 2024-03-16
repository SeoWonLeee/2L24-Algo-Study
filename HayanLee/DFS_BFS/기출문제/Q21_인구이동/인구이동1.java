package HayanLee.DFS_BFS.기출문제.Q21_인구이동;

// 오후 9시 34분 ~
import java.util.*;

public class 인구이동1 {
    static int N;
    static int L;
    static int R;

    static int[][] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        sc.nextLine();

        arr = new int[N][N];
        for(int i=0; i<N; i++){
            String land = sc.nextLine();
            for(int j=0; j<N; j++){
                arr[i][j] = land.charAt(j) - '0';
            }
        }

        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(dfs(i,j)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static boolean dfs(int i, int j) {
        if (i <= -1 || i >= N || j <= -1 || j >= N) {//틀 밖으로 나갈 경우
            return false;
        }

        if (arr[i][j] == 0) {
            arr[i][j] = 1; //방문

            dfs(i + 1, j);
            dfs(i - 1, j);
            dfs(i, j + 1);
            dfs(i, j - 1);

            return true;
        }
        return false;
    }
}