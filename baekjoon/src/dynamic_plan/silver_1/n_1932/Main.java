package dynamic_plan.silver_1.n_1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int             n = Integer.parseInt(br.readLine());
        int[][]       arr = new int[n][n];
        int[][]        dp = new int[n][n];

        for(int i  = 0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j<n; j++){
                if( j < line.length ){
                    arr[i][j] = Integer.parseInt(line[j]);
                } 
                else{
                    arr[i][j] =  -1;
                }
            }
        }
        
        dp[0][0] = arr[0][0]; 

        for(int i = 1; i<n; i++){
            for(int j = 0 ; j<n; j++){
              if(arr[i][j] == -1){
                break;
              } 
              else{
                // 위 오른쪽 먼저 구하기 
                int max = dp[i-1][j];

                // 위 왼쪽 구하기   
                if(j != 0){
                    max = Math.max(max, dp[i-1][j-1]);
                }
                dp[i][j] = max + arr[i][j];
              } 
            } 
        }

        int max = 0 ;
        for(int i = 0; i<n; i++){
            max = Math.max(max, dp[n-1][i]);
        }
        System.out.println(max);
    }
}
