package dynamic_plan.silver_3.n_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] day = new int[n+1];
        int[] pay = new int[n+1];
        int[] dp  = new int[n+2];

        for(int i = 1; i<=n; i++){
            String[] line = br.readLine().split(" ");
            day[i] = Integer.parseInt(line[0]);
            pay[i] = Integer.parseInt(line[1]);
        }

        for(int i = n; i>= 1 ; i--){
            int time = i+day[i];
            // 퇴사일 안에 끝나는 경우
            if(time <= n+1){
                dp[i]   = Math.max(dp[i+1],pay[i]+dp[time]);
            }
            else {
                dp[i]   = dp[i+1];
            }
        }

        System.out.println(dp[1]);
    }
}
