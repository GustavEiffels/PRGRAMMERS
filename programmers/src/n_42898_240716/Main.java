package n_42898_240716;


// https://school.programmers.co.kr/learn/courses/30/lessons/42898
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int m1 = 4;
        int n1 = 3;
        int[][] puddles_1 = new int[][]{{2,2}};
        System.out.println(m.solution(m1,n1,puddles_1));
    }

    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] dp = new int[n][m];

        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        // 시작점 초기화
        dp[0][0] = 1;

        // dp 배열 채우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                    dp[i][j] %= MOD;
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                    dp[i][j] %= MOD;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
