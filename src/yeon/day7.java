package src.yeon;

import java.util.ArrayDeque;
import java.util.Stack;

public class day7 {
    /**
     * [문제명]
     * 괄호 회전하기
     * [링크]
     * https://school.programmers.co.kr/learn/courses/30/lessons/76502
     */
    public static void main(String[] args) {
        System.out.println(solution("[)(]"));
    }

    private static int solution(String s){
        int result = 0;

        ArrayDeque<Character> deque = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            deque.add(ch);
        }

        for(int i = 0; i < deque.size(); i++){
            if(checkBracket(deque)){
                result++;
            }
            deque.addFirst(deque.getLast());
            deque.removeLast();
        }

        return result;
    }

    private static boolean checkBracket(ArrayDeque<Character> s){
        Stack<Integer> stack = new Stack<>();

        for(char item : s){
            if ('(' == item){
                stack.push((int) ')');
                continue;
            }
            if ('{' == item){
                stack.push((int) '}');
                continue;
            }
            if ('[' == item){
                stack.push((int) ']');
                continue;
            }

            if (stack.empty()) {
                return false;
            }

            if ((int) item != stack.pop()){
                return false;
            }
        }

        return stack.empty();
    }
}
