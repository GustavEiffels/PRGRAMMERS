package dynamic_plan.silver_2.n_11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ** https://www.acmicpc.net/problem/11051
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commandArr = br.readLine().split(" ");
        int N = Integer.parseInt(commandArr[0]);
        int K = Integer.parseInt(commandArr[1]);

        if(K == 0 || N == K) {
            System.out.println(1);
        }
        else{
            int[][] dp = new int[N+1][K+1];
            int MOD = 10007;

            for (int i = 0; i <= N; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i <= K; i++) {
                dp[i][i] = 1;
            }
            for(int i = 2; i<=N; i++) {
                for(int j = 1; j<=K; j++){
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1])%MOD;
                }
            }
            System.out.println((dp[N][K])%MOD);
        }

        // 이항 계수
        // n 개의 원소 중에서 K 개의 원소를 선택하는 방법의 수 -> 조합식


    }
}
