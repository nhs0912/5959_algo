package src.yeon;

import java.io.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class day1 {

    /**
     * [문제명]
     * 두 개 뽑아서 더하기
     * [링크]
     * https://school.programmers.co.kr/learn/courses/30/lessons/68644
     * [문제 설명]
     * 정수 배열 numbers가 주어집니다.
     * numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서
     * 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = st.countTokens();

        int[] request = new int[size];

        for(int i = 0; i < size; i++){
            request[i] = Integer.valueOf(st.nextToken());
        }

        int[] result = solution(request);

        System.out.print(Arrays.toString(result));
    }

    private static int[] solution(int[] numbers) {
        Set<Integer> answer = new HashSet<>();

        // 리스트 변환
        List<Integer> list = Arrays.stream(numbers)
                                    .boxed()
                                    .collect(Collectors.toList());

        // 두 수 더하기
        for(int i = 0; i < list.size(); i++){
            for(int j=i+1; j < list.size(); j++){
                int addNum = list.get(i) + list.get(j);

                answer.add(addNum);
            }
        }

        return convertToArray(answer);
    }

    private static int[] convertToArray(Set<Integer> setInt){

        int[] result = new int[setInt.size()];

        Iterator<Integer> iterator = setInt.stream()
                                            .iterator();

        for(int i=0; i < setInt.size(); i++){
            if(iterator.hasNext()){
                result[i] = iterator.next();
            }
        }

        return result;
    }
}
