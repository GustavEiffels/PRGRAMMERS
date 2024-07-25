package binary_search.silver_2.n_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
        String[]       info = br.readLine().split(" ");

        int            treeCnt = Integer.parseInt(info[0]);
        int            goal    = Integer.parseInt(info[1]);

        int[]          arr     = new int[treeCnt];

        String[]       treeIn  = br.readLine().split(" ");

        for(int i = 0 ; i<treeCnt; i++){
            arr[i] = Integer.parseInt(treeIn[i]);
        }

        Arrays.sort(arr);

        int            max     = arr[treeCnt-1];
        int            min     = 0;
        int            result  = 0;

        while (min <= max) {
            int mid = (min + max) >>> 1;
            long sum = 0;
            for (int i : arr) {
                if (i > mid) {
                    sum += i - mid;
                }
            }
            if (sum >= goal) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(result);
    }
}
