package Implementation;

import java.util.Scanner;

public class StringCompression {
    public int solution(String s) {
        int answer = s.length(); // 초기값 문자열의 길이로 설정

        // 압축할 단위를 1부터 문자열 길이의 절반까지 순회
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder compressed = new StringBuilder(); // 압축된 문자열 저장 StringBuilder
            String prev = s.substring(0, i); // 이전에 비교한 문자열
            int count = 1; // 현재 문자열의 개수

            // 문자열을 압축 단위로 비교하여 압축
            for (int j = i; j <= s.length() - i; j += i) {
                String sub = s.substring(j, j + i);

                // 이전 문자열과 같으면 count 증가
                if (prev.equals(sub)) {
                    count++;
                } else {
                    // 이전 문자열과 다르면 압축된 문자열 생성
                    if (count > 1) {
                        compressed.append(count); // 압축된 문자열의 개수 추가
                    }
                    compressed.append(prev); // 압축된 문자열의 값 추가
                    prev = sub;
                    count = 1;
                }
            }

            // 마지막으로 비교된 문자열을 압축된 문자열에 추가
            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);

            // 압축 단위로 나누어 떨어지지 않는 경우, 남은 문자열 추가
            compressed.append(s.substring((s.length() / i) * i));

            // 가장 짧은 압축 결과 선택
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        StringCompression solution = new StringCompression();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(solution.solution(s));
    }
}
