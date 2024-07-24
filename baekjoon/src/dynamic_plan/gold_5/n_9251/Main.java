package dynamic_plan.gold_5.n_9251;

import java.io.*;

// https://www.acmicpc.net/problem/9251
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] caseA = br.readLine().toCharArray(); int sizeA = caseA.length;
        char[] caseB = br.readLine().toCharArray(); int sizeB = caseB.length;

        // 최장 공통 수열
        int[][]  dp  = new int[sizeA+1][sizeB+1];

        for(int i = 1; i<=sizeA; i++){
            for(int j = 1;j<=sizeB; j++){
                if(caseA[i-1] == caseB[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[sizeA][sizeB]);
    }
}
