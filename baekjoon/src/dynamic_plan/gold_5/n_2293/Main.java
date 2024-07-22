package dynamic_plan.gold_5.n_2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n  = Integer.parseInt(line[0]);
        int m  = Integer.parseInt(line[1]);

        int[] dp = new int[m+1];
        int[] coins = new int[n];

        for(int i = 0; i<n; i++){
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }

        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= m; j++) {
                dp[j] += dp[j - coin];
            }
        }
        System.out.println(dp[m]);
    }
}
