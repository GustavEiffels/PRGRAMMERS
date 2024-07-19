package dynamic_plan.silver_3.n_2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] zero = new long[n+1];
        long[] one  = new long[n+1];
        zero[1]  = 0;
        one[1]   = 1;

        for(int i = 2; i<=n; i++){
            zero[i] = one[i-1]+zero[i-1];
            one[i]  = zero[i-1];
        }
        System.out.println(zero[n]+one[n]);
    }
}
