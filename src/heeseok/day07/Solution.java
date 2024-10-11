package src.heeseok;

import java.util.*;

// 괄호 회전하기 
// https://school.programmers.co.kr/learn/courses/30/lessons/76502#

class Solution {
    
    private boolean checkValidBrackets(List<Character> bracketBasket) {
        Stack<Character> stack = new Stack<>();
        for(char bracket : bracketBasket) {
            if('(' == bracket || '[' == bracket || '{' == bracket){
                stack.push(bracket);
            }
            
            if(')' == bracket || ']' == bracket || '}' == bracket){
                if(stack.isEmpty()) {
                    return false;
                }
                char popBracket = stack.pop();
                if(')' == bracket && popBracket != '(') {
                    return false;
                }
                
                if(']' == bracket && popBracket != '[') {
                    return false;
                }
                
                if('}' == bracket && popBracket != '{') {
                    return false;
                }        
            }
        }       
        return true;
    }        
    
    private List<Character> changeList(String s) {
        char[] bracketBasket = s.toCharArray();
        List<Character> brackets = new LinkedList<>();
        for(char bracket : bracketBasket) {
            brackets.add(bracket);
        }
        return brackets;
    }
    
    public int solution(String s) {
        int answer = 0;                                        
        List<Character> brackets = changeList(s);
        int bracketSize = brackets.size();                
        
        if(bracketSize <= 1 || bracketSize % 2 == 1) {
            return 0;
        }
        
        for(int i=0; i< bracketSize; i++) {
            char first = brackets.remove(0);
            brackets.add(first);
            if(checkValidBrackets(brackets)){
                answer++;
            }            
        }                        
        return answer;
    }
}
