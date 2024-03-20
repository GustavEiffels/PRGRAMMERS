package level02.N12953;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().solution(new int[]{2,6,8,14}));
    }

    // Factorization
    public Map<Integer, Integer> Factorization(int n ){
        Map<Integer,Integer> factorization = new HashMap<>();

        for(int i = 2; i<=n; i++){
            while(n % i == 0) {
                factorization.put(i, factorization.getOrDefault(i,0)+1);
                n /= i;
            }
        }
        return factorization;
    }

    public int solution(int[] arr) {
        int answer = 1;

        Map<Integer,Integer> leastCommonMultiple = new HashMap<>();
        for(int integer : arr) {
            Map<Integer,Integer> map = Factorization(integer);
            for(int index : map.keySet()){
                if(leastCommonMultiple.containsKey(index)) {
                    leastCommonMultiple.put(index, (leastCommonMultiple.get(index) > map.get(index) ? leastCommonMultiple.get(index) : map.get(index ) ));
                }
                else {
                    leastCommonMultiple.put(index,map.get(index));
                }
            }
        }

        for(int key : leastCommonMultiple.keySet()) {
            answer *= (int) Math.pow(key,leastCommonMultiple.get(key));
        }

        return answer;
    }
}
