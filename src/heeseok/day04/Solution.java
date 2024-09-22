import java.util.*;
import java.util.stream.*;
import java.math.BigDecimal;
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


class Solution {
    
    class Stage implements Comparable<Stage> {
        private int number;
        private double failRate;
        
        public Stage(int number, double failRate) {
            this.number= number;
            this.failRate = failRate;
        }
        
        public int getNumber() {
            return this.number;            
        }
        
        public double getFailRate() {
            return this.failRate;
        }                        
        
        @Override
        public int compareTo(Stage input) {
            return (this.getFailRate() > input.getFailRate())? -1 : (this.getFailRate() == input.getFailRate())? 0: 1;
        }
    }
    
    private boolean isFailStage(int processStageNumber, int currentStageNumber) {
        return processStageNumber <= currentStageNumber;
    }
    
    private double calculateFailRate(int failCount, int wholeStageCount) {
        return (double)failCount/(double)wholeStageCount;
    }
    
    public int[] solution(int N, int[] stages) {      
       int[] answer = new int[N];
       List<Integer> stageBasket = Arrays.stream(stages)
           .boxed()
           .collect(Collectors.toList());
       
       List<Stage> stageObjects = new ArrayList<>();
       int currentStageNumber = 0;
        
       while(N-- > 0) {
           int failCount = 0;
           currentStageNumber++;
           int currentStageSize = stageBasket.size();
           for(int i=0; i< stageBasket.size(); i++) {
               int wholeBasketSize = stageBasket.size();
               if(isFailStage(stageBasket.get(i), currentStageNumber)){
                   failCount++;
                   stageBasket.remove(i);//실패한 케이스 삭제                 
                   i--;
               }              
           }                      
           
           double failRate = calculateFailRate(failCount, currentStageSize);           
           stageObjects.add(new Stage(currentStageNumber, failRate));
       }
       Collections.sort(stageObjects);               
        
       int index = 0;
       for(Stage stage : stageObjects) {
           answer[index++] = stage.getNumber();           
       }
         
            
        return answer;
    }
}
