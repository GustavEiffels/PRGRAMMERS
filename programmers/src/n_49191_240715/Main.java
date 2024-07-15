package n_49191_240715;


import java.util.*;

// ** https://school.programmers.co.kr/learn/courses/30/lessons/49191
public class Main {

    public static void main(String[] args) {
        int n1 = 5;
        int[][] result_1 = {{4, 3},{4, 2},{3, 2},{1, 2},{2, 5}};

        Main m = new Main();
        System.out.println(m.solution(n1,result_1));;

    }

    public int[][] graph;
    public int     size;


    public int solution(int n, int[][] results) {
        graph = new int[n][n];
        size  = n;
        for(int i = 0; i<results.length; i++){
            int row = results[i][0]-1;
            int col = results[i][1]-1;
            graph[row][col] =  1;
            graph[col][row] = -1;
        }

        int answer = 0 ;

        for(int i = 0 ; i<n; i++){
            HashSet<Integer> higher = new HashSet<>();
            HashSet<Integer> lower  = new HashSet<>();
            int high = DFS(higher,i,1).size();
            int low  = DFS(lower,i,-1).size();

            if(high+low == n-1){
                answer++;
            }

        }
        return answer;
    }

    public Set<Integer> DFS(Set<Integer> set, int n, int upAndDown){
        for(int i = 0; i<size;i++){
            int currentInt = graph[n][i];
            if(currentInt == upAndDown && !set.contains(i)){
                set.add(i);
                DFS(set,i,upAndDown);
            }
        }
        return set;
    }

}
