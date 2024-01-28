package level01;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/258712
 * DATE : 2024 01 28 : 13시 04 (주석 까지 추가)
 */
public class Present {


    public static void main(String[] args) {
        String[] friends = new String[]{"muzi", "ryan", "frodo", "neo"};
        String[] gift    = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        System.out.println(solution(friends, gift));

    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;

        // 친구 수 구하기 
        int friendsCnt = friends.length;

        // 친구 이름을 인덱스로 변환해주기 위한 MAP
        HashMap<String,Integer> friendsIndexMap = new HashMap<>();

        // 선물 주고 받은 현황판 만들기 ( 정배열로 만들기 )
        int[][] presentScoreArr = new int[friendsCnt][friendsCnt];

        // 선물 지수  ( 배열의 인덱스 번호 = 친구의 인덱스 번호 )
        int[]   presentIndex    = new int[friendsCnt];

        // 친구 이름을 인덱스로 변환해주는 MAP 에 값 할당 
        for(int i = 0; i<friendsCnt; i++) {
            friendsIndexMap.put(friends[i], i);
        }

        // 선물 주고 받은 문자열을 순회 하면서 현황판 만들기 
        for(String relationShip :  gifts) {

            // "친구1 친구2" 이런 형태의 문자열 이기 때문에 " "를 기준으로 문자열을 나눔 
            StringTokenizer st = new StringTokenizer(relationShip," ");

            // "친구1" 의 인덱스는 현황판의 행 역할 
            int row = friendsIndexMap.get(st.nextToken());

            // "친구2" 의 인덱스는 현황판의 열 역할 
            int colmn = friendsIndexMap.get(st.nextToken());

            // 현황판에 친구 들 사이의 선물 기록을 기록 ( 배열은 초기 값이 0 이기 때문에 ++ 만 해줘도 됨)
            presentScoreArr[row][colmn]++;
        }

        // 선물 지수 구하기 : 친구1 이  선물을 보낸 개수는 친구1 인덱스의 행의 값 / 친구1이 선물을 받은 개수는 친구1의 인덱스 열 값 
        for(int i = 0; i<friendsCnt; i++){
            int give = 0;
            int take = 0;
            for(int j = 0; j<friendsCnt; j++){
                give +=presentScoreArr[i][j]; // 행을 모두 더함 : 선물 보낸 수
                take +=presentScoreArr[j][i]; // 열을 모두 더함 : 선물 받은 수
            }

            // 총 선물 보낸 수 - 총 선물 받은 수 = 선물 지수 
            presentIndex[i] = give - take;
        }

        // 이번달에 받는 선물 개수 중 누가 제일 많이 받는지 확인
        for(int i = 0; i<friendsCnt; i++){

            int present = 0;

            for(int j = 0; j<friendsCnt; j++){
                // 인덱스가 같지 않을 경우 = 즉 자기 자신을 제외 한 경우 
                if(i != j){
                    // 친구1 : i , 친구2 : j 와 주고 받은 선물 비교 

                    // 친구1 이 친구2 에게 보낸 선물 수 
                    int giveCnt = presentScoreArr[i][j];

                    // 친구1 이 친구2 에게 받은 선물 수
                    int takeCnt = presentScoreArr[j][i];

                    // 친구1이 친구2 에게 더 많은 선물을 보냈거나 || 선물 보낸 개수가  같으며 선물 지수가 친구1이 더 높으면 -> 친구1은 이번달에 선물을 받음
                    if( giveCnt > takeCnt || ( (giveCnt == takeCnt) && presentIndex[i] >presentIndex[j] ) ) present++;
                }
            }

            // 여태 기록된 최대 선물 개수와 현재 친구1의 선물 개수를 비교
            // 친구1의 선물 개수가 현재 최대 선물 개수 보다 큰 경우
            if(answer < present) {
                // 최대 선물 개수를 친구1이 받을 선물 수로 할당 
                answer = present;
            }
        }
        return answer;
    }
}
