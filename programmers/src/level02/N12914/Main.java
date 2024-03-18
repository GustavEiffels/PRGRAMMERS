package level02.N12914;


//BFS
public class Main {

    /**
     * 효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
     * (1칸, 1칸, 1칸, 1칸)
     * (1칸, 2칸, 1칸)
     * (1칸, 1칸, 2칸)
     * (2칸, 1칸, 1칸)
     * (2칸, 2칸)
     * 의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수,
     * solution을 완성하세요. 예를 들어 4가 입력된다면, 5를 return하면 됩니다.
     */

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.solution(3));;
    }

    static int result = 0;
    static int goal   = 0;
    public void jump(int tryCnt, int currentDistance){

        if(tryCnt == goal) {
            return;
        }
        else {
            if(currentDistance == goal) {
                result++;
            }
            else {
                jump(tryCnt+1,currentDistance+1);
                jump(tryCnt+1,currentDistance+2);
            }
        }
    }

    public long solution(int n) {
        // 1 아니면 2 만 동작 가능
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // 1보다 큰 경우  바로 앞의 경우에서 1칸만 이동하면 됨
            if (i >= 1) {
                dp[i] += dp[i - 1];
                dp[i] %= 1234567;
            }
            // 2보다 큰 경우 2개 적은 경우에서 2개만 이동하면 됨 -> 누적되어 경우 개산
            if (i >= 2) {
                dp[i] += dp[i - 2];
                dp[i] %= 1234567;
            }
        }
        return dp[n];
    }
}
