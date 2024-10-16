package src.yeon;

import java.util.Arrays;

public class day9 {

    /**
     * [문제명]
     * 주식가격
     * [링크]
     * https://school.programmers.co.kr/learn/courses/30/lessons/42584
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 2, 3})));
    }

    public static int[] solution(int[] prices){

        int pricesSize = prices.length;

        int[] result = new int[pricesSize];

        for(int i=0; i < pricesSize; i++){
            int target = prices[i];

            for(int j = i + 1; j < pricesSize; j++){
                result[i] += 1;
                if(target > prices[j]){
                    break;
                }
            }
        }

        return result;
    }
}
