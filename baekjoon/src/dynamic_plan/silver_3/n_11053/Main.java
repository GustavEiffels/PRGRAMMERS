package dynamic_plan.silver_3.n_11053;

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


        int[] dp = new int[n];
        int maxLength = 1;
        
        for(int i = 0; i<n; i++){
            dp[i] = 1;
        }

        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(maxLength);

    }
}
