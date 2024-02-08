package level01.running;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Case3 {

    static class Node{

        int rank;
        String name;

        public Node(int rank , String name ){
            this.rank = rank;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        String[] players  = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        int playerCnt = players.length;
        String[] answer = new String[playerCnt];

        ArrayList<Node> nodeList = new ArrayList<>();
        HashMap<String, Node> nodeMap = new HashMap<>();

        for (int i = 0; i < playerCnt; i++) {
            Node node = new Node(i + 1, players[i]);
            nodeList.add(node);
            nodeMap.put(players[i], node);
        }

        for (String call : callings) {
            Node calledNode = nodeMap.get(call);
            int temp = calledNode.rank-1;
            Collections.sort(nodeList, Comparator.comparingInt(node -> node.rank));

            Node target = nodeMap.get(nodeList.get(temp-1).name);

            target.rank++;
            calledNode.rank = temp;
        }

        /**
         * 1. 이름 부른 사람 현재 몇 위인지 확인
         * 2. 이름 부른 사람의 이전 사람의 순위와 현재 사람 순위 값 변경
         * 다 변경하고 순위 순으로 이름 부르기
         */

        Collections.sort(nodeList, Comparator.comparingInt(node -> node.rank));
        for (int i = 0; i < playerCnt; i++) {
            answer[i] = nodeList.get(i).name;
        }

        for(String s : answer) {
            System.out.println(s);
        }
    }
}
