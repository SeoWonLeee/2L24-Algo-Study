package Samsung_pastquestion;

import java.util.ArrayList;
import java.util.Scanner;

public class TeenagerShark {
    static int[][][] array = new int[4][4][2];
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    // 45도 회전
    static int turnLeft(int direction) {
        return (direction + 1) % 8;
    }

    // 모든 물고기 이동
    static void moveAllFishes(int[][][] array, int nowX, int nowY) {
        for (int i = 1; i <= 16; i++) {
            int[] position = findFish(array, i);
            if (position != null) {
                int x = position[0];
                int y = position[1];
                int direction = array[x][y][1];
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[direction];
                    int ny = y + dy[direction];
                    if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && !(nx == nowX && ny == nowY)) {
                        int tempDirection = array[x][y][1];
                        array[x][y][1] = direction;
                        int[] temp = array[x][y];
                        array[x][y] = array[nx][ny];
                        array[nx][ny] = temp;
                        break;
                    }
                    direction = turnLeft(direction);
                }
            }
        }
    }

    // 물고기의 위치 찾기
    static int[] findFish(int[][][] array, int index) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j][0] == index) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 상어가 이동 가능한 위치 찾기
    static ArrayList<int[]> getPossiblePositions(int[][][] array, int nowX, int nowY) {
        ArrayList<int[]> positions = new ArrayList<>();
        int direction = array[nowX][nowY][1];
        for (int i = 0; i < 4; i++) {
            nowX += dx[direction];
            nowY += dy[direction];
            if (nowX >= 0 && nowX < 4 && nowY >= 0 && nowY < 4) {
                if (array[nowX][nowY][0] != -1) {
                    positions.add(new int[]{nowX, nowY});
                }
            }
        }
        return positions;
    }

    // DFS - 상어가 이동하며 먹을 수 있는 물고기의 최대 합 계산하기
    static void dfs(int[][][] array, int nowX, int nowY, int total, int[] result) {
        total += array[nowX][nowY][0];
        array[nowX][nowY][0] = -1;
        moveAllFishes(array, nowX, nowY);

        ArrayList<int[]> positions = getPossiblePositions(array, nowX, nowY);
        if (positions.isEmpty()) {
            result[0] = Math.max(result[0], total);
            return;
        }
        for (int positionIndex = 0; positionIndex < positions.size(); positionIndex++) {
            int[] position = positions.get(positionIndex);
            int[][][] newArray = copyArray(array);
            dfs(newArray, position[0], position[1], total, result);
        }
    }

    static int[][][] copyArray(int[][][] array) {
        int[][][] newArray = new int[4][4][2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newArray[i][j][0] = array[i][j][0];
                newArray[i][j][1] = array[i][j][1];
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j][0] = scanner.nextInt();
                array[i][j][1] = scanner.nextInt() - 1;
            }
        }

        int[] result = new int[]{0};
        dfs(array, 0, 0, 0, result);
        System.out.println(result[0]);
    }
}
