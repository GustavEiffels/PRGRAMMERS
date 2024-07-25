package dynamic_plan.silver_1.n_11052;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11052
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[]  dp = new int[n+1];

        String[] line = br.readLine().split(" ");


        // index 가 카드 갯수
        // index 에 해당하는 값 카드 팩의 가격

        for(int i = 1; i<=n;i++){
            arr[i] = Integer.parseInt(line[i-1]);
        }
        dp[0] = 0;

        for(int i = 1; i<=n; i++){
            for(int k = i; k<=n; k++){
                dp[k] = Math.max(dp[k-i]+arr[i],dp[k]);
            }
        }
        System.out.println(dp[n]);
    }
}
