package src.yeon;

import java.util.Arrays;

public class day3 {

    /**
     * [문제명]
     * 행렬의 곱셉
     * [링크]
     * https://school.programmers.co.kr/learn/courses/30/lessons/12949
     * [문제 설명]
     * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
     */
    public static void main(String[] args) {

        int[][] arr1 = {{2,3,2},{4,2,4},{3,1,4}};
        int[][] arr2 = {{5,4,3},{2,4,1},{3,1,1}};

        int[][] result = solution(arr1, arr2);

        for(int[] arr : result){

            System.out.print(Arrays.toString(arr));
        }
    }

    private static int[][] solution(int[][] arr1, int[][] arr2) {

        int row = arr1.length;
        int col = arr2[0].length;
        int n = arr2.length;

        int[][] result = new int[row][col];

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < row; j++){
                for(int k = 0; k < col; k++){
                    result[j][k] += arr1[j][i] * arr2[i][k];
                }
            }
        }

        return result;
    }

}
