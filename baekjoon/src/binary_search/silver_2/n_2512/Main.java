package binary_search.silver_2.n_2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// ** https://www.acmicpc.net/problem/2512
// 예산은 적게 주
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int     n           = Integer.parseInt(br.readLine());
        int[]   budgetArr   = new int[n];
        int     max         = 0;
        int     min         = 0;
        int     mid         = 0;
        int     result      = 0;

        String[] line       = br.readLine().split(" ");
        int     totalBudget = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            int budget = Integer.parseInt(line[i]);
            budgetArr[i] = budget;
            max = Math.max(max, budget);
        }


        while( min <= max ){
            mid = (max + min) / 2;
            int cnt = 0;
            for(int budget : budgetArr){
                // 예산 상한선이 중간 값 보다 큰 경우 중간 값을 주고 그렇지 않은 경우 ( mid 값이 상한값 보다 큰 경우 ) budget 을 할당
                cnt += (budget>mid) ? mid : budget;
            }

            // 예산이 더 큰 경우
            if(totalBudget >= cnt ){
                result = mid;
                min = mid+1;
            }

            if(totalBudget<cnt){
                max   = mid-1;
            }
        }

        System.out.println(result);
    }
}
