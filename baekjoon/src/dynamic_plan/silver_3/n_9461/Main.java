package dynamic_plan.silver_3.n_9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int             n = Integer.parseInt(br.readLine());
        int[]        test = new int[n];
        int           max = 0;

        for(int i = 0; i<n ;i++){
            int current = Integer.parseInt(br.readLine());
                max = Math.max(max, current);
            test[i] = current;
        }


        long[] dp = new long[max + 1];  

        if (max >= 1) dp[1] = 1;
        if (max >= 2) dp[2] = 1;
        if (max >= 3) dp[3] = 1;

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < n; i++) {
            System.out.println(dp[test[i]]);
        }
    }
}
