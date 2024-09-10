import java.util.*;
//두개 뽑아서 더하기
// https://school.programmers.co.kr/learn/courses/30/lessons/68644

class Solution {
    public int[] solution(int[] numbers) {        
        List<Integer> result = new ArrayList<>();
        for(int i =0; i<numbers.length -1 ; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                result.add(numbers[i] + numbers[j]);
            }
        }
        
        return result.stream()
            .distinct()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
        
    }
}
