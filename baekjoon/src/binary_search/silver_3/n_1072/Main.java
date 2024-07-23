package binary_search.silver_3.n_1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br      = new BufferedReader(new InputStreamReader(System.in));
        String[]        line    = br.readLine().split(" ");
        long             X       = Integer.parseInt(line[0]);
        long             Y       = Integer.parseInt(line[1]);
        long             initVal = (Y*100/X);


        if (X == Y) {
            System.out.println("-1");
            return;
        }

        long min = 1;
        long max = 1000000000;
        long result = -1;

        while (min <= max) {
            long mid = (min + max) / 2;
            long X_tmp = X + mid;
            long Y_tmp = Y + mid;

            long newVal = (Y_tmp * 100) / X_tmp;

            if (newVal > initVal) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
            System.out.println(result);

        }
}
//12572124
//19230770

//1000000000
//19230770