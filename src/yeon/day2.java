package src.yeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class day2 {
    /**
     * [문제명]
     * 모의고사
     * [링크]
     * https://school.programmers.co.kr/learn/courses/30/lessons/42840
     * [문제 설명]
     * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
     * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
     * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
     * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
     * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = st.countTokens();

        int[] request = new int[size];

        for(int i = 0; i < size; i++){
            request[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(request);

        System.out.print(Arrays.toString(result));
    }

    private static int[] solution(int[] answers) {

        Map<Integer, Integer> m = new HashMap<>();

        int[] studentA = {1, 2, 3, 4, 5};
        int[] studentB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] studentC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i = 0; i < answers.length; i++){
            if(studentA[i%5] == answers[i]){
                m.put(1, m.getOrDefault(1, 0) + 1);
            }
            if(studentB[i%8] == answers[i]){
                m.put(2, m.getOrDefault(2, 0) + 1);
            }
            if(studentC[i%10] == answers[i]){
                m.put(3, m.getOrDefault(3, 0) + 1);
            }
        }

        List<Integer> keys = new ArrayList<>(m.keySet()
                                                .stream()
                                                .sorted((o1, o2) -> m.get(o2).compareTo(m.get(o1)))
                                                .toList());

        int num = 0;

        for(Integer key : keys){
            if(num <= m.get(key)){
                num = m.get(key);
            }
            else{
                keys.remove(key);
            }

        }

        return keys.stream().sorted().mapToInt(Integer::intValue).toArray();

    }

}
