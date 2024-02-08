package level01;


/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */
public class Running {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};


        int playerCnt   = players.length;

        for(String runner : callings) {
            for(int i = 0; i<playerCnt; i++ ){
                if(runner == players[i]) {
                    if(i>0) {
                        String temp = players[i];
                        players[i] = players[i-1];
                        players[i-1] = temp;

                        System.out.println();
                    }
                }
            }
        }
        for(int i = 0; i<players.length; i++) {
            System.out.println(players[i]);
        }

    }
}
