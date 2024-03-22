package HayanLee.이진탐색.기출문제.Q30_가사검색.풀이과정.이진탐색사용X;

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

class A2_단순탐색 {
    public int[] solution(String[] words, String[] queries) {

        //words와 queries의 길이 변수 선언
        int wL = words.length;
        int qL = queries.length;

        int[] answer = new int[queries.length];


        //이진탐색을 위한 정렬
        Arrays.sort(words);


        for (int i = 0; i < qL; i++) {
            int count = 0;
            String query = queries[i];
            if (query.charAt(0) == '?') {
                // query가 ?로 시작하는 경우 뒤에서부터 탐색
                for (String word : words) {
                    if (word.length() == query.length() && matchSuffix(word, query))
                        count++;
                }
            } else {
                // query가 ?로 시작하지 않는 경우 앞에서부터 탐색
                for (String word : words) {
                    if (word.length() == query.length() && matchPrefix(word, query))
                        count++;
                }
            }
            // 해당 쿼리의 매칭된 단어 개수를 정답 배열에 저장
            answer[i] = count;
        }

        return answer;
    }


    /*public int binarySearch(int[] words, int target, int start, int end){
        while(start <= end){
            int middle = (start - end ) / 2;

            if(words[middle] == target){
                return middle;
            }
            if(words[middle] > target){
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }*/

    // 단어 앞부분
    public boolean matchPrefix(String word, String query) {
        for (int j = 0; j < word.length(); j++) {
            if (query.charAt(j) != '?' && query.charAt(j) != word.charAt(j))
                return false;
        }
        return true;
    }

    // 단어 뒷부분
    public boolean matchSuffix(String word, String query) {
        for (int j = 0; j < word.length(); j++) {
            if (query.charAt(query.length() - 1 - j) != '?' && query.charAt(query.length() - 1 - j) != word.charAt(word.length() - 1 - j))
                return false;
        }
        return true;
    }

}
