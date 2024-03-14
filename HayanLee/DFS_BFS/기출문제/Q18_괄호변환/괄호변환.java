package HayanLee.DFS_BFS.기출문제.Q18_괄호변환;

class Solution {
    public String solution(String p) {
        // 주어진 문자열이 이미 올바른 괄호 문자열인지 확인
        if (check(p)) return p;
        // 주어진 문자열이 올바른 괄호 문자열이 아닌 경우 분할하여 처리
        return split(p);
    }

    // "올바른 괄호 문자열"인지 확인하는 메서드
    public static boolean check(String string) {
        int count = 0; // 괄호의 개수를 세는 변수
        // 문자열을 순회하면서 괄호의 짝이 맞는지 확인
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                count++; // 열린 괄호인 경우 count 증가
            } else {
                count--; // 닫힌 괄호인 경우 count 감소
                // 닫힌 괄호가 더 많은 경우는 항상 올바른 괄호 문자열이 아님
                if (count < 0) return false;
            }
        }
        // 모든 문자열을 순회한 후에도 count가 0이면 올바른 괄호 문자열
        return count == 0;
    }

    // "균형잡힌 괄호 문자열" -> "올바른 괄호 문자열" 변환하는 메서드
    public static String split(String w) {
        if (w.isEmpty()) return ""; // 빈 문자열인 경우 처리

        int count = 0; // 괄호의 개수를 세는 변수
        int index = 0; // 균형잡힌 괄호 문자열의 종료지점을 저장하는 변수
        // 균형잡힌 괄호 문자열의 종료지점을 찾는 과정
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                count++; // 열린 괄호인 경우 count 증가
            } else {
                count--; // 닫힌 괄호인 경우 count 감소
            }
            // 열린 괄호와 닫힌 괄호의 개수가 같아지는 지점을 찾음
            if (count == 0) {
                index = i;
                break;
            }
        }

        String u = w.substring(0, index + 1); // 균형잡힌 괄호 문자열 u
        String v = w.substring(index + 1); // 나머지 문자열 v

        // u가 올바른 괄호 문자열인지 확인하고 처리
        if (check(u)) {
            return u + split(v); // u가 올바른 괄호 문자열인 경우, v에 대해 재귀 호출
        } else {
            // u가 올바른 괄호 문자열이 아닌 경우, u를 변환하고 v에 대해 재귀 호출
            StringBuilder sb = new StringBuilder("(");
            sb.append(split(v));
            sb.append(")");
            sb.append(reverse(u.substring(1, u.length() - 1)));
            return sb.toString();
        }
    }

    // u를 변환하는 메서드
    public static String reverse(String str) {
        StringBuilder reversed = new StringBuilder();
        // 괄호를 역순으로 변환
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                reversed.append(')');
            } else {
                reversed.append('(');
            }
        }
        return reversed.toString(); // 변환된 문자열 반환
    }
}
