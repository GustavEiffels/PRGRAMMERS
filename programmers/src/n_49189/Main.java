package n_49189;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        int n = 6;
        int[][] ver = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(m.solution(n,ver));;
    }


    public int solution(int n, int[][] edge) {
        // 우선 그래프 부터 그리기
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        return BFS(graph,n);
    }

    public int BFS(List<List<Integer>> graph, int n) {
        int level = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] recording = new int[n + 1];
        Arrays.fill(recording, -1);
        recording[1] = 0;

        queue.offer(1);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            level++;

            for (int i = 0; i < currentSize; i++) {
                int currentNode = queue.poll();
                for (int neighbor : graph.get(currentNode)) {
                    if (recording[neighbor] == -1) { // 방문하지 않은 노드만 추가
                        recording[neighbor] = level;
                        queue.offer(neighbor);
                    }
                }
            }
        }

        int maxLevel = Arrays.stream(recording).max().orElse(0);
        long count = Arrays.stream(recording).filter(x -> x == maxLevel).count();

        return (int) count;
    }
}
