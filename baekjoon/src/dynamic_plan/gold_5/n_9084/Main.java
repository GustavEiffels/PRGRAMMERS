package dynamic_plan.gold_5.n_9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            int coinCnt = Integer.parseInt(br.readLine());
            String[] coinStr = br.readLine().split(" ");
            int goal = Integer.parseInt(br.readLine());
            int[] coins = new int[coinCnt];
            for(int k = 0; k<coinCnt; k++){
                coins[k] = Integer.parseInt(coinStr[k]);
            }
            int[] dp = new int[goal+1];
            dp[0] = 1;

            for(int coin : coins){
                for(int k = coin; k<=goal; k++){
                    dp[k] += dp[k-coin];
                }
            }
            System.out.println(dp[goal]);
        }
    }
}
