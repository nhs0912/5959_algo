package src.yeon;

import java.util.HashSet;
import java.util.Set;

public class day5 {

    /**
     * [문제명]
     * 방문길이
     * [링크]
     * https://school.programmers.co.kr/learn/courses/30/lessons/49994?language=java
     */
    public static void main(String[] args) {
        System.out.println(solution("LULLLLLLU"));
    }

    public static int solution(String dirs) {

        int positionX = 0;
        int positionY = 0;

        String[] dir = dirs.split("");

        Set<String> answer = new HashSet<>();

        for (String s : dir) {
            int x = positionX;
            int y = positionY;

            if ("U".equals(s)) {
                x += 1;
            }
            if ("D".equals(s)) {
                x -= 1;
            }
            if ("R".equals(s)) {
                y += 1;
            }
            if ("L".equals(s)) {
                y -= 1;
            }

            if (Math.abs(x) <= 5
                    && Math.abs(y) <= 5) {

                answer.add(x + "/" + y + "/" + positionX + "/" + positionY);
                answer.add(positionX + "/" + positionY + "/" + x + "/" + y);

                positionX = x;
                positionY = y;
            }
        }

        return answer.size() / 2;
    }
}
