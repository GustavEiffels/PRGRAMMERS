package n_12981;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        int n1 = 3;
        String[] word1 = new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        int n2 = 5;
        String[] word2 = new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};

        int n3 = 2;
        String[] word3 = new String[]{"hello", "one", "even", "never", "now", "world", "draw"};

        int n17 = 2;
        String[] word17 = new String[]{"tank", "kick", "kick", "know"};


        Main m = new Main();

//        for(int a : m.solution(n1,word1)){
//            System.out.println(a);
//        }
//        System.out.println();
//        for(int a : m.solution(n2,word2)){
//            System.out.println(a);
//        }
//        System.out.println();
//        for(int a : m.solution(n3,word3)){
//            System.out.println(a);
//        }
        System.out.println();
        for(int a : m.solution(n17,word17)){
            System.out.println(a);
        }
        System.out.println();

    }
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] person = new int[n]; person[0] = 1;
        HashMap<String,Boolean>     usedWord = new HashMap<>(); usedWord.put(words[0],true);
        int                          wordCnt = words.length;
        char                  beforeLastChar = words[0].charAt(words[0].length()-1);

        for(int i = 1; i<wordCnt; i++){
            person[i%n]       += 1;
            String currentWord = words[i];
            if( usedWord.containsKey(currentWord) || beforeLastChar != currentWord.charAt(0) ){
                answer[0] = i%n+1;
                answer[1] = person[i%n];
                break;
            }
            usedWord.put(currentWord,true);
            beforeLastChar = currentWord.charAt(currentWord.length()-1);
        }

        return answer;
    }

}
