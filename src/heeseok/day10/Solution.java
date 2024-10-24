package src.heeseok.day11;
import java.util.*;


/*
크레인 인형뽑기 
https://school.programmers.co.kr/learn/courses/30/lessons/64061
*/
class Solution {    
    private static int[][] board;
    
    private int searchDoll(int width, int height) {
        for(int i=0; i< height; i++) {
            int searchedNumber = board[i][width];
            if(searchedNumber != 0){
                board[i][width] = 0;
                return searchedNumber;
            }
        }
        return 0;
    }
    
    private int exportDoll(int[] moves) {
        int answer = 0;
        int boardWidth = board[0].length;
        int boardHeight = board.length;
        Stack<Integer> basket = new Stack<>();
        for(int i=0; i< moves.length; i++){
            int exportDollNumber = moves[i] - 1;
            int searchedNumber = searchDoll(exportDollNumber, boardHeight);                                   
            
            if(searchedNumber == 0){
                continue;
            }else if(basket.isEmpty()){
                basket.push(searchedNumber);
            }else if(!basket.isEmpty() && basket.peek() == searchedNumber){                             
                basket.pop();
                answer+= 2;
            }else{
                basket.push(searchedNumber);                                        
            }                                   
        }                      
        return answer;
    }
    
    public int solution(int[][] board, int[] moves) {
        this.board = board;                                
        return exportDoll(moves);
    }
}
