package dynamic_plan.silver_1.n_10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ** https://www.acmicpc.net/problem/10844

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[10][n+1];

        for(int i = 1; i<10; i++){
            dp[i][1] = 1;
        }

        for(int i = 2; i<=n ;i++){
            for(int k = 0; k<=9; k++){

                int value = 0;
                if(k!=0){
                    value += dp[k-1][i-1];
                }
                if(k!=9){
                    value += dp[k+1][i-1];
                }
                dp[k][i] = value% 1000000000;
            }
        }

        long sum = 0;

        for(int i = 0; i<10; i++){
            sum = (sum + dp[i][n]) % 1000000000;
        }

        System.out.println(sum );
    }
}
