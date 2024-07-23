package binary_search.sliver_4.n_2776;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for(int i = 0; i<2*T; i++){
            int      NOTE      = Integer.parseInt(br.readLine());
            int[]    NOTE_ARR  = new int[NOTE];
            String[] LINE_1 = br.readLine().split(" ");

            for(int k = 0; k<NOTE; k++){
                NOTE_ARR[k] = Integer.parseInt(LINE_1[k]);
            }
            Arrays.sort(NOTE_ARR);

            int         QUES       = Integer.parseInt(br.readLine());
            int[]       QUES_ARR   = new int[QUES];
            String[]    LINE_2     = br.readLine().split(" ");
            for(int k = 0; k<QUES; k++){
                QUES_ARR[k] = Integer.parseInt(LINE_2[k]);
            }


            for(int q : QUES_ARR){
                int max = NOTE-1;
                int min = 0;
                int mid  = 0;
                while(min<=max) {
                    mid = (max+min)/2;
                }
            }
        }
    }
}
