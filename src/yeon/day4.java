package src.yeon;

import java.util.*;

public class day4 {

    public static void main(String[] args) {
        int[] arr = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        System.out.println(Arrays.toString(arr));
    }

    public static int[] solution(int N, int[] stages) {
        Map<Integer, Double> rate = getFailureRate(N, stages);

        return rate.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
    }

    private static Map<Integer, Double> getFailureRate(int N, int[] stages) {
        Map <Integer, Double> rate = new HashMap<>();

        for(int i = 1; i <= N; i++ ){
            int total = stages.length;
            int cnt   = 0;

            for(int stage : stages){
                if(stage < i){
                    total--;
                }
                if(stage == i){
                    cnt++;
                }
            }

            if(total == 0){
                rate.put(i, 0.0);
                continue;
            }

            rate.put(i, Double.valueOf(cnt)/Double.valueOf(total));
        }
        return rate;
    }
}
