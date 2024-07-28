package dynamic_plan.silver_2.n_11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] line = br.readLine().split(" ");
        int index = 0;
        for(String integer : line){
            arr[index++] = Integer.parseInt(integer);
        }

        int[] dp  = new int[n];
        dp[0]   = 1;
        Arrays.fill(dp,1);

        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if( arr[i] < arr[j] ){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int max = 0;
        for(int i : dp){
            max = Math.max(i,max);
        }
        System.out.println(max);
    }
}
