package dynamic_plan.gold_5.n_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
        String[] commandLine = br.readLine().split(" ");
        int n         = Integer.parseInt(commandLine[0]);
        int limit     = Integer.parseInt(commandLine[1]);
        int[] weights = new int[n+1];
        int[] values  = new int[n+1];

        for(int i = 1; i<n+1; i++){
            String[] line = br.readLine().split(" ");
            weights[i]    = Integer.parseInt(line[0]);
            values[i]     = Integer.parseInt(line[1]);
        }

        int[][]   dp = new int[n+1][limit+1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= limit; w++) {
                if (w >= weights[i]) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + values[i]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(dp[n][limit]);
    }
}
