package level01.N68935;


public class Main {

    public static void main(String[] args) {
     
        Main m = new Main();
        System.out.println(m.solution(45));
        System.out.println(m.solution(125));

    }

    public int solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        sb.reverse();
        
        int result = 0;
        int power = 1;
        for (int i = 0; i < sb.length(); i++) {
            result += (sb.charAt(i) - '0') * power;
            power *= 3;
        }
        return result;
    }

}
