package Greedy;

import java.util.*;

public class Mukbang_Live {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputArr = input.split(", ");
        int n = inputArr.length;
        int[] food_times = new int[n];

        // 각 음식의 먹는 시간
        for (int i = 0; i < n; i++) {
            food_times[i] = Integer.parseInt(inputArr[i]);
        }

        long k = scanner.nextLong();

        Mukbang_Live mukbangLive = new Mukbang_Live();
        int result = mukbangLive.solution(food_times, k);
        System.out.println(result);
    }

    public int solution(int[] food_times, long k) {
        PriorityQueue<Food> pq = new PriorityQueue<>();
        int n = food_times.length;
        long sum = 0;

        // 각 음식의 시간 정보
        for (int i = 0; i < n; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
            sum += food_times[i];
        }

        // 모든 음식을 먹는데 걸리는 총 시간이 k보다 작거나 같으면 음식을 모두 먹을 수 없음
        if (sum <= k) return -1;

        long prev = 0;
        long cycle = n;

        // 먹는 과정 반복하여 남은 시간 계산
        while (!pq.isEmpty()) {
            long timeToEat = (pq.peek().time - prev) * cycle;
            if (k >= timeToEat) {
                k -= timeToEat;
                prev = pq.poll().time;
                cycle--;
            } else {
                break;
            }
        }

        // 남은 시간을 이용하여 다음 먹을 음식의 인덱스 계산
        ArrayList<Food> list = new ArrayList<>(pq);
        Collections.sort(list, Comparator.comparingInt(o -> o.index));

        return list.get((int)(k % cycle)).index;
    }

    // 음식
    static class Food implements Comparable<Food> {
        int index;
        int time;

        public Food(int index, int time) {
            this.index = index;
            this.time = time;
        }

        // 시간을 기준으로 음식 비교
        public int compareTo(Food other) {
            return Integer.compare(this.time, other.time);
        }
    }
}
