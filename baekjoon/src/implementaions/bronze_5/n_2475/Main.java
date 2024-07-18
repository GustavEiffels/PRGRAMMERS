package implementaions.bronze_5.n_2475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(String s : br.readLine().split(" ")){
            sum += Math.pow(Integer.parseInt(s), 2);
        }
        System.out.println(sum%10);
    }
}
