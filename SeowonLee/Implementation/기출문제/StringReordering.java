package Implementation;

import java.util.*;

public class StringReordering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Character> characters = new ArrayList<>();
        int sum = 0;

        // 입력 문자열 알파벳과 숫자를 분리
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isAlphabetic(c)) {
                characters.add(c);
            } else if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c); // 문자를 숫자로 변환하여 더함
            }
        }

        Collections.sort(characters); // 알파벳 오름차순으로 정렬

        StringBuilder result = new StringBuilder();

        // 정렬된 알파벳을 결과 문자열에 추가
        for (int i = 0; i < characters.size(); i++) {
            result.append(characters.get(i));
        }

        // 숫자를 결과 문자열에 추가
        result.append(sum);

        System.out.println(result.toString());
    }
}
