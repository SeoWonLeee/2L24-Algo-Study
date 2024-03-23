package Binary_Search;

import java.util.*;

public class LyricsSearch {

    // lowerBound: arr에서 target 이상인 첫 번째 원소의 인덱스
    public static int lowerBound(ArrayList<String> arr, String target) {
        int start = 0;
        int end = arr.size();

        // 이진 탐색을 통해 lower bound를 찾는 과정
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr.get(mid).compareTo(target) >= 0) // 중간 값이 target 이상이면
                end = mid; // 종료 인덱스를 중간 인덱스로 설정하여 왼쪽 부분 탐색
            else
                start = mid + 1;
        }
        return end;
    }

    // upperBound: arr에서 target 초과인 첫 번째 원소의 인덱스
    public static int upperBound(ArrayList<String> arr, String target) {
        int start = 0;
        int end = arr.size();

        // 이진 탐색을 통해 upper bound를 찾는 과정
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr.get(mid).compareTo(target) > 0) // 중간 값이 target 초과이면
                end = mid; // 종료 인덱스를 중간 인덱스로 설정하여 왼쪽 부분 탐색
            else
                start = mid + 1;
        }
        return end;
    }

    // countByRange: arr에서 leftValue 이상 rightValue 미만인 원소의 개수를 반환
    public static int countByRange(ArrayList<String> arr, String leftValue, String rightValue) {
        int rightIndex = upperBound(arr, rightValue); // rightValue 초과인 첫 번째 원소의 인덱스
        int leftIndex = lowerBound(arr, leftValue); // leftValue 이상인 첫 번째 원소의 인덱스
        return rightIndex - leftIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordsInput = scanner.nextLine().replaceAll("\\s+","");
        String[] words = wordsInput.split(",");

        String queriesInput = scanner.nextLine().replaceAll("\\s+","");
        String[] queries = queriesInput.split(",");

        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> reversedArr = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < 10001; i++) {
            arr.add(new ArrayList<String>());
            reversedArr.add(new ArrayList<String>());
        }

        // 각 단어를 단어 길이에 맞는 리스트에 저장
        for (int i = 0; i < words.length; i++) {
            String word = words[i].replaceAll("[^a-z]", "");  // 영문자가 아닌 문자 제거
            arr.get(word.length()).add(word); // 단어를 길이에 맞는 리스트에 추가
            word = (new StringBuilder(word)).reverse().toString();
            reversedArr.get(word.length()).add(word); // 뒤집은 단어를 길이에 맞는 리스트에 추가
        }

        // 각 리스트를 사전순으로 정렬
        for (int i = 0; i < 10001; i++) {
            Collections.sort(arr.get(i)); // 각 길이의 리스트를 사전순으로 정렬
            Collections.sort(reversedArr.get(i)); // 각 길이의 뒤집은 리스트를 사전순으로 정렬
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i].replaceAll("[^a-z?]", ""); // 영문자와 '?'를 제외한 문자 제거
            int res = 0;
            if (q.charAt(0) != '?') {
                // '?'가 접두사가 아닌 경우
                res = countByRange(arr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
            }
            else {
                // '?'가 접두사인 경우
                q = (new StringBuilder(q)).reverse().toString();
                res = countByRange(reversedArr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
            }
            ans.add(res);
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        System.out.println(Arrays.toString(answer));
    }
}
