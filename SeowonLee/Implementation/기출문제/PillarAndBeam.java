package Implementation;

import java.util.*;

public class PillarAndBeam {
    public int[][] buildStructure(int n, int[][] build_frame) {
        boolean[][] pillars = new boolean[n + 3][n + 3];
        boolean[][] beams = new boolean[n + 3][n + 3];
        List<int[]> result = new ArrayList<>();

        // 구조물 또는 삭제
        for (int[] frame : build_frame) {
            int x = frame[0] + 1;
            int y = frame[1] + 1;
            int type = frame[2];
            int action = frame[3];

            if (type == 0) { // 기둥
                if (action == 1 && canInstallPillar(pillars, beams, x, y)) {
                    pillars[x][y] = true;
                } else if (action == 0) { // 삭제인 경우
                    pillars[x][y] = false;
                    if (!isValid(pillars, beams, n)) {
                        pillars[x][y] = true;
                    }
                }
            } else { // 보
                if (action == 1 && canInstallBeam(pillars, beams, x, y)) {
                    beams[x][y] = true;
                } else if (action == 0) { // 삭제인 경우
                    beams[x][y] = false;
                    if (!isValid(pillars, beams, n)) {
                        beams[x][y] = true;
                    }
                }
            }
        }

        // 설치된 기둥과 보를 결과
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                if (pillars[i][j]) {
                    result.add(new int[]{i - 1, j - 1, 0});
                }
                if (beams[i][j]) {
                    result.add(new int[]{i - 1, j - 1, 1});
                }
            }
        }

        // 결과 리스트 정렬
        result.sort((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                }
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        return result.toArray(new int[result.size()][3]);
    }

    // 기둥을 설치할 수 있는지 여부 확인
    private boolean canInstallPillar(boolean[][] pillars, boolean[][] beams, int x, int y) {
        return y == 1 || pillars[x][y - 1] || beams[x][y] || (x > 1 && beams[x - 1][y]);
    }

    // 보를 설치할 수 있는지 여부 확인
    private boolean canInstallBeam(boolean[][] pillars, boolean[][] beams, int x, int y) {
        return pillars[x][y - 1] || pillars[x + 1][y - 1] || (x > 1 && beams[x - 1][y] && beams[x + 1][y]);
    }

    // 구조물이 유효한지 여부 확인
    private boolean isValid(boolean[][] pillars, boolean[][] beams, int n) {
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                if (pillars[i][j] && !canInstallPillar(pillars, beams, i, j)) {
                    return false;
                }
                if (beams[i][j] && !canInstallBeam(pillars, beams, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 구조물의 크기
        int numOperations = scanner.nextInt(); // 작업 수

        // 작업 내용 입력
        int[][] build_frame = new int[numOperations][4];
        for (int i = 0; i < numOperations; i++) {
            for (int j = 0; j < 4; j++) {
                build_frame[i][j] = scanner.nextInt();
            }
        }

        // 구조물 생성
        PillarAndBeam solution = new PillarAndBeam();
        int[][] result = solution.buildStructure(n, build_frame);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
