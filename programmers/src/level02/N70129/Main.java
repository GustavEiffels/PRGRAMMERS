package level02.N70129;

public class Main {
    
    public static void main(String[] args) {
     
        Main main = new Main();
        for(int i : main.solution("1111111")){
            System.out.println(i);
        }

    }

    static int count        ;
    static int eraseZeroCnt ;

    public void req(String s){
        if(s.length() == 1){
            return;
        }
        else{
            count++;
            int currentStrLength = s.length();
            int zeroCnt          = 0;

            for(char c : s.toCharArray() ){
                if(c == '0'){
                    zeroCnt++;
                }
            }
            eraseZeroCnt += zeroCnt;
            req(Integer.toBinaryString(currentStrLength-zeroCnt));
        }
    }

    // s = 110010101001;
    public int[] solution(String s) {
        
        req(s);
        int[] answer = new int[]{count,eraseZeroCnt};
        
        return answer;
    }
}
