package dynamic_plan.silver_2.n_1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        int[] dp = new int[num+1];
        for(int i = 1; i<=num; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        int[] squares = new int[(int) Math.sqrt(num) + 1];
        for (int i = 1; i * i <= num; i++) {
            squares[i] = i * i;
        }

        for(int i = 1; i<=num; i++){
            for (int square : squares) {
                if (i >= square && square > 0) {
                    dp[i] = Math.min(dp[i], dp[i - square] + 1);
                }
            }
        }

        System.out.println(dp[num]);
    }
}
