package Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChickenDelivery {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int distance(Point other) {
            return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
        }
    }

    static int minDistance = Integer.MAX_VALUE;

    // 최소 치킨 거리 계산
    static void dfs(int index, int count, List<Point> chickens, List<Point> selected, List<Point> houses) {
        if (count == 0) {
            int totalDistance = 0;
            for (Point house : houses) {
                int minHouseDistance = Integer.MAX_VALUE;
                for (Point chicken : selected) {
                    minHouseDistance = Math.min(minHouseDistance, house.distance(chicken));
                }
                totalDistance += minHouseDistance;
            }
            minDistance = Math.min(minDistance, totalDistance);
            return;
        }

        for (int i = index; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            dfs(i + 1, count - 1, chickens, selected, houses);
            selected.remove(selected.size() - 1);
        }
    }

    // 주어진 치킨집, 집 정보로부터 최소 치킨 거리 계산
    static int minChickenDistance(List<Point> chickens, List<Point> houses, int m) {
        dfs(0, m, chickens, new ArrayList<>(), houses);
        return minDistance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Point> chickens = new ArrayList<>();  // 치킨집 위치 리스트
        List<Point> houses = new ArrayList<>();    // 집 위치 리스트

        // 도시의 정보 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = scanner.nextInt();
                if (value == 1) {
                    houses.add(new Point(i, j));    // 집 위치 추가
                } else if (value == 2) {
                    chickens.add(new Point(i, j));  // 치킨집 위치 추가
                }
            }
        }

        // 최소 치킨 거리 계산
        int minDistance = minChickenDistance(chickens, houses, m);
        System.out.println(minDistance);

        scanner.close();
    }
}
