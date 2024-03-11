package Implementation;

import java.util.*;

public class WallInspection {
    static int minFriends;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        String[] weakStr = scanner.nextLine().replaceAll("[\\[\\]]", "").replaceAll("\\s+", "").split(","); // 취약 지점들
        String[] distStr = scanner.nextLine().replaceAll("[\\[\\]]", "").replaceAll("\\s+", "").split(","); // 친구들의 각 친구별 이동 가능 거리

        int[] weak = Arrays.stream(weakStr).mapToInt(Integer::parseInt).toArray();
        int[] dist = Arrays.stream(distStr).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(n, weak, dist));
    }

    public static int solution(int n, int[] weak, int[] dist) {
        minFriends = Integer.MAX_VALUE;
        int[] weakDistances = new int[weak.length + 1]; // 취약 지점의 개수보다 1 크게 생성
        for (int i = 0; i < weak.length - 1; i++) {
            weakDistances[i] = weak[i + 1] - weak[i]; // 각 취약 지점 간의 거리 계산
        }
        weakDistances[weak.length - 1] = n - weak[weak.length - 1] + weak[0]; // 마지막 취약 지점과 첫 번째 취약 지점 간의 거리 계산
        weakDistances[weak.length] = 0; // 추가된 마지막 취약 지점과 첫 번째 취약 지점 간의 거리를 0으로 설정

        List<Integer> distList = new ArrayList<>(); // 친구들의 이동 가능 거리 저장
        for (int d : dist) {
            distList.add(d);
        }

        permutation(weakDistances, distList, new boolean[dist.length], 0, 0);

        if (minFriends == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minFriends;
        }
    }

    public static void permutation(int[] weakDistances, List<Integer> distList, boolean[] visited, int count, int start) {
        if (count >= minFriends) return;

        if (start == weakDistances.length - 1) { // 모든 취약 지점을 검사한 경우
            minFriends = Math.min(minFriends, count);
            return;
        }

        for (int i = 0; i < distList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true; // 해당 친구가 현재 취약 지점 검사

                List<Integer> remainingDist = new ArrayList<>(distList);
                remainingDist.remove(i); // 해당 친구를 제외한 나머지 친구들의 이동 가능 거리

                int currentDist = 0;
                int nextStart = start + 1; // 다음 취약 지점으로 이동
                while (currentDist + weakDistances[nextStart] <= distList.get(i)) { // 해당 친구의 이동 가능 거리가 현재 취약 지점을 모두 검사할 수 있는 경우
                    currentDist += weakDistances[nextStart]; // 다음 취약 지점까지의 거리를 해당 친구의 이동 가능 거리에 더함
                    nextStart++;
                    if (nextStart == weakDistances.length - 1) { // 마지막 취약 지점을 넘어간 경우
                        minFriends = Math.min(minFriends, count + 1);
                        return;
                    }
                }

                permutation(weakDistances, remainingDist, visited, count + 1, nextStart);

                visited[i] = false;
            }
        }
    }
}