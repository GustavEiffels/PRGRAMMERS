package level02.N154540;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다. 
 * 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다. 
 * 지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며, 
 * 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다. 
 * 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다. 
 * 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다. 
 * 지도의 각 칸에 적힌 숫자는 식량을 나타내는데, 상, 하, 좌, 우로 연결되는 
 * 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 
 * 머물 수 있는지를 나타냅니다. 어떤 섬으로 놀러 갈지 
 * 못 정한 메리는 우선 각 섬에서 최대 며칠씩 
 * 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.

지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때, 
각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 
return 하는 solution 함수를 완성해주세요. 
만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.
 */
public class Main {

    public static void main(String[] args) {
        String[] map1 = new String[]{"X591X","X1X5X","X231X", "1XXX1"};

        String[] map2 = new String[]{"XXX","XXX","XXX"};
        for(int i : solution(map1)){
            System.out.println(i);
        }
        for(int i : solution(map2)){
            System.out.println(i);
        }
    }

    public static int[][] direction = {{0,-1},{1,0},{0,1},{-1,0}};

    public static int[] solution(String[] maps) {
        
        // ** 무인도의 행 길이 
        int rowNum = maps.length;
        
        // ** 무인도의 열 길이    
        int colNum = maps[0].length();

        int mapSize = rowNum*colNum;
        int seaCnt  = 0;

        // ** 지도 형태 생성 
        int[][] islandMap = new int[rowNum][colNum];

        // ** 탐사 여부 확인한 지도 생성 
        int[][] exporeMap = new int[rowNum][colNum];

        // ** 무인도 결과 
        ArrayList<Integer> isLandResult = new ArrayList<>();

        for(int i = 0; i<rowNum; i++) {
            // ** 현재 행 
            String currentRow = maps[i];

            for(int k = 0; k<colNum; k++) {

                char info = currentRow.charAt(k);

                if(info == 'X'){
                    islandMap[i][k] = -1;
                    seaCnt++;
                }
                else {
                    islandMap[i][k] = info-'0';
                }
            }
        }


        if(seaCnt == mapSize) {
            int[] result = new int[]{-1};
            return result;
        }

        for(int i = 0; i<rowNum; i++ ){
            for(int k = 0; k<colNum; k++){
                 
                // ** 아직 탐사 못한 곳인 경우
                if(exporeMap[i][k] == 0) {

                    exporeMap[i][k] = 1;
                    // ** 섬 일 경우 
                    if(islandMap[i][k] != -1) {
                        int foodCount       = islandMap[i][k];
                        int currentX           = i;
                        int currentY           = k;
                        int directionIndx   = 0;
                        while(directionIndx <4) {
                            int directionX = currentX+direction[directionIndx][0];
                            int directionY = currentY+direction[directionIndx][1];

                            if( ( directionX >= rowNum  ) || ( directionX < 0 ) || ( directionY >= colNum ) || ( directionY < 0 ) || (exporeMap[directionX][directionY] == 1) || (islandMap[directionX][directionY] == -1) ) {
                                directionIndx++;
                                continue;
                            } 
                            else {
                                // ** 식량 확보 
                                foodCount+=islandMap[directionX][directionY];

                                // ** 탐사 표시
                                exporeMap[directionX][directionY] = 1;

                                // ** 다음 탐사 목표 세팅
                                currentX = directionX;
                                currentY = directionY;

                                // ** 탐사 방향 초기화 
                                directionIndx = 0; 
                            }
                        }
                        isLandResult.add(foodCount);
                    }
                } 
            }
        }
        Collections.sort(isLandResult);

        int[] result = new int[isLandResult.size()];

        for(int i  =0; i<result.length; i++) {
            result[i] = isLandResult.get(i);
        }

        return result;
    }
}
