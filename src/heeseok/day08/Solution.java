package src.heeseok.day08;
import java.util.*;
/*
 짝지어 제거하기
 https://school.programmers.co.kr/learn/courses/30/lessons/12973
*/
class Solution
{
    private static final Stack<Character> basket = new Stack<>();
    public int solution(String s)
    {
        int answer = -1;
        char[] alphabets = s.toCharArray();        
        
        for(char alphabet : alphabets) {
            if(basket.isEmpty()){
                basket.push(alphabet);
                continue;
            }            
            
            if(!basket.isEmpty()){
                char topAlphabet = basket.peek();
                saveOrRemoveAlphabet(topAlphabet, alphabet);
            }
        }                      
        return basket.isEmpty()? 1: 0;
    }
    
    private void saveOrRemoveAlphabet(char topAlphabet, char currentAlphabet) {        
       if(topAlphabet == currentAlphabet){
         basket.pop();  
         return;
        }
        basket.push(currentAlphabet);        
    }
}
