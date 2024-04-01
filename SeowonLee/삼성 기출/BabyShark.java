package Samsung_pastquestion;

import java.util.*;

public class BabyShark {
    static int[][] map;
    static int N;
    static int sharkSize = 2;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static class Point {
        int x, y, dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N][N];

        int startX = 0, startY = 0;

         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }

        int answer = 0;
        int eatableFish = 0;

        while (true) {
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(startX, startY, 0));
            boolean[][] visited = new boolean[N][N];
            visited[startX][startY] = true;
            List<Point> fishList = new ArrayList<>();

            // BFS - 상어 주변의 먹을 수 있는 물고기 찾기
            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    // 맵을 벗어나지 않고, 방문하지 않았으며, 상어의 크기보다 작거나 같은 물고기인 경우
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] <= sharkSize) {
                        visited[nx][ny] = true;
                        if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) { // 먹을 수 있는 물고기인 경우
                            fishList.add(new Point(nx, ny, cur.dist + 1));
                        }
                        queue.offer(new Point(nx, ny, cur.dist + 1));
                    }
                }
            }

            if (fishList.isEmpty()) {
                break;
            }

            // 가까운 물고기 선택
            fishList.sort(new Comparator<Point>() {
                @Override
                public int compare(Point a, Point b) {
                    if (a.dist == b.dist) {
                        if (a.x == b.x) {
                            return Integer.compare(a.y, b.y);
                        }
                        return Integer.compare(a.x, b.x);
                    }
                    return Integer.compare(a.dist, b.dist);
                }
            });

            Point target = fishList.get(0);
            answer += target.dist;
            eatableFish++;
            if (eatableFish == sharkSize) { // 먹은 물고기 수가 상어의 크기와 같으면 상어 크기 증가
                sharkSize++;
                eatableFish = 0;
            }

            map[target.x][target.y] = 0; // 먹은 물고기 없애기
            startX = target.x;
            startY = target.y;
        }

        System.out.println(answer);
    }
}
