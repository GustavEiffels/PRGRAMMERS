package dynamic_plan.silver_1.n_9465;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스

        for(int i = 0; i<t; i++){
            int sticker_cnt = Integer.parseInt(br.readLine());
            int[][] dp = new int[3][sticker_cnt+1];

            String[] sticker_1    = br.readLine().split(" ");
            String[] sticker_2    = br.readLine().split(" ");

            for(int k = 1; k<=sticker_cnt; k++){
                dp[0][k] = Math.max(dp[1][k-1],dp[2][k-1])+Integer.parseInt(sticker_1[k-1]);
                dp[1][k] = Math.max(dp[0][k-1],dp[2][k-1])+Integer.parseInt(sticker_2[k-1]);
                dp[2][k] = Math.max(dp[0][k-1],dp[1][k-1]);
            }
            bw.write(""+Math.max(dp[0][sticker_cnt],dp[1][sticker_cnt])+'\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
