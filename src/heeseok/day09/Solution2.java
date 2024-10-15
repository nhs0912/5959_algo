package src.heeseok.day09;
/*
주식가격 
*/  
import java.util.*;
class Solution2 {        
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        int pricesSize = prices.length; 
        
         for(int i = 0; i < pricesSize; i++) {           
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {                
                int popIndex = stack.pop();                
                answer[popIndex] = i - popIndex;                
                continue;
            }
            stack.push(i);                                                
         }
        while(!stack.isEmpty()){
            int popIndex = stack.pop();
            answer[popIndex] = (pricesSize - 1 - popIndex);
        }
        
        return answer;
    }
}
