package dynamic_plan.silver_3.n_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int            n   = Integer.parseInt(br.readLine());
        int[]          arr = new int[n+1];
        
        for(int i = 1; i<n+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];

        dp[0] = 0;
        
        if(n == 1){
            System.out.println(arr[1]);
        }
        else if(n == 2){
            System.out.println(arr[1]+arr[2]);
        }
        else {

            dp[1] = arr[1];
            dp[2] = arr[1]+arr[2];

            for(int i = 3; i<=n; i++){
                int case1 = dp[i-2];
                int case2 = dp[i-3]+arr[i-1];
                dp[i] = Math.max(case1, case2)+arr[i];
            }

            System.out.println(dp[n]);
        }
    }
}
