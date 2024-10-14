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

        for(char c : s.toCharArray()){
            if(chars.empty()){
                chars.add(c);
                continue;
            }

            if(c == chars.lastElement()){
                chars.pop();
                continue;
            }

            chars.add(c);
        }

        return chars.isEmpty() ? 1 : 0;
    }

}
