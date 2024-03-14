package DFS_BFS;

import java.util.*;

public class ParenthesisConversion {
    public static void main(String[] args) {
        ParenthesisConversion solution = new ParenthesisConversion();
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String result = solution.convertParenthesis(input);
        System.out.println(result);
    }

    // 괄호 문자열을 올바른 형태로 변환
    public String convertParenthesis(String p) {
        // 입력된 문자열이 이미 올바른 경우 그대로 반환
        if (isCorrect(p)) {
            return p;
        }

        String u = "";
        String v = "";
        int openCount = 0;
        int closeCount = 0;
        int index = 0;

        // 균형잡힌 지점을 찾기
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                openCount++;
            } else {
                closeCount++;
            }
            if (openCount == closeCount) {
                index = i + 1;
                break;
            }
        }

        // 문자열을 u와 v로 나누가
        u = p.substring(0, index);
        v = p.substring(index);

        // u가 이미 올바른 경우, v를 재귀적으로 변환하고 이어붙이기
        if (isCorrect(u)) {
            return u + convertParenthesis(v);
        } else {
            // u가 올바르지 않은 경우, u를 수정하고 v를 재귀적으로 변환
            String temp = "(" + convertParenthesis(v) + ")";
            u = u.substring(1, u.length() - 1); // u의 바깥쪽 괄호 제거
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < u.length(); i++) {
                // u의 괄호 반전
                if (u.charAt(i) == '(') {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
            }
            // 수정된 u와 v를 결합하여 결과 반환
            return temp + sb.toString();
        }
    }

    // 괄호 문자열 검사
    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // '('인 경우 스택에 넣기
                stack.push(c);
            } else {
                // ')'인 경우, 스택이 비어있는지 확인
                // 비어있다면 올바르지 않은 문자열
                if (stack.isEmpty()) {
                    return false;
                }
                // 스택에서 '('를 꺼내기
                stack.pop();
            }
        }
        // 문자열을 모두 순회한 후에도 스택이 비어있다면 올바른 괄호 문자열
        return stack.isEmpty();
    }
}
