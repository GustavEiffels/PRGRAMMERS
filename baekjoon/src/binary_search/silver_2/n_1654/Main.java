package binary_search.silver_2.n_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] command = br.readLine().split(" ");
        int n = Integer.parseInt(command[0]);
        int goal = Integer.parseInt(command[1]);

        long[] lines = new long[n];

        for (int i = 0; i < n; i++) {
            lines[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(lines);

        long max = lines[n - 1];
        long min = 1;
        long mid;
        long cnt;
        long result = 0;

        while (min <= max) {
            mid = (max - min) / 2 + min;
            cnt = 0;
            for (long line : lines) {
                cnt += line / mid;
            }
            if (cnt < goal) {
                max = mid - 1;
            } else {
                result = mid;
                min = mid + 1;
            }
        }
        System.out.println(result);
    }
}
