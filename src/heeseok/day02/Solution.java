import java.util.*;
//Day02 모의고사
// https://school.programmers.co.kr/learn/courses/30/lessons/42840

class Solution {
  
    private int[] firstAnswers = new int[]{1,2,3,4,5};
    private int[] secondAnswers = new int[]{2,1,2,3,2,4,2,5};
    private int[] thirdAnswers = new int[]{3,3,1,1,2,2,4,4,5,5};
    private int[] correctAnswers;    
    
    public int[] solution(int[] answers) {
        correctAnswers = answers;        
        int firstResult = checkCorrectCount(firstAnswers);        
        int secondResult = checkCorrectCount(secondAnswers);        
        int thirdResult = checkCorrectCount(thirdAnswers);                
        //가장 큰 수 구하기
        int bigScore = calculateBigScore(firstResult, secondResult, thirdResult);                       
        //가장 많이 맞춘 명수 구하고 정렬
        return calculateWinner(bigScore, firstResult, secondResult, thirdResult);
    }
    
    private int[] calculateWinner(int bigScore, int first, int second, int third) {
        List<Integer> result = new ArrayList<>();
        if(first == bigScore) {
            result.add(1);
        }
        
        if(second == bigScore) {
            result.add(2);
        }
        
        if(third == bigScore) {
            result.add(3);
        }
        
       return result.stream()
           .mapToInt(Integer::intValue)
           .sorted()
           .toArray();
    }    
    
    private int calculateBigScore(int first, int second, int third) {
        return Math.max(Math.max(first,second), third);
    }
    
    private int checkCorrectCount(int[] answers) {        
        int correctAnswersCount = 0;        
        
        for(int i=0; i< correctAnswers.length; i++ ) {                       
            if(correctAnswers[i] == answers[i % answers.length]){
                correctAnswersCount++;
            }
        }
        return correctAnswersCount;
    }
    
}
