package n_43164_240715;

import java.util.*;

// ** https://school.programmers.co.kr/learn/courses/30/lessons/43164
public class Main {
    public static void main(String[] args) {
        String[][] ticket1 = new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] ticket2 = new String[][]{        {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        Main m = new Main();
//        m.solution(ticket1);
        m.solution(ticket2);

    }


    public String[] solution(String[][] tickets) {

        Map<String,PriorityQueue<String>> graph = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for(String[] ticket:tickets){
            graph.putIfAbsent(ticket[0],new PriorityQueue<>());
            graph.get(ticket[0]).offer(ticket[1]);
        }

        Stack<String> stack = new Stack<>();
        stack.push("ICN");
        while (!stack.isEmpty()) {
            String from = stack.peek();
            // 그래프에 from 이 존재하며 graph
            if (graph.containsKey(from) && !graph.get(from).isEmpty()) {
                stack.push(graph.get(from).poll());
            } else {
                answer.add(stack.pop());
            }
        }
        Collections.reverse(answer);
        return answer.toArray(new String[0]);
    }
}
