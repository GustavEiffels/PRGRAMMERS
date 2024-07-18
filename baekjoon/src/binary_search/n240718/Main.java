package binary_search.n240718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br       = new BufferedReader(new InputStreamReader(System.in));
        int            n        = Integer.parseInt(br.readLine());
        int[]          n_arr    = new int[n];
                       n        = 0 ;
        for ( String n_line : br.readLine().split(" ") ) { n_arr[n] = Integer.parseInt(n_line); n++;}
        br.readLine();

        // ** 정렬 
        Arrays.sort(n_arr);

        for(String m : br.readLine().split(" ")) {
            System.out.println(solution(n_arr, Integer.parseInt(m)) ? "1":"0");
        }
        

    }

    public static boolean solution(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
