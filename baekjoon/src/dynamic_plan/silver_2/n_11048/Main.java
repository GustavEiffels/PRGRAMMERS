package dynamic_plan.silver_2.n_11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] command  = br.readLine().split(" ");
        int row = Integer.parseInt(command[0]);
        int col = Integer.parseInt(command[1]);
        int[][] map = new int[row+1][col+1];
        int[][] dp  = new int[row+1][col+1];

        for(int i = 1; i<=row; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 1; j<=col; j++){
                map[i][j] = Integer.parseInt(line[j-1]);
            }
        }

        for(int i = 1; i<=row; i++){
            for(int j = 1; j<=col; j++){
                dp[i][j] = Math.max(Math.max(dp[i][j-1],dp[i-1][j-1]),dp[i-1][j])+map[i][j];
            }
        }

        System.out.println(dp[row][col]);
    }
}
