package HayanLee.이진탐색.기출문제.Q30_가사검색.풀이과정.이진탐색사용;

//오후 7시 9분 ~

/*
[알고리즘]
1. words 배열과 queries 배열을 비교
   - 이진 탐색을 위해 정렬하기
   - 매치되는 개수를 출력하기(answer)
2. 이진 탐색 구현하기(별도 메서드)
   - words 배열 : 2개 이상
   - queries 배열 : 2개 이상
   - 중복 제거(중복 시 1개로 통합)
   - 와일드 카드 문자 ?만 포함 가능하도록
3. 단어 앞부분 검사(와일드 카드가 앞에 올 경우)
4. 단어 뒷부분 검사(와일드 카드가 뒤에 올 경우)
*/
import java.util.*;

class A3_BinaryFail {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        // words를 길이별로 정렬
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (query.charAt(0) == '?') {
                // 뒤에 있는 와일드카드가 접미사를 의미하므로 단어를 뒤집어 비교
                answer[i] = countMatchingWords(reverse(query), words);
            } else {
                answer[i] = countMatchingWords(query, words);
            }
        }

        return answer;
    }

    // 이진 탐색을 사용하여 단어와 매치되는 개수를 찾음
    private int countMatchingWords(String query, String[] words) {
        int left = findLeftMostIndex(query, words);
        int right = findRightMostIndex(query, words);
        return right - left;
    }

    // 왼쪽에서 가장 먼저 나오는 단어의 인덱스를 찾음
    private int findLeftMostIndex(String query, String[] words) {
        int left = 0;
        int right = words.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isMatching(query, words[mid])) {
                right = mid;
            } else if (words[mid].compareTo(query) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 오른쪽에서 가장 먼저 나오는 단어의 인덱스를 찾음
    private int findRightMostIndex(String query, String[] words) {
        int left = 0;
        int right = words.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isMatching(query, words[mid])) {
                left = mid + 1;
            } else if (words[mid].compareTo(query) <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 문자열을 뒤집음
    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // 쿼리와 단어가 매치되는지 확인
    private boolean isMatching(String query, String word) {
        if (query.length() != word.length())
            return false;

        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) != '?' && query.charAt(i) != word.charAt(i))
                return false;
        }
        return true;
    }
}