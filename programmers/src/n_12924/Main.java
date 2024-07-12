package n_12924;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.sum(15,15));
        System.out.println(m.solution(1));
    }
    public int solution(int n) {
        int answer = 0;
        int from   = 1;
        int to     = 2;

        if(n==1){
            return 1;
        }

        while(to<=n){
            if( n > sum(from,to) ) to++;
            else if( n < sum(from,to)) from++;
            else{
                answer++;
                to++;
            }
        }
        return answer;
    }
    public int sum(int from, int to){
        int fromSum = ((from)*(from-1))/2;
        int toSum   = ((to)*(to+1))/2;
        return toSum - fromSum;
    }
}
