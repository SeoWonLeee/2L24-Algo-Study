package HayanLee.삼성전자기출.Q48_어른상어;

import java.util.Scanner;

public class AdultShark {
    static int N, M, K;
    static int[][] board;
    static Shark[] sharks;
    static Smell[][] smells;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    static class Shark {
        int num, x, y, dir;
        boolean alive;

        Shark(int num, int x, int y, int dir, boolean alive) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.alive = alive;
        }
    }

    static class Smell {
        int sharkNum, time;

        Smell(int sharkNum, int time) {
            this.sharkNum = sharkNum;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        board = new int[N][N];
        smells = new Smell[N][N];
        sharks = new Shark[M + 1];

        // 상어들과 냄새 초기 설정
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                if (num != 0) {
                    board[i][j] = num;
                    smells[i][j] = new Smell(num, K);
                    sharks[num] = new Shark(num, i, j, 0, true);
                }
            }
        }

        int result = simulate(); // 결과를 계산하는 함수 호출

        System.out.println(result);
    }

    static int simulate() {
        for (int time = 1; time <= 1000; time++) {
            moveSharks(time);
            updateSmells(time);
            if (checkSingleSharkLeft()) {
                return time;
            }
        }
        return -1;
    }

    // 상어 이동 함수
    static void moveSharks(int time) {
        for (int i = 1; i <= M; i++) {
            if (sharks[i] != null && sharks[i].alive) {
                Shark shark = sharks[i];
                boolean moved = false;
                for (int j = 0; j < 4; j++) {
                    int nx = shark.x + dx[shark.dir];
                    int ny = shark.y + dy[shark.dir];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (smells[nx][ny] == null || smells[nx][ny].time < time) {
                            if (board[nx][ny] == 0 || board[nx][ny] > shark.num) {
                                if (board[nx][ny] != 0) {
                                    sharks[board[nx][ny]].alive = false;
                                }
                                board[nx][ny] = shark.num;
                                board[shark.x][shark.y] = 0;
                                shark.x = nx;
                                shark.y = ny;
                                shark.dir = j + 1;
                                moved = true;
                                break;
                            }
                        }
                    }
                    shark.dir = (shark.dir + 1) % 4;
                }
                if (!moved) {
                    for (int j = 0; j < 4; j++) {
                        int nx = shark.x + dx[shark.dir];
                        int ny = shark.y + dy[shark.dir];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if (smells[nx][ny] != null && smells[nx][ny].sharkNum == shark.num) {
                                board[nx][ny] = shark.num;
                                board[shark.x][shark.y] = 0;
                                shark.x = nx;
                                shark.y = ny;
                                shark.dir = j + 1;
                                break;
                            }
                        }
                        shark.dir = (shark.dir + 1) % 4;
                    }
                }
            }
        }
    }

    // 냄새 갱신 함수
    static void updateSmells(int time) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smells[i][j] != null) {
                    smells[i][j].time--;
                    if (smells[i][j].time == 0) {
                        smells[i][j] = null;
                    }
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            if (sharks[i] != null && sharks[i].alive) {
                Shark shark = sharks[i];
                smells[shark.x][shark.y] = new Smell(shark.num, K);
            }
        }
    }

    // 한 마리의 상어만 남아있는지 확인하는 함수
    static boolean checkSingleSharkLeft() {
        int count = 0;
        for (int i = 1; i <= M; i++) {
            if (sharks[i] != null && sharks[i].alive) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
