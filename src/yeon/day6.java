package src.yeon;

import java.util.Stack;

public class day6 {

    /**
     * [문제명]
     * 올바른 괄호
     * [링크]
     * https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java
     */
    public static void main(String[] args) {
        System.out.println(solution("(())())"));
    }

    private static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(char item : s.toCharArray()){
            if('(' == item){
                stack.push(item);
                continue;
            }

            if (stack.empty()) {
                answer = false;
                break;
            }
            stack.pop();
        }

        return stack.empty() && answer;
    }
}
