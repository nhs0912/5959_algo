class Solution {
    boolean solution(String s) {        
       boolean answer = false;

        // String s = args[0];
        int strtCnt = 0;
        int endCnt = 0;

        for( int i = 0; i < s.length(); i++ ) {
            char temp = s.charAt(i);
            
            if( '(' == temp ) {
                strtCnt++;
            } else {
                endCnt++;
            }

            if( strtCnt < endCnt )  {
                answer = false;
                break; 
            }
        }

        if( strtCnt == endCnt ) {
            answer = true;
        }

        System.out.println("result=" + answer);
        return answer;
    }
}
