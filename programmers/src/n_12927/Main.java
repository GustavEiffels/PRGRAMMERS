package n_12927;

// 야근 지수 

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// ** https://school.programmers.co.kr/learn/courses/30/lessons/12927
public class Main {

    // n 은 차감 가능한 횟수 
    // words 여기에 있는 것들은 뺄 수 있는 대상 
    public static void main(String[] args) {
        Main    m       = new Main();
        int     n1      = 4;
        int[]   work1   = new int[]{4,3,3};
        int     n2      = 1;
        int[]   work2   = new int[]{2,1,2};
        int     n3      = 999;
        int[]   work3   = new int[]{800,100,55,45};
        int     n4      = 7;
        int[]   work4   = new int[]{10,5,7};
//        m.solution(n1, work1);
//        m.solution(n2, work2);
        System.out.println(m.solution(n1, work1));
        System.out.println(m.solution(n2, work2));
        System.out.println(m.solution(n3, work3));
        System.out.println(m.solution(n4, work4));
        
    }

    // 이진 탐색으로 될거 같긴한데 
    // 1. 일단 works 에 모든 값의 합이 n 보다 큰지 확인 
    public long solution(int n, int[] works) {


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int work : works){
            priorityQueue.offer(work);
        }

        while(n>0){
            int maxInt = priorityQueue.poll();
            priorityQueue.offer(maxInt-1);
            n--;
        }

        long answer = 0;
        for(int i : priorityQueue){
            if(i>0) {
                answer+= (long) Math.pow(i,2);
            }
        }

        return answer;
    }
}
