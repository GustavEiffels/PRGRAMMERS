package dynamic_plan.bronze_1.n_2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int            tc    = Integer.parseInt(br.readLine());
        int            max_f = 0;
        int            max_r = 0; 
        int[][]        arr   = new int[tc][2];

        for(int i = 0; i<tc; i++){
            int f = Integer.parseInt(br.readLine());
            int r = Integer.parseInt(br.readLine());

            arr[i][0] = f;
            arr[i][1] = r;

            if(f>max_f){ max_f =  f; }
            if(r>max_r){ max_r = r; }
        }

        int[][] dp = new int[max_f+1][max_r+1];

        for(int i = 1; i<max_r+1; i++){
            dp[0][i] = i;
        } 

        for(int i = 1; i<max_f+1; i++){
            for(int j = 1; j<max_r+1; j++){
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }

        for(int i = 0; i<tc; i++){
            System.out.println(dp[arr[i][0]][arr[i][1]]);
        }
    }
}
