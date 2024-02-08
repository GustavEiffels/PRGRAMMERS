package level01;

import java.util.HashMap;

public class Present2 {
    public static void main(String[] args) {
        String[] players  = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] answer   = new String[players.length];

        HashMap<String,Integer> rank = new HashMap<>();

        int i = 1;
        for(String s : players){
            rank.put(s,i);
            i++;
        }

        for(String s : callings){
            int lowRanking = rank.get(s);
            rank.put(s,lowRanking-1);
            for(String key: rank.keySet()) {
                if(!key.equals(s)&& rank.get(key) == lowRanking-1) {
                    rank.put(key,lowRanking);
                    break;
                }
            }
        }

        for(i = 1; i<=players.length; i++){
            for(String key : rank.keySet()) {
                if(rank.get(key) == i) {
                    answer[i-1] = key;
                }
            }
        }

    }
}
