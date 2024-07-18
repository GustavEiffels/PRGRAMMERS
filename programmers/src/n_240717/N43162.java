package n_240717;

import java.util.HashSet;

// ** https://school.programmers.co.kr/learn/courses/30/lessons/43162
public class N43162 {
    public static void main(String[] args) {
//        int n_1 = 3;
//        int[][] n_pcs = new int[][]{{1,1,0},{1,1,1},{0,1,1}};
//
//
//        int n_2 = 3;
//        int[][] n_pcs_2 = new int[][]{{1,1,0},{1,1,0},{0,0,1}};


        int[][] pc = {
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1}

        };

        int n = 4;

        N43162 m = new N43162();
        System.out.println(m.solution(n,pc));
    }

    public int[] record;
    public int cnt;

    public int[][] pcs;

    public HashSet<Integer> set;

    //  DFS 로 풀어보자
    public int solution(int n, int[][] computers) {
        cnt    = computers[0].length;
        record = new int[cnt];
        pcs    = computers;
        set    = new HashSet<>();

        for(int i = 0; i<cnt; i++){
            if(record[i] == 0){
                DFS(i);
                set.add(record[i]);
            }
        }

        if(true){
            if(record.length == 1){
                System.out.println("hui");
            }
            System.out.println("test");
        }

        return set.size();
    }

    public void DFS(int index){
        record[index] = index+1;
        // 연결되어 있는 것들 중 기록하지 않은 것
        for(int i = 0; i<cnt; i++){

            //  index 컴퓨터와 연결된 컴퓨터 i 지만 기록이 되지 않는 경우
            if( pcs[index][i] == 1  && record[i] == 0){
                DFS(i);
            }
        }
    }


}
