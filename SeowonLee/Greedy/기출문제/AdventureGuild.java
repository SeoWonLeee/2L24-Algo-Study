package Greedy;

import java.util.*;

public class AdventureGuild {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 모험가의 수
        int n = scanner.nextInt();

        // 각 모험가의 공포도 리스트
        List<Integer> fearLevels = new ArrayList<>();

        // 각 모험가의 공포도
        for (int i = 0; i < n; i++) {
            int fearLevel = scanner.nextInt();
            fearLevels.add(fearLevel);
        }

        // 공포도 오름차순으로 정렬
        Collections.sort(fearLevels);

        int groupCount = 0;
        int memberCount = 0;

        // 각 모험가의 공포도 그룹 구성
        for (int fearLevel : fearLevels) {
            memberCount++; // 모험가 한 명을 그룹에 포함

            // 현재 그룹에 포함된 (모험가 ≥ 공포도) 그룹 구성
            if (memberCount >= fearLevel) {
                groupCount++;
                memberCount = 0;
            }
        }

        System.out.println(groupCount);
    }
}

