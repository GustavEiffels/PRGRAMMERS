package dynamic_plan.silver_1.n1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/status?user_id=soldiersung&problem_id=1149&from_mine=1
//  dp[row][0] = matrix[row][0] ( 메트릭스 값 ) + Math.min( dp[row][1] + dp[row][1] ) => dp 에 이번에 지정한 색깔 비용과 이번에 지정한 색깔을  제외한 나미지 두 색으로 칠해진 바로 전집의 색깔 중 비용이 작은 값을 더함   
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br       = new BufferedReader(new InputStreamReader(System.in));
        int            n        = Integer.parseInt(br.readLine());
        int[][]        matrix   = new int[n][3]; 
        int[][]        dp       = new int[n][3];


        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        dp[0][0] = matrix[0][0];
        dp[0][1] = matrix[0][1];
        dp[0][2] = matrix[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = matrix[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = matrix[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = matrix[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int result = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(result);
    }
}
