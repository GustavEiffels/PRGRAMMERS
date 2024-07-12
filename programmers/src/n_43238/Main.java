
package n_43238;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();

    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left    = 1;
        long right   = (long) times[times.length - 1] *n;
        long answer  = right;

        while( left <= right ) {
            long mid            = (left+right)/2;
            long totalPeople    = 0 ;

            for(int time : times ){
                totalPeople += mid / time;
            }

            if(totalPeople >= n){
                answer = mid;
                right  = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return answer;
    }
}
