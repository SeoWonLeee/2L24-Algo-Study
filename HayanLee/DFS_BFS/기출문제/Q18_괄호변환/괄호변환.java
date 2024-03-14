package HayanLee.DFS_BFS.기출문제.Q18_괄호변환;

class Solution {
    public String solution(String p) {
        String answer;
        if(check(p)) return p;
        answer = split(p);
        return answer;
    }

    //"올바른 괄호 문자열"인지 확인하는 메서드
    public static boolean check(String string){
        int first = 0;
        if(string.charAt(0) == ')'){
            return false;
        }
        for(int i=0; i<string.length(); i++){
            if(string.charAt(i) == '('){
                first++;
            } else {
                first--;
            }
        }
        return true;
    }

    // "균형잡힌 괄호 문자열" -> "올바른 괄호 문자열" 변환하는 메서드
    public static String split(String w){
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        if(w.length() == 0){
            return "";
        }

        int first = 0;
        for(int i=0; i<w.length(); i++){
            if(w.charAt(i) == '('){
                first++;
            } else {
                first--;
            }

            if(first == 0){
                u.append(w.substring(0,i+1));
                v.append(w.substring(i+1,w.length()));
                if(check(u.toString())){
                    u.append(split(v.toString()));
                }else{
                    StringBuilder str = new StringBuilder();
                    str.append("(");
                    str.append(split(v.toString()));
                    str.append(")");
                    str.append(reverse(u.toString()));
                    return str.toString();
                }
                break;
            }
        }
        return u.toString();
    }
    //u를 변환하는 메서드
    public static String reverse(String str){
        StringBuilder string = new StringBuilder();

        for(int i=1; i<str.length()-1; i++){
            if(str.charAt(i) == '(') {
                string.append(")");
            } else {
                string.append("(");
            }
            return string.toString();
        }
    }
}
