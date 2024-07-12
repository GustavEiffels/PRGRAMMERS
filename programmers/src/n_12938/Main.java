package n_12938;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        int n1 = 2;
        int s1 = 9;
        int n2 = 2;
        int s2 = 1;
        int n3 = 2;
        int s3 = 8;

        for(int i : m.solution(n1,s1)){
            System.out.println(i);
        }
        System.out.println();

        for(int i : m.solution(n2,s2)){
            System.out.println(i);
        }
        System.out.println();
        for(int i : m.solution(n3,s3)){
            System.out.println(i);
        }
        System.out.println();
    }


    public int[] solution(int n, int s) {

        if(n>s){
            return new int[]{-1};
        }
        else{
            int[] answer = new int[n];
            int quo         = s/n;
            int remain      = s%n;
            Arrays.fill(answer, quo);

            for(int i = 0; i<remain; i++){
                answer[i] += 1;
            }
            Arrays.sort(answer);

            return answer;
        }
    }
}
