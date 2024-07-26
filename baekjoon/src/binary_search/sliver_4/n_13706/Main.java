package binary_search.sliver_4.n_13706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal N = new BigDecimal(br.readLine().trim());

        BigDecimal min = BigDecimal.ONE;
        BigDecimal max = N;
        BigDecimal result = BigDecimal.ZERO;

        MathContext mc = new MathContext(100, RoundingMode.HALF_UP);

        while (min.compareTo(max) <= 0) {
            BigDecimal mid = min.add(max.subtract(min).divide(BigDecimal.valueOf(2), mc));
            BigDecimal midSquared = mid.multiply(mid, mc);

            if (midSquared.compareTo(N) == 0) {
                result = mid;
                break;
            } else if (midSquared.compareTo(N) > 0) {
                max = mid.subtract(BigDecimal.ONE.divide(BigDecimal.TEN.pow(mc.getPrecision()), mc));
            } else {
                min = mid.add(BigDecimal.ONE.divide(BigDecimal.TEN.pow(mc.getPrecision()), mc));
            }
        }

        BigDecimal roundedResult = result.setScale(1, RoundingMode.HALF_UP);

        // 결과 출력
        System.out.println(roundedResult.toBigInteger());
    }
}
