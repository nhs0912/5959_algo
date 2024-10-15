package src.yeon;

import java.util.Stack;

public class day8 {
    /**
     * [문제명]
     * 짝지어 제거하기
     * [링크]
     * https://school.programmers.co.kr/learn/courses/30/lessons/12973
     */

    public static void main(String[] args) {
        System.out.println(solution("abbab"));
    }

    public static int solution(String s){
        Stack<Character> chars = new Stack<>();

        for(char alphabet : s.toCharArray()){
            if(chars.empty()){
                chars.push(alphabet);
                continue;
            }

            if(alphabet == chars.peek()){
                chars.pop();
                continue;
            }

            chars.push(alphabet);
        }

        return chars.isEmpty() ? 1 : 0;
    }

}
