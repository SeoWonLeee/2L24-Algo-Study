package HayanLee.구현.기출문제.Q14_외벽점검;

//오후 10시 15분 ~ 10시 51분
/*
알고리즘
- 외벽의 길이 n의 범위 내에서
  - dist 배열에 있는 이동거리를 내림차순 정렬(큰 수부터)
  - 큰 수부터 각각 weak 배열에 있는 취약 지점 외벽 점검을 진행하기
    - 점검 가능한 외벽 확인(순회)
    - 점검 불가능한 경우 -1 리턴
- 별도 메서드 : 현재 시작 지점에서 외벽을 점검가능 여부 체크, 점검한 취약 지점 개수 세기
*/

//오후 10시 15분 ~
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    static int n;
    static ArrayList<Integer> weakList;
    static int[] dist;
    static boolean[] visited;

    public int solution(int N, int[] weak, int[] dist) {
        n = N;
        weakList = new ArrayList<>();
        for (int w : weak) {
            weakList.add(w);
        }
        this.dist = dist;
        visited = new boolean[dist.length];

        int answer = Integer.MAX_VALUE;

        // 이동 거리 내림차순 정렬
        Arrays.sort(dist);

        for (int i = 0; i < weak.length; i++) {
            // 취약 지점을 원형으로 생각하여 시작 지점 변경
            int[] circularWeak = new int[weak.length * 2];
            for (int j = 0; j < weak.length; j++) {
                circularWeak[j] = weak[j] + n;
                circularWeak[j + weak.length] = weak[j];
            }

            // 외벽을 순회하며 각 시작점에 대해 점검 가능한지 확인
            for (int j = i; j < i + weak.length; j++) {
                int start = circularWeak[j];

                // 외벽 점검 진행
                if (check(start)) {
                    answer = Math.min(answer, countVisited());
                }
            }
        }

        // 점검이 불가능한 경우 -1 반환
        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }

    // 현재 시작 지점에서 외벽을 점검할 수 있는지 확인하는 메소드
    private boolean check(int start) {
        for (int i = 0; i < dist.length; i++) {
            int curDist = dist[i];

            // 이동 가능한 거리만큼 반복하며 점검 가능한지 확인
            for (int j = start; j < start + curDist; j++) {
                if (!weakList.contains(j % n)) {
                    weakList.remove(Integer.valueOf(j % n));
                }
            }
            visited[i] = true;

            // 모든 취약 지점을 점검할 수 있는 경우 true 반환
            if (weakList.isEmpty()) {
                return true;
            }

            // 취약 지점을 초기화하고 다음 이동 거리에 대해 점검 진행
            weakList.clear();
            for (int w : weakList) {
                weakList.add(w);
            }
            visited[i] = false;
        }

        // 모든 이동 거리에 대해 점검이 불가능한 경우 false 반환
        return false;
    }

    // 점검한 취약 지점 개수를 세는 메소드
    private int countVisited() {
        int count = 0;
        for (boolean v : visited) {
            if (v) {
                count++;
            }
        }
        return count;
    }
}
