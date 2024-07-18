package dynamic_plan.silver_3.n240719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int            num = Integer.parseInt(br.readLine());


        if(num == 1){
            System.out.println(0);
        }
        else{
            int[]          dp  = new int[num+1];
            dp[1] = 0;
            if(num >= 2){
                dp[2] = 1;
            }
            if(num >= 3){
                dp[3] = 1;
            }

            for(int i = 4; i<=num; i++){
                int result = Integer.MAX_VALUE;
                if(i%3 == 0){
                    result = Math.min(dp[i/3]+1, result);
                }
                
                if( i%2 == 0){
                    result = Math.min(dp[i/2]+1, result);
                }   
                    result = Math.min(dp[i-1]+1, result);
                 
                dp[i] = result;                
            }
            System.out.println(dp[num]);
        }
    }
}
