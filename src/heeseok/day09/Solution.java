package src.heeseok.day09;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();
        int pricesSize = prices.length;
        int count = 0;
        for(int i=0; i<pricesSize - 1 ; i++) {            
            count = 0;
            int basePrice = prices[i];
            for(int j = i+1; j<pricesSize; j++) {
                count++;                
                if(basePrice > prices[j]) {
                    break;
                }             
            }
            answer.add(count);
        }
        answer.add(0);
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
