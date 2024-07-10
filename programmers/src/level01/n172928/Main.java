package level01.n172928;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        
        Main main = new Main();

        String[] park1   = new String[]{"SOO","OOO","OOO"};
        String[] routes1 = new String[]{"E 2","S 2","W 1"};
        main.solution(park1, routes1);

        String[] park2   = new String[]{"SOO","OXX","OOO"};
        String[] routes2 = new String[]{"E 2","S 2","W 1"};
        main.solution(park2, routes2);

        String[] park3   = new String[]{"OSO","OOO","OXO","OOO"};
        String[] routes3 = new String[]{"E 2","S 3","W 1"};
        main.solution(park3, routes3);


    }

    // 동 남 서 북 순서 
    private static int[] directionX = {0,1,0,-1};
    private static int[] directionY = {1,0,-1,0};
    private static HashMap<Character,Integer> directionCode = new HashMap<Character,Integer>(){
        {
            put('E',0);
            put('S',1);
            put('W',2);
            put('N',3);
        }
    };

    

    public int[] solution(String[] park, String[] routes) {
        
        // ** 공원의 행 길이 
        int row = park.length;

        // ** 공원의 열 길이 
        int col = park[0].length();

        int currentX = 0;
        int currentY = 0;

        char[][] parkArr = new char[row][col];

        // ** 배열 설정 및 출발 지점 확인 완료 
        int rowIndex = 0;
        for(String data : park){
            int colIndex = 0;
            for(char c : data.toCharArray() ){
                if(c == 'S'){
                    currentX = rowIndex;
                    currentY = colIndex;
                }
                parkArr[rowIndex][colIndex] = c;
                colIndex++;
            }
            rowIndex++;
        }

        for(String route : routes){
            StringTokenizer st = new StringTokenizer(route," ");
            char direction     = st.nextToken().charAt(0);
            int  distance      = Integer.valueOf(st.nextToken());

            int  dX            = directionX[directionCode.get(direction)];
            int  dY            = directionY[directionCode.get(direction)];
            boolean isAble     = true;

            for(int i = 1; i<=distance; i++) {
                int tempX = currentX+(dX*i);
                int tempY = currentY+(dY*i);

                if( tempX >= row || tempX < 0 || tempY >= col || tempY < 0 ) {
                    isAble = false;
                    break;
                }
                if(parkArr[tempX][tempY] == 'X') {
                    isAble = false;
                    break;
                }
            }

            if(isAble){
                currentX += (dX*distance);
                currentY += (dY*distance);
            }
        }

        // System.out.println("currentX : "+currentX);
        // System.out.println("currentY : "+currentY);

        int[] answer = {currentX,currentY};
        return answer;
    }
}
