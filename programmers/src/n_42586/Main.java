package n_42586;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int[] p1 = new int[]{93, 30, 55};
        int[] s1 = new int[]{1, 30, 5};
        int[] p2 = new int[]{95, 90, 99, 99, 80, 99};
        int[] s2 = new int[]{1, 1, 1, 1, 1, 1};

        for(int a  : m.solution(p1,s1) ){
            System.out.println(a);
        }
        System.out.println();
        for(int a  : m.solution(p2,s2) ) {
            System.out.println(a);
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        
        int[]                   leftTimeArr     = new int[progresses.length];
        Stack<Integer>          stack           = new Stack<>();
        ArrayList<Integer>      answerArrayList = new ArrayList<>();

        for(int i = 0; i<progresses.length; i++){
            int left_VALUE   = 100 - progresses[i]          ;
            int left_INTEGER = ( left_VALUE ) / speeds[i]   ;
            leftTimeArr[i]   = ( ( left_VALUE ) % speeds[i] != 0 )? left_INTEGER+1:left_INTEGER;
        }

        int head_Time = 0;

        for(int time : leftTimeArr){
            if(stack.empty()){
                head_Time = time;
                stack.push(time);
            }
            else {
                // stack 비우기
                if(head_Time < time){
                    answerArrayList.add(stack.size());
                    stack.removeAllElements();
                    head_Time = time;
                }
                stack.push(time);
            }
        }
        if(!stack.empty()){
            answerArrayList.add(stack.size());
        }
        int[] answer = new int[answerArrayList.size()];

        // int[] answer = answerArrayList.stream().mapToInt(Integer::intValue).toArray(); 이것보다 포문이 성능 더 좋음
        for(int i = 0; i<answer.length; i++){
            answer[i] = answerArrayList.get(i);
        }

        return answer;
    }

}
