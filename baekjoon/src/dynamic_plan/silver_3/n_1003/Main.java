package dynamic_plan.silver_3.n_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int            n   = Integer.parseInt(br.readLine());
        int            max = 0;
        int[]          par = new int[n];
        for(int i = 0; i<n; i++){
            par[i] = Integer.parseInt(br.readLine());
            if(max < par[i]) max = par[i];
        }

        if(max == 0 ){
            System.out.println("1 0");
        }
        else if(max == 1){
            System.out.println("0 1");
        }
        else{
            int[][]          dp  = new int[max+1][2];
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;
    
            for(int i = 2; i<=max; i++){
                dp[i][0] = dp[i-2][0]+dp[i-1][0];
                dp[i][1] = dp[i-2][1]+dp[i-1][1];
            }
            
            for(int i = 0; i<n; i++){
                int param = par[i];
                System.out.println(dp[param][0]+" "+dp[param][1]);
            }
        }
    }
}
