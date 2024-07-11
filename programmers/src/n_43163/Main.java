package n_43163;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        String      be_1 = "hit";
        String      ta_1 = "cog";
        String[]    wo_1 = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(m.solution(be_1, ta_1, wo_1));

    }


    public int solution(String begin, String target, String[] words) {
        HashMap<String,Boolean>   wordMap = new HashMap<>();
        for(String word: words) { wordMap.put(word, true); }

        if( !wordMap.containsKey( target ) ){
            return 0;
        }
        int answer = BFS(begin, target, wordMap);

        return answer;
    }

    public class Node{
        public String current;
        public HashMap<Character,Integer> currentMap;
        public HashMap<String,Boolean> hashMap;

        public Node(String current, HashMap<String,Boolean> hashMap){

            HashMap<Character,Integer> currentMap = new HashMap<>();
            for(char c : current.toCharArray() ){
                currentMap.put(c, currentMap.getOrDefault(c, 0)+1);
            }
            this.current    = current; 
            this.currentMap = currentMap; 
            this.hashMap    = hashMap;
        }
    }

    public int BFS(String begin, String target, HashMap<String,Boolean> wordMap){
        int level = 0;
        boolean isFind  = false;
        Queue<Node> queue = new LinkedList<>();
                    queue.offer(new Node(begin, wordMap));
        
        // ** queue 가 빈값이 될 때까지 
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            level++;

            for(int i = 0; i < queueSize; i++){
                Node currentNode = queue.poll();

                if(currentNode.current.equals(target)) {
                    // System.out.println("currentNode.current : "+currentNode.current);
                    // System.out.println("target : "+target);
                    isFind = true;
                    break;
                }
                else {
                    for(String otherWord : currentNode.hashMap.keySet() ){

                        HashMap<Character,Integer> currentMap = new HashMap<>(currentNode.currentMap);
                        // System.out.print("LEVEL - "+level+" CURRENT MAP - "+currentMap.toString()+" CURRENT - "+currentNode.current+" OTHER WORD - "+otherWord);
                        
                        for(char otherWordChar : otherWord.toCharArray() ){
                            if ( currentMap.containsKey(otherWordChar) ){
                                int newValue = currentMap.get(otherWordChar)-1;
                                currentMap.put(otherWordChar, newValue);
                                if(newValue == 0){
                                    currentMap.remove(otherWordChar);
                                }
                            }
                        }

                        int leftCnt     = 0;
                        int leftCharCnt = 0;

                        for(char c : currentMap.keySet()){
                            leftCnt++;
                            leftCharCnt += currentMap.get(c);
                        }

                        if(leftCharCnt == 1 && leftCnt == 1){
                            HashMap<String,Boolean> newHashMap = new HashMap<>(currentNode.hashMap);
                                                    newHashMap.remove(otherWord);
                                                    // System.out.print(" INERT "+otherWord);
                            queue.offer(new Node(otherWord, newHashMap));
                        }
                        System.out.println();
                    }
                }
            }
            if(isFind){
                break;
            }
        }

        if(isFind) return level-1;
        return 0;
    }
}
