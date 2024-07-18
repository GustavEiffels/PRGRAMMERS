package binary_search.n240718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_2 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br       = new BufferedReader(new InputStreamReader(System.in));
        int            n        = Integer.parseInt(br.readLine());
        HashMap<String,Boolean> map = new HashMap<>();

        for ( String n_line : br.readLine().split(" ") ) { map.put(n_line, true);}

        br.readLine();

        StringBuilder sb = new StringBuilder();
        for(String s : br.readLine().split(" ")){
            if(map.containsKey(s)){
                sb.append("1\n");
            }
            else{
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}
