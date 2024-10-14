package src.heeseok.day08;

import java.util.*;
/*
 짝지어 제거하기
 https://school.programmers.co.kr/learn/courses/30/lessons/12973
*/
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        char[] alphabets = s.toCharArray();
        Stack<Character> basket = new Stack<>();
        
        for(char alphabet : alphabets) {
            if(basket.isEmpty()){
                basket.push(alphabet);
            }else{
                char topAlphabet = basket.peek();
                if(topAlphabet == alphabet) {
                    basket.pop();
                }else {
                    basket.push(alphabet);
                }
            }
        }                      
        return basket.isEmpty()? 1: 0;
    }
}
