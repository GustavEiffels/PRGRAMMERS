package implementaions.bronze_2.n_2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result = "ascending";

        int index  = 0;
        int before = 0;
        for(String s : br.readLine().split(" ")){
            
            int current = Integer.parseInt(s);

            if(index != 0){
                if(before > current){
                    result = "descending";
                }

                if(result.equals("descending") && before<current){
                    result = "mixed";
                    break;
                }
            }
            
            before = current;
            index++;
        }
        System.out.println(result);
    }
}
