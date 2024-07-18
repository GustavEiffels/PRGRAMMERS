package n_240717;


public class N12907 {

    public static void main(String[] args) {
        int n_1 = 5;
        int[] m_1 = {1, 2, 5};

        int n_2 = 3;
        int[] m_2 = {2};

        int n_3 = 10;
        int[] m_3 = {1, 5, 10};

        int n_4 = 7;
        int[] m_4 = {2, 3, 4};

        int n_5 = 0;
        int[] m_5 = {1, 2, 3};

        int n_6 = 15;
        int[] m_6 = {1, 3, 5, 7};

        int n_7 = 8;
        int[] m_7 = {2, 3};

        int n_8 = 20;
        int[] m_8 = {1, 2, 5, 10};

        int n_9 = 6;
        int[] m_9 = {1, 2, 3};

        int n_10 = 9;
        int[] m_10 = {2, 5, 7};


        N12907 m = new N12907();
        // 예시들의 결과를 확인하는 코드
//        System.out.println(m.solution(n_1, m_1)); // 예시 1의 결과 출력
//        System.out.println(m.solution(n_2, m_2)); // 예시 2의 결과 출력
//        System.out.println(m.solution(n_3, m_3)); // 예시 3의 결과 출력
//        System.out.println(m.solution(n_4, m_4)); // 예시 4의 결과 출력
//        System.out.println(m.solution(n_5, m_5)); // 예시 5의 결과 출력
//        System.out.println(m.solution(n_6, m_6)); // 예시 6의 결과 출력
        System.out.println(m.solution(n_7, m_7)); // 예시 7의 결과 출력
//        System.out.println(m.solution(n_8, m_8)); // 예시 8의 결과 출력
//        System.out.println(m.solution(n_9, m_9)); // 예시 9의 결과 출력
//        System.out.println(m.solution(n_10, m_10)); // 예시 10의 결과 출력

    }



    public int solution(int n, int[] money) {
        int module = 1000000007;

        int[] dp   = new int[n+1];
        for(int i = 1; i<=n; i++){
            int current = 0;

            for(int coin : money){
                if( i > coin  ){
                    current += i%coin==0 ? dp[coin] : dp[coin]*dp[i%coin];
                }
                else if( coin == i){
                    current++;
                }

                else {
                    break;
                }
            }
            dp[i] = current;
        }
        return dp[n]%module;
    }
}
