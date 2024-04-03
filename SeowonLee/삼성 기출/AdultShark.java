package Samsung_pastquestion;

import java.util.Scanner;

public class AdultShark {
    static int n, m, k;
    static int[][] array;
    static int[] directions;
    static int[][][] smell;
    static int[][][] priorities;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();

        array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        directions = new int[m];
        for (int i = 0; i < m; i++) {
            directions[i] = scanner.nextInt();
        }

        smell = new int[n][n][2];
        priorities = new int[m][4][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    priorities[i][j][k] = scanner.nextInt();
                }
            }
        }

        int time = 0;
        while (true) {
            updateSmell();
            int[][] newArray = move();
            array = newArray;
            time++;

            boolean check = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (array[i][j] > 1) {
                        check = false;
                    }
                }
            }
            if (check) {
                System.out.println(time);
                break;
            }

            if (time >= 1000) {
                System.out.println(-1);
                break;
            }
        }
    }

    // 냄새
    static void updateSmell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (smell[i][j][1] > 0) {
                    smell[i][j][1]--;
                }
                if (array[i][j] != 0) {
                    smell[i][j][0] = array[i][j];
                    smell[i][j][1] = k;
                }
            }
        }
    }

    // 상어 이동
    static int[][] move() {
         int[][] newArray = new int[n][n];
         for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                // 상어가 존재하는 위치인 경우
                if (array[x][y] != 0) {
                     int direction = directions[array[x][y] - 1];
                     boolean found = false;
                     for (int index = 0; index < 4; index++) {
                        int nx = x + dx[priorities[array[x][y] - 1][direction - 1][index] - 1];
                        int ny = y + dy[priorities[array[x][y] - 1][direction - 1][index] - 1];
                        // 이동 가능한 위치가 냄새가 없는 곳이면
                        if (isWithinBounds(nx, ny) && smell[nx][ny][1] == 0) {
                            // 상어의 방향 설정 및 새로운 위치에 상어 이동
                            directions[array[x][y] - 1] = priorities[array[x][y] - 1][direction - 1][index];
                            // 새로운 위치에 상어가 없으면 이동
                            if (newArray[nx][ny] == 0) {
                                newArray[nx][ny] = array[x][y];
                            } else {
                                // 이미 다른 상어가 있는 경우, 작은 번호의 상어만 남기고 이동
                                newArray[nx][ny] = Math.min(newArray[nx][ny], array[x][y]);
                            }
                            found = true;
                            break;
                        }
                    }
                    // 이동할 수 있는 위치를 찾지 못한 경우, 자신의 냄새가 있는 곳으로 이동
                    if (!found) {
                        for (int index = 0; index < 4; index++) {
                            int nx = x + dx[priorities[array[x][y] - 1][direction - 1][index] - 1];
                            int ny = y + dy[priorities[array[x][y] - 1][direction - 1][index] - 1];
                            // 자신의 냄새가 있는 곳으로 이동
                            if (isWithinBounds(nx, ny) && smell[nx][ny][0] == array[x][y]) {
                                directions[array[x][y] - 1] = priorities[array[x][y] - 1][direction - 1][index];
                                newArray[nx][ny] = array[x][y];
                                break;
                            }
                        }
                    }
                }
            }
        }
        return newArray;
    }

    static boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
