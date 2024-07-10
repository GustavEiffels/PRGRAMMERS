package n_169199;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        String[] s1 = new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        String[] s2 = new String[]{".D.R", "....", ".G..", "...D"};

        System.out.println(m.solution(s1));
        System.out.println(m.solution(s2));
    }

    

    /**
     * 1.시작점을 찾는다
        2.bfs 에서 시작점에서 미끄러진다
        미끄러지기
        - 미끄러지는 방향으로 -1이나 배열의 크기, 장애물을 만나는 경우 연산을 중지 연산하기 바로 이전 위치 값을 반환
        이미 지났던 곳인지 확인 후 이미 지난 곳이 아닌 경우 queue에 추가
     */


    public class Node{
        public int  row;
        public int  col;
        public char chr;
        public Node(int row, int col, char chr){
            this.col = col;
            this.row = row;
            this.chr = chr;
        }
    }


    public int solution(String[] board) {
        
        // ** 배열 생성 - 갔었는지 확인하기 위함 
        int board_row           = board.length;      // 열 
        int board_col           = board[0].length(); // 행 
        int start_row           = 0;
        int start_col           = 0;
        char[][]    boardArr   = new char[board_row][board_col];

        for(int i = 0; i<board_row; i++){
            String stringLine   = board[i];
            for(int j=0; j<board_col; j++) {
                char currentChar = stringLine.charAt(j);
                if(currentChar == 'R'){
                    start_row = i;
                    start_col = j;
                }
                boardArr[i][j] = currentChar;
            }
        }
        
        int answer = BFS(boardArr, start_row, start_col, board_row, board_col);
        
        return answer;
    }
    
    public int BFS(char[][] boardArr, int row, int col, int board_row, int board_col){

        // ** 시작점과 끝점이 반드시 나옴 => 겹치는 일 없음으로 시작점이 종료점인 경우는 존재하지 않는다.
        Queue<Node> queue  = new LinkedList<>();
                    queue.offer(new Node(row, col,'X'));
        int         level  = -1;
        int[]       d_row  = {-1,0,1,0};
        int[]       d_col  = {0,1,0,-1};
        boolean     isFind = false;
        boardArr[row][col] = 'X';

        // ** 경우가 존재하지 않을 때 까지 순회 
        while(!queue.isEmpty()){
            level++;
            int queueSize = queue.size();

            for(int i = 0; i<queueSize; i++) {
                Node currentNode = queue.poll();
                int  currentRow  = currentNode.row;
                int  currentCol  = currentNode.col; 

                if( currentNode.chr == 'G') {
                    
                    isFind = true;
                    break;
                }
                else {
                    for(int k = 0; k<4; k++){
                        int dr  = d_row[k];
                        int dc  = d_col[k];
                        int pr  = currentRow;
                        int pc  = currentCol;

                        // 멈추는 조건 
                        while(true){
                            pr += dr;
                            pc += dc;

                            if( pr == -1 || pr == board_row || pc == -1 || pc == board_col || boardArr[pr][pc] == 'D' ){
                                pr -= dr;
                                pc -= dc;
                                break;
                            }
                        }
                        char nextChar = boardArr[pr][pc];                        
                        if( nextChar != 'X' ) {
                            queue.offer(new Node(pr, pc,nextChar));
                            if(nextChar == 'G'){
                                break;
                            }
                            boardArr[pr][pc] = 'X';
                        }
                    }
                }
            }

            if(isFind){
                break;
            }
        }
        // BFS END 
        if(isFind)return level;
        else return -1;
    }

}
