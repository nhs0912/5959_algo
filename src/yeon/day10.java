package src.yeon;

import java.util.Stack;

public class day10 {
    /**
     * [문제명]
     * 크레인 인형뽑기 게임
     * [링크]
     * https://school.programmers.co.kr/learn/courses/30/lessons/64061
     */
    public static void main(String[] args) {
        int[][] board   = new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves     = new int[] {1,5,3,5,1,2,1,4};

        System.out.println(solution(board,moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int n = board.length;
        int[] points = new int[n];

        Stack<Integer> stack = new Stack<>();

        int result = 0;

        for(int move : moves){
            int index = move - 1;
            for(int i = points[index]; i < n; i++){
                int tmp = board[i][index];

                if(tmp == 0){
                    continue;
                }

                if(!stack.empty()
                        && tmp == stack.peek()){
                    stack.pop();
                    points[index] = i + 1;
                    result++;
                    break;
                }

                stack.push(tmp);
                points[index] = i + 1;

                break;
            }
        }


        return result * 2;
    }

    public int solution2(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int item : moves){
            for(int i = 0; i < board.length; i++){

                int baseNbr = board[i][item-1];

                if(baseNbr == 0){
                    continue;
                }

                if(!stack.empty()
                        && stack.peek().equals(baseNbr)){
                    stack.pop();
                    answer += 2;
                }else{
                    stack.push(baseNbr);
                }

                board[i][item-1] = 0;

                break;
            }

        }

        return answer;
    }
}
