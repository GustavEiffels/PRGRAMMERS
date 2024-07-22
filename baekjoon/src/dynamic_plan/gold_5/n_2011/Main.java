package dynamic_plan.gold_5.n_2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();

        if (target.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int len = target.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;

        for (int i = len - 1; i >= 0; i--) {
            if (target.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];

                if (i + 1 < len &&
                        (target.charAt(i) == '1' ||
                                (target.charAt(i) == '2' && target.charAt(i + 1) <= '6'))) {
                    dp[i] += dp[i + 2];
                }
            }
            dp[i] %= 1000000;
        }

        System.out.println(dp[0]);
    }
}