package n_169199;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        String[] s1 = new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};

        m.solution(s1);
    }

    public class PointRecord{
        public PointRecord(char type){
            this.type = type;
        }
        public char type;
        public boolean isAbleN = true;
        public boolean isAbleE = true;
        public boolean isAbleS = true;
        public boolean isAbleW = true;
    }

    public class Point{
        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] d_r = {-1,0,1,0};
    static int[] d_c = {0,1,0,-1};

    static int board_r;
    static int board_c;

    static PointRecord[][] boardArr;

    public int solution(String[] board) {
        board_r = board.length;
        board_c = board[0].length();

        int start_r = 0;
        int start_c = 0;

        boardArr = new PointRecord[board_r][board_c];

        for(int i = 0; i<board_r; i++){
            String board_line = board[i];
            for(int j = 0; j<board_c; j++){
                char type = board_line.charAt(j);
                if(type == 'R') {
                    start_r = i;
                    start_c = j;
                }
                PointRecord record = new PointRecord(type);
                if(i == 0)              record.isAbleN = false;
                if(i == board_r -1 )    record.isAbleS = false;
                if(j == board_c -1)              record.isAbleE = false;
                if(j == 0 )    record.isAbleW = false;

                boardArr[i][j] = record;
            }
        }

        BFS(start_r,start_c);

        return 0;
    }

    public int BFS(int start_r, int start_c){
        Queue<Point>    pointQueue      = new LinkedList<>()          ;
        int             level           = 0                           ;

        PointRecord     pointRecord = boardArr[start_r][start_c];
        boolean[]       booleans    = new boolean[]{pointRecord.isAbleN, pointRecord.isAbleE, pointRecord.isAbleS, pointRecord.isAbleW};

        if( pointRecord.type == 'G' ) {
            return level;
        }
        else {
            int bolIndex = 0;
            for(boolean bol : booleans ){

                if( bol ){
                    boardArr[start_r][start_c].isAbleN = false;
                    Point p = getPoint(start_r,start_c,bolIndex);
                    if( p != null ){
                        pointQueue.offer(p);
                    }
                }
            }

            if ( pointRecord.isAbleN  ){
                boardArr[start_r][start_c].isAbleN = false;
                Point p = getPoint(start_r,start_c,0);
                if( p != null ){
                    pointQueue.offer(p);
                }
            }
            if ( pointRecord.isAbleE  ){
                boardArr[start_r][start_c].isAbleE = false;
                Point p = getPoint(start_r,start_c,1);
                if( p != null ){
                    pointQueue.offer(p);
                }
            }
            if ( pointRecord.isAbleS  ){
                boardArr[start_r][start_c].isAbleS = false;
                Point p = getPoint(start_r,start_c,2);
                if( p != null ){
                    pointQueue.offer(p);
                }
            }
            if ( pointRecord.isAbleW  ){
                boardArr[start_r][start_c].isAbleW = false;
                Point p = getPoint(start_r,start_c,3);
                if( p != null ){
                    pointQueue.offer(p);
                }
            }

            boolean isFind = false;


            while(!pointQueue.isEmpty()){
                int current_length = pointQueue.size();

                level++;

                for(int i = 0; i<current_length; i++ ){
                    Point       p  = pointQueue.poll();
                    PointRecord pr = boardArr[p.x][p.y];
                    if(pr.type == 'G'){
                        isFind = true;
                        break;
                    }
                    else {

                    }
                }

                if(isFind){
                    break;
                }
            }

            if(isFind){
                return level;
            }
            else{
                return -1;
            }
        }


        return 0;
    }

    public Point getPoint(int row, int col, int index){

        int init_r  = row ;
        int init_c  = col ;
        int index_r = d_r[index];
        int index_c = d_c[index];

        Point p = null;


        while(true){
            int pre_r = row+index_r;
            int pre_c = col+index_c;

            if( (pre_r == -1 || pre_r >= board_r) || ( pre_c == -1 || pre_c >= board_c ) || boardArr[pre_r][pre_c].type == 'D' ){
                if( !(init_r == row && init_c == col)){
                    p = new Point(row,col);
                }
                break;
            }
            else {
                row += index_r;
                col += index_c;
            }
        }

        return p;
    }


}
