package level01.n159994;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();

        String[] card1_1 = new String[] { "i", "drink", "water" };
        String[] card2_1 = new String[] { "want", "to" };
        String[] goal_1  = new String[] { "i", "want", "to", "drink", "water" };

        System.out.println(m.solution(card1_1, card2_1, goal_1));
    }

    /**
     * 1 ≤ cards1의 길이, cards2의 길이 ≤ 10
     * 1 ≤ cards1[i]의 길이, cards2[i]의 길이 ≤ 10
     * cards1과 cards2에는 서로 다른 단어만 존재합니다.
     * 2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이
     * 1 ≤ goal[i]의 길이 ≤ 10
     * goal의 원소는 cards1과 cards2의 원소들로만 이루어져 있습니다.
     * cards1, cards2, goal의 문자열들은 모두 알파벳 소문자로만 이루어져 있습니다.
     * 
     */
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        // ** goal 이 순회하면서
        // ** 어느 queue 에 속해 있는지 알아야하고
        // ** 해당 queue 에서 가져올 단어가 맞는지 확인해야함

        String answer = "Yes";

        Queue<String> card1Queue = new LinkedList<>();
        Queue<String> card2Queue = new LinkedList<>();

        HashMap<String, Integer> searchQueue = new HashMap<>();

        for (String text : cards1) {
            card1Queue.offer(text);
            searchQueue.put(text, 1);
        }

        for (String text : cards2) {
            card2Queue.offer(text);
            searchQueue.put(text, 2);
        }

        for (String text : goal) {

            Queue<String> selectedQueue = (searchQueue.get(text) == 1) ? card1Queue : card2Queue;

            if (!selectedQueue.poll().equals(text)) {
                answer = "No";
                break;
            }
        }
        return answer;
    }
}
