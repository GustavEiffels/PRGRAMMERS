package dynamic_plan.silver_2.n_1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int     n = Integer.parseInt(br.readLine());
        int[]   arr = new int[n];
        int     idx = 0;
        for(String s : br.readLine().split(" ")){
            arr[idx] = Integer.parseInt(s);
            idx++;
        }

        int[]   dp  = new int[n];

        int     max = arr[0];
        dp[0] = arr[0];

        for(int i = 1; i<n; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
