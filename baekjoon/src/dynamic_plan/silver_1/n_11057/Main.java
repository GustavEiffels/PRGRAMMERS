package dynamic_plan.silver_1.n_11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ** https://www.acmicpc.net/status?user_id=soldiersung&problem_id=11057&from_mine=1

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  num = Integer.parseInt(br.readLine());
        final int MOD = 10007;

        if(num == 1){
            System.out.println(10);
        }
        else{
            long[][] dp = new long[10][num+1];
            for(int i = 0; i<=9; i++){
                dp[i][1] = 1;
            }
            for(int i = 2; i<=num; i++){
                for(int j = 0; j<=9; j++){
                    if (j == 0) {
                        dp[j][i] = dp[j][i-1];
                    } else {
                        dp[j][i] = (dp[j-1][i] + dp[j][i-1]) % MOD;
                    }
                }
            }
            long sum = 0;
            for(int i = 0; i<=9; i++){
                sum = (sum + dp[i][num])%MOD;
            }

            System.out.println(sum);
        }
    }
}
