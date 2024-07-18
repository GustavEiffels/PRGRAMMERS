package implementaions.bronze_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result        = 0;
        for(String s : br.readLine().split(" ")){
            result += Integer.parseInt(s);
        }
        System.out.println(result);
    }
}
