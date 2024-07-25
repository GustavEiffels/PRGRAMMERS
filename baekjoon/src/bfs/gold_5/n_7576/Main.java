package bfs.gold_5.n_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static class Tomato{
        public int row;
        public int col;
        public Tomato(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader  br           = new BufferedReader(new InputStreamReader(System.in));
        String[]        info         =  br.readLine().split(" ");
        int             col          = Integer.parseInt(info[0]);
        int             row          = Integer.parseInt(info[1]);

        int[][]         arr          = new int[row][col];
        int             day          = 0;
        Queue<Tomato>   queue        = new LinkedList<>();

        for(int i = 0; i<row; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j<col; j++){
                int data  = Integer.parseInt(line[j]);
                arr[i][j] = data;
                if(data == 1){
                    queue.offer(new Tomato(i,j));
                }
            }
        }
        // 복 동 남 서
        int[]          rowArr       = new int[]{-1,0,1,0};
        int[]          colArr       = new int[]{0,1,0,-1};

        while(!queue.isEmpty()){
            day++;
            int size = queue.size();

            for(int i = 0; i<size; i++){
                Tomato t = queue.poll();
                for(int k = 0; k<4; k++){
                    int predict_row   = rowArr[k]+t.row;
                    int predict_col   = colArr[k]+t.col;

                    if( !(predict_row < 0 || predict_row >= row || predict_col < 0 || predict_col>= col  || arr[predict_row][predict_col] == -1 || arr[predict_row][predict_col] == 1) ){
                        arr[predict_row][predict_col] = 1;
                        queue.offer(new Tomato(predict_row,predict_col));
                    }
                }
            }
        }

        for(int i = 0 ; i<row; i++){
            for(int j = 0; j<col; j++){
                if(arr[i][j] == 0){
                    day = 0;
                    break;
                }
            }
        }
        System.out.println(day-1);
    }
}
