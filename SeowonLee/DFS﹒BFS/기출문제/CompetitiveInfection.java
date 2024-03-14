package DFS_BFS;

import java.util.*;

public class CompetitiveInfection {
    static class Virus {
        int x, y, time, type;

        public Virus(int x, int y, int time, int type) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.type = type;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] lab = new int[n][n]; // 시험관
        Queue<Virus> viruses = new LinkedList<>(); // 바이러스

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lab[i][j] = scanner.nextInt();
                if (lab[i][j] != 0) { // 바이러스 위치 저장
                    viruses.add(new Virus(i, j, 0, lab[i][j]));
                }
            }
        }

        int targetTime = scanner.nextInt(); // 목표 시간
        int targetX = scanner.nextInt() - 1; // 목표 위치
        int targetY = scanner.nextInt() - 1;

        while (!viruses.isEmpty()) {
            Virus virus = viruses.poll();

            if (virus.time == targetTime) break; // 목표 시간에 도달하면 종료

            for (int i = 0; i < 4; i++) { // 상하좌우로 증식
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && lab[nx][ny] == 0) { // 새로운 위치에 바이러스가 퍼질 수 있는 경우
                    lab[nx][ny] = virus.type;
                    viruses.offer(new Virus(nx, ny, virus.time + 1, virus.type));
                }
            }
        }

        System.out.println(lab[targetX][targetY]);
    }
}
