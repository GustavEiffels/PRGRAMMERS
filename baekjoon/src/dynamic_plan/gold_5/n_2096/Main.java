package dynamic_plan.gold_5.n_2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt( br.readLine() );

        int[][] arr = new int[n][3];
        int[][] dpMax = new int[n][3];
        int[][] dpMin = new int[n][3];


        for(int i = 0; i<n; i++){
            String[] line = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
            arr[i][2] = Integer.parseInt(line[2]);
        }

        dpMax[0][0] = arr[0][0];
        dpMax[0][1] = arr[0][1];
        dpMax[0][2] = arr[0][2];

        dpMin[0][0] = arr[0][0];
        dpMin[0][1] = arr[0][1];
        dpMin[0][2] = arr[0][2];



        for(int i = 1; i<n; i++){
            for(int j = 0; j<3; j++){
                int valMax = dpMax[i-1][j];
                int valMin = dpMin[i-1][j];
                if(j != 0 ){
                    valMax = Math.max(valMax,  dpMax[i-1][j-1]);
                    valMin = Math.min(valMin,  dpMin[i-1][j-1]);

                }
                if( j != 2){
                    valMax = Math.max(valMax,  dpMax[i-1][j+1]);
                    valMin = Math.min(valMin,  dpMin[i-1][j+1]);
                }
                dpMax[i][j] = valMax+arr[i][j];
                dpMin[i][j] = valMin+arr[i][j];
            }
        }

        int max = Math.max(dpMax[n-1][0],Math.max(dpMax[n-1][1],dpMax[n-1][2])); int min = Math.min(dpMin[n-1][0],Math.min(dpMin[n-1][1],dpMin[n-1][2]));

        System.out.println(max+" "+min);
    }
}
