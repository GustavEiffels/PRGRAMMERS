package dynamic_plan.gold_5.n_2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n 은 100

        // 전깃줄 정보 저장
        int[][] wires = new int[n][2];

        for(int i = 0; i<n; i++){
            String[] wireLine = br.readLine().split(" ");
            wires[i][0] = Integer.parseInt(wireLine[0]);
            wires[i][1] = Integer.parseInt(wireLine[1]);
        }

        Arrays.sort(wires,  Comparator.comparingInt(a -> a[0]));


        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int[] bPositions = new int[n];
        for(int i = 0; i<n; i++){
            bPositions[i] = wires[i][1];
        }

//        for(int i = 0; i<n; i++){
//            System.out.println("A : "+wires[i][0]+" B : "+wires[i][1]);
//        }
//        System.out.println();
//        for(int i = 0; i<n; i++){
//            System.out.println("bPositions : "+bPositions[i]);
//        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (bPositions[j] < bPositions[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int lisLength = 0;
        for (int i = 0; i < n; i++) {
            lisLength = Math.max(lisLength, dp[i]);
        }

        int result = n - lisLength;
        System.out.println(result);
    }
}
