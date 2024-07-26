package dynamic_plan.silver_2.n_11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        String[] info = br.readLine().split(" ");

        for(int i = 0; i<num; i++){
            arr[i] = Integer.parseInt(info[i]);
        }
        int[] dp = new int[num];

        for(int i = 0; i<num; i++){
            dp[i] = arr[i];
        }

        for(int i = 1; i<num; i++){
            for(int j = 0; j<i; j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+arr[i]);
                }
            }
        }
        int maxSum = 0;
        for (int i = 0; i < num; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }
        System.out.println(maxSum);
    }
}
