package level02.N155651;


public class Main {


    public static int solution(String[][] book_time){
        int answer = 1;

        // 하루를 분으로 바꾸어 배열 생성
        int[] timeCheck = new int[60*24+10];

        for(int i = 0; i< book_time.length; i++){
            int start = stringArrToMinute(book_time[i][0].split(":"));
            int end  = stringArrToMinute(book_time[i][1].split(":"));

            timeCheck[start]  += 1;             // 해당시간에 방 하나 사용중
            timeCheck[end+10] -= 1;             // 해당시간에 방 하나 사용가능
        }

        for(int i = 1; i<timeCheck.length; i++){
            // 이전 시간에 방 상태를 더함 그러면 사람이 한명 나갈때 까지 계속 앞의 상태를 유지
            timeCheck[i] += timeCheck[i-1];
            if(answer < timeCheck[i]) {
                answer = timeCheck[i];
            }
        }

        return answer;
    }

    public static int stringArrToMinute(String[] time){
        return ( (Integer.parseInt(time[0]) * 60) + (Integer.parseInt(time[1]) ) );
    }
}


