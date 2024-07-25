package dynamic_plan.silver_1.n_11660;

import java.io.*;

// 구간합
// ** https://www.acmicpc.net/problem/11660
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb   = new StringBuilder();
        String[]       info      = br.readLine().split(" ");
        int            arrSize   = Integer.parseInt(info[0]);
        int            caseSize  = Integer.parseInt(info[1]);

        int[][]        dp        = new int[arrSize+1][arrSize+1];
        for(int i = 0; i<arrSize;i++){
            String[]   arrLine   = br.readLine().split(" ");
            for(int j = 0; j<arrSize; j++){
                int num = Integer.parseInt(arrLine[j]);
                 dp[i+1][j+1] = dp[i+1][j] + num;
            }
        }

        for(int i = 0; i<caseSize; i++){
            String[]  commandLine = br.readLine().split(" ");
            int startY = Integer.parseInt(commandLine[0]);
            int startX = Integer.parseInt(commandLine[1]);
            int endY   = Integer.parseInt(commandLine[2]);
            int endX   = Integer.parseInt(commandLine[3]);
            int index  = startY;
            int result = 0;
            while(index<=endY){
                result += dp[index][endX]-dp[index][startX-1];
                index++;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
