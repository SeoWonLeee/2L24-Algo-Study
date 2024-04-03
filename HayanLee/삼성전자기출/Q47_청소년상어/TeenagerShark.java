package HayanLee.삼성전자기출.Q47_청소년상어;

/*
1. 배열 입력받기(물고기의 번호, 방향)
2. DFS 진행하기 및 그로 발생된 최소 비교 횟수 출력
3. DFS(별도 메서드로 구현)
   - 매 줄마다 4마리의 물고기 번호와 방향이 주어진 정보를 확인해 물고기 정보를 [물고기 번호, 방향]으로 저장
   - 입력에서 받은 각 물고기별 정보에 따라 물고기를 회전 및 이동 연산하기(방향은 8가지임.)
 */
import java.util.*;
public class TeenagerShark {
    static int[][] Fishes;

    static int[][] InitFish;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Fishes = new int[4][4];
        for(int i=0; i<Fishes.length; i++){
            for(int j=0; j<Fishes.length; j++) {
                Fishes[i][j] = sc.nextInt();
            }
        }

        //초기 물고기 위치
        InitFish = new int[17][2];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                InitFish[Fishes[i][j]] = new int[]{i, j};
            }
        }

        int result = dfs(0, 0, Fishes[0][0], Fishes[0][1], InitFish);

        System.out.println(result);
    }

    public static int dfs(int x, int y, int score, int sharkDir, int[][] InitFish) {
        int[][] temp = new int[4][4];
        for(int i = 0; i < 4; i++) {
            temp[i] = Arrays.copyOf(Fishes[i], Fishes[i].length);
        }

        int eatenFish = temp[x][y];
        temp[x][y] = -1; // 상어의 위치 표시

        if (x <= -1 || x >= 5 || y <= -1 || y >= 9) {
            Fishes[x][y] = -1;
        }

        if (Fishes[x][y] == 0) {
            Fishes[x][y] = 1;

            int maxScore = score; // 최대 점수

            for(int dist = 1; dist <= 3; dist++) {
            int nx = x + dx[sharkDir] * dist;
            int ny = y + dy[sharkDir] * dist;
                if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && temp[nx][ny] != -1) {
                maxScore = Math.max(maxScore, dfs(nx, ny, score + eatenFish, temp[nx][ny], InitFish));
                }
            }
        }
        return score;
    }
}
