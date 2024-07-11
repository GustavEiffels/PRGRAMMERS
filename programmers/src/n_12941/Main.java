package n_12941;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main    m = new Main();
        int[] A_1 = new int[]{1, 4, 2};
        int[] B_1 = new int[]{5, 4, 4};

        System.out.println(m.solution(A_1, B_1));    
    }



    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B); 
        reverseArray(B); 

        int arrLen = A.length;

        for (int i = 0; i < arrLen; i++) {
            answer += A[i] * B[i];
        }

        return answer;
    }

    private void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

}
