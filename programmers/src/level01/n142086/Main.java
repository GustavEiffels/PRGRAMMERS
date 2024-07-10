package level01.n142086;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        for( int i : m.solution("banana") ){
            System.out.println(i);
        }
        for( int i : m.solution("foobar") ){
            System.out.println(i);
        }
    }

    public int[] solution(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();

        int[] answer = new int[s.length()];
        int i = 0;
        for( char c : s.toCharArray() ) {
            
            if(map.containsKey(c)) answer[i] = i - map.get(c); // ** 존재함 : 이미 나온 거
            else answer[i] = -1;                               // ** 존재안함 : 처음 
            map.put(c, i);
            i++;
        }
        return answer;
    }
}
 