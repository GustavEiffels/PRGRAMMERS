package level01.running;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */
public class Running_YOU_ONE {

    public static void main(String[] args) {
        String[] players  = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};


        Map<String,Integer> keyNameValRank = new HashMap<>();
        Map<Integer,String> keyRankValName = new HashMap<>();

        int playerCnt = players.length;
        String[] answer = new String[playerCnt];

        for(int i = 0; i<playerCnt; i++) {
            keyNameValRank.put(players[i],i);
            keyRankValName.put(i,players[i]);
        }

        for(String s : callings) {
            int calledRank = keyNameValRank.get(s);
            String otherName = keyRankValName.get(calledRank-1);

            // called
            keyRankValName.put(calledRank-1,s);
            keyNameValRank.put(s,calledRank-1);

            // other
            keyRankValName.put(calledRank,otherName);
            keyNameValRank.put(otherName,calledRank);

        }

        for(int i = 0; i<playerCnt; i++) {
            answer[i] = keyRankValName.get(i);
        }
    }
}
