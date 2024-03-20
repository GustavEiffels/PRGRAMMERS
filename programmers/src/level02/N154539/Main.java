package level02.N154539;


import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] testInt = new int[]{2,3,3,5};
        for(int i : new Main().solution(testInt)) {
            System.out.println(i);
        }


        int[] testInt2 = new int[]{9, 1, 5, 3, 6, 2};
        for(int i : new Main().solution(testInt2)) {
            System.out.println(i);
        }
    }


    public int[] solution(int[] numbers) {
        int     numberSize   = numbers.length     ;
        int[]   answer       = new int[numberSize];

        Stack<Integer> stack = new Stack<>();

        Arrays.fill(answer,-1);

        // 배열의 각 숫자를 탐색하며 스택을 활용하여 다음으로 더 큰 숫자를 찾음
        // 자기랑 인덱스 차이 1 나면서 큰수를 찾아서 stack 에서 제외 시키면 나머지 stack 에 있는 것들도 값을 비교하여 클 때 할당 되니까
        for (int i = 0; i < numberSize; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i]; // 스택에서 꺼내서 현재 숫자에 해당하는 값으로 설정
            }
            stack.push(i); // 현재 인덱스를 스택에 추가
        }
        return answer;
    }

    // public int[] solution(int[] numbers) {
    //     int     numberSize   = numbers.length     ;
    //     int[]   answer       = new int[numberSize];

    //     for(int i = 0; i<numberSize; i++){
    //         int temp = numbers[i];
    //         answer[i] = -1;

    //         if(!(i == numberSize -1)) {
    //             for(int j = i+1; j<numberSize; j++) {

    //                 if(numbers[j] > temp ){
    //                     answer[i] = numbers[j];

    //                     break;
    //                 }
    //             }   
    //         }
    //     }
    //     return answer;
    // }
}
