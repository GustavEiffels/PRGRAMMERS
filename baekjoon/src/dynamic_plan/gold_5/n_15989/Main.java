package dynamic_plan.gold_5.n_15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[]{1,2,3};
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            int[] dp = new int[num+1];

            dp[0] = 1;

            for (int coin : coins) {
                for (int j = coin; j <= num; j++) {
                    dp[j] += dp[j - coin];
                }
            }

            result[i] = dp[num];
        }
        for(int i : result){
            System.out.println(i);
        }
    }
}
