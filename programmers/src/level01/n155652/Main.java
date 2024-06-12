package level01.n155652;

import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/155652
 * 두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 
 * 암호의 규칙은 다음과 같습니다.
 * 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
 * index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
 * skip에 있는 알파벳은 제외하고 건너뜁니다.
 * 예를 들어 s = "aukks", skip = "wbqd", index = 5일 때, a에서 5만큼 뒤에 있는 알파벳은 
 * f지만 [b, c, d, e, f]에서 'b'와 'd'는 skip에 포함되므로 세지 않습니다. 따라서 'b', 'd'를 제외하고 
 * 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다. 나머지 "ukks" 
 * 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.
 * 
 * 두 문자열 s와 skip, 그리고 자연수 index가 매개변수로 주어질 때 위 규칙대로 s를 변환한 결과를 return하도록 solution 함수를 완성해주세요.
 */
public class Main {

    public static void main(String[] args) {


        int a = 97;
        int z = 122;
        char charA = 'a';
        char charZ = 'z';
        System.err.println((char)a);
        System.err.println((char)z);
        System.err.println((int)charA);
        System.err.println((int)charZ);

        Main m = new Main();
        System.err.println(m.solution("aukks", "wbqd", 5));
        System.err.println(m.solution("bcdefghijklmnopqrstuvwxyz", "a", 1));
        
    }


    public String solution(String s, String skip, int index) {

        //** 0.Stringbuilder 를 사용하여 문자 추가 
        StringBuilder answer = new StringBuilder();
        
        //** 1. Skip 을 위한 skip map을 생성 - key 를 숫자로
        HashMap<Integer,Boolean> skipHashMap = new HashMap<>();

        // ** 2. Skip Map 할당 
        for(char skipChar : skip.toCharArray() ){

            // ** 2-1. skip 할 char 를 int 로 변환 
            skipHashMap.put((int)skipChar, true);
        }

        //** 3. 문자열을 받음 -> skip 범위에 처음 문자는 포함 되지 않음  
        for(char ecodeChar : s.toCharArray() ){

            // ** 암호화된 문자를 숫자로 변경 
            int encodeCharIndex = (int)ecodeChar;
            
            // ** index 만큼 증감했는지 확인 
            int     inCreaseCnt     = 0;

            //**  복호화된 문자의 숫자를 저장하기 위한 index 
            int     decodeCharIndex = encodeCharIndex;

            //** index 만큼 증감 시키기 전까지 숫자 하나씩 조회 
            while(inCreaseCnt<index) {

                // ** 먼저 숫자를 하나 증가 
                decodeCharIndex++;

                // ** 증가된 숫자가 z 의 int 번호보다 1개 더 많으면 a 로 변경 
                if(decodeCharIndex==123){
                    decodeCharIndex = 97;
                }
                // ** 증가된 숫자가 제외할 숫자에 포함되어 있는지 확인 
                if(!skipHashMap.containsKey(decodeCharIndex)){
                    // ** 포함되어 있지 않으면 정상적으로 증가 했음으로 증가
                    inCreaseCnt++;
                }
            }
            // ** 반복문이 증가후 변수에 저장 
            answer.append((char)decodeCharIndex);
        }
        
        return answer.toString();
    }
}
