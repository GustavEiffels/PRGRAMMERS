package level02.N12939;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
     
        Main m = new Main();
        System.out.println(m.solution("-1 -2 -3 -4"	));;
    }

    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(s, " ");

        while(st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp < min ) min = temp;
            if(temp > max ) max = temp;
        }
        return min+" "+max;
    }

}
