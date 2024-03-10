package Implementation;

import java.util.Scanner;

public class Lock_Key {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyInput = scanner.nextLine();
        int[][] key = parseArray(keyInput);

        String lockInput = scanner.nextLine();
        int[][] lock = parseArray(lockInput);

        // 주어진 키로 자물쇠를 열 수 있는지 확인
        boolean result = canUnlock(key, lock);
        System.out.println(result);
    }

    // 주어진 키로 자물쇠를 열 수 있는지 확인
    public static boolean canUnlock(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;

        // 키를 회전하면서 확인
        for (int rotate = 0; rotate < 4; rotate++) {
            key = rotateKey(key);
            // 자물쇠의 각 위치에서 키를 시도하여 맞는지 확인
            for (int i = -m + 1; i < n; i++) {
                for (int j = -m + 1; j < n; j++) {
                    if (isMatch(key, lock, i, j))
                        return true;
                }
            }
        }

        return false;
    }

    // 주어진 키가 자물쇠와 맞는지 확인
    public static boolean isMatch(int[][] key, int[][] lock, int offsetX, int offsetY) {
        int m = key.length;
        int n = lock.length;
        int[][] tempLock = new int[n][n];

        // 임시 자물쇠 생성
        for (int i = 0; i < n; i++) {
            System.arraycopy(lock[i], 0, tempLock[i], 0, n);
        }

        // 키를 이용하여 자물쇠를 열기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int x = i + offsetX;
                int y = j + offsetY;

                if (x >= 0 && x < n && y >= 0 && y < n) {
                    if (key[i][j] == 1 && tempLock[x][y] == 1)
                        return false;
                    if (key[i][j] == 1)
                        tempLock[x][y] = 1;
                }
            }
        }

        // 자물쇠가 모두 열렸는지 확인
        for (int[] row : tempLock) {
            for (int cell : row) {
                if (cell == 0)
                    return false;
            }
        }

        return true;
    }

    // 키를 시계방향으로 회전
    public static int[][] rotateKey(int[][] key) {
        int m = key.length;
        int[][] rotatedKey = new int[m][m];

        // 회전
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotatedKey[j][m - 1 - i] = key[i][j];
            }
        }

        return rotatedKey;
    }

    // 문자열을 2차원 배열로 파싱
    public static int[][] parseArray(String input) {
        String[] rows = input.split("\\]\\s*,\\s*\\[");
        int rowCount = rows.length;
        int colCount = rows[0].replaceAll("\\[|\\]", "").split("\\s*,\\s*").length;
        int[][] result = new int[rowCount][colCount];
        
        for (int i = 0; i < rowCount; i++) {
            String[] cols = rows[i].replaceAll("\\[|\\]", "").split("\\s*,\\s*");
            for (int j = 0; j < colCount; j++) {
                result[i][j] = Integer.parseInt(cols[j]);
            }
        }

        return result;
    }
}
