package binary_search.silver_2.n_16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]    info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]); // 사탕수

        int[] candy = new int[m];
        String[] candies = br.readLine().split(" ");

        for(int i = 0; i<m; i++){
            candy[i] = Integer.parseInt(candies[i]);
        }

        Arrays.sort(candy);
        int min = 1;
        int max = candy[m-1];
        int result = 0 ;

        while(min<=max){
            int cnt = 0;
            int mid = (min + max)/2;
            for(int can : candy){
                cnt += can/mid;
            }
            // 해당 사탕수로 동생들 수 이상으로 나눌 수 있는 경우 -> 더 나온 최대값 찾아야한다.
            if(cnt >= n){
                result = mid;
                min = mid+1;
            }
            else{
                max = mid-1;
            }
        }

        System.out.println(result);


    }
}
