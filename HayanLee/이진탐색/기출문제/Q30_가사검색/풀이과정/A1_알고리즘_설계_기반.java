/*
package HayanLee.이진탐색.기출문제.Q30_가사검색.풀이과정;

//오후 7시 9분 ~

*/
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
*//*

import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {

        //words와 queries의 길이 변수 선언
        int wL = words.length;
        int qL = queries.length;

        int[] answer = new int[queries.length];


        //이진탐색을 위한 정렬
        Arrays.sort(words);


        for(int i=0; i<qL; i++){
            int result = binarySearch(words, qL, start, end);
        }

        //와일드카드 설정
        for(int i=0; i<qL; i++){
            if (queries[i].charAt(0) == '?') {
                answer[i] = binarySearch(words, qL, start, end);;
            } else {
                return -1;
            }
        }

        return answer;
    }


    public int binarySearch(int[] words, int target, int start, int end){
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
    }

}*/
