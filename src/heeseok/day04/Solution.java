//문제 : 실패율 
// https://school.programmers.co.kr/learn/courses/30/lessons/42889
/*
[개발 프로세스]
1) 도전중인 스테이지에 대한 판단 
    - N보다 작거나 같으면 실패
    - N보다 크면 성공
2) 스테이지에서 실패한 케이스를 제거
3) 실패율 구하기
4) 실패율을 객체 Stage에 정보를 입력한다. 
5) Stage 정렬을 한다.
 - 실패율이 높은 스테이지부터 내림차순 
 - 실패율이 같을 경우 오름차순으로 정렬
 */

import java.util.*;
import java.util.HashMap;


class Solution {
    public int[] solution(int N, int[] stages) {
        int[] challenger = new int[N + 2]; //stage별로 도전자 수 저장 
        for(int i=0; i< stages.length; i++){
            challenger[stages[i]] +=1;
        }
        
        Map<Integer, Double> failStages = new HashMap<>();
        
        double stageSize = stages.length;
        
        int index = 1;
        while(N--> 0) {
            if(challenger[index] == 0) {
                failStages.put(index, 0.);
            } else{
                failStages.put(index, challenger[index] / stageSize);
                stageSize -= challenger[index];
            }
            index++;
        }
        return failStages.entrySet()
            .stream()
            .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey)
            .toArray();
    }
}
