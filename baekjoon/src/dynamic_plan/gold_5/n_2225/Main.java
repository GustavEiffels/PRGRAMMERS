package dynamic_plan.gold_5.n_2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]       line = br.readLine().split(" ");
        int            N    = Integer.parseInt(line[0]);
        int            K    = Integer.parseInt(line[1]);

        int[][]       dp    = new int[K+1][N+1];
        // K 개의 숫자로 N 을 만드는 방법
        dp[0][0]            = 1;

        for(int i = 1; i<=K; i++){
            for (int j = 0; j <= N; j++) {
                for (int x = 0; x <= N; x++) {
                    if (j - x >= 0) {
                        dp[i][j] += dp[i - 1][j - x];
                    }
                }
            }
        }

        System.out.println(dp[K][N]);

    }
}
