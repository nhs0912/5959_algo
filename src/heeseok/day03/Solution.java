import java.util.*;
//         answer[0][0] = arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[1][0];
//         answer[1][0] = arr1[1][0] * arr2[0][0] + arr1[1][1] * arr2[1][0];
//         answer[2][0] = arr1[2][0] * arr2[0][0] + arr1[2][1] * arr2[1][0];
        
//         answer[0][1] = arr1[0][0] * arr2[0][1] + arr1[0][1] * arr2[1][1];
//         answer[1][1] = arr1[1][0] * arr2[0][1] + arr1[1][1] * arr2[1][1];
//         answer[2][1] = arr1[2][0] * arr2[0][1] + arr1[2][1] * arr2[1][1];        
//행렬의 곱셈
// https://school.programmers.co.kr/learn/courses/30/lessons/12949
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {        
        int arr1Height = arr1.length;
        int arr1Width = arr1[0].length;
        int arr2Height = arr2.length;
        int arr2Width = arr2[0].length;
        
        //결과값 행렬 생성
        int[][] answer = new int[arr1Height][arr2Width];                              
        
        //행렬 곱
        for(int width=0; width< arr2Width; width++) {            
            for(int height=0; height < arr1Height; height++) {
                for(int k = 0; k < arr1[0].length; k++){
                    answer[height][width] += arr1[height][k] * arr2[k][width];
                }                
            }
        }                                
        return answer;
    }
}
