package n_68645;


public class Main {
    public static void main(String[] args) {

        Main m = new Main();
        m.solution(5);

    }

    public int[] solution(int n) {
        
        int[][] arr          = new int[n][n];
        
        int     mode          = 1;
        int     row           = 0;
        int     col           = 0;
        int     goal_val      = 0;
        int     currentNum    = 1;

        int     count         = n;
        int     index         = 0;

        for(int i = 1; i<=n; i++){ goal_val += i; }

        int[] answer         = new int[goal_val];

        while(currentNum<=goal_val) {
            arr[row][col] = currentNum;
            index++;
            if(mode == 1) {
                row++; 
            }
            else if(mode == 2){
                col++;
            }
            else{
                row--; col--;
            }

            if(index == count){
                index = 0;
                count--;

                if(mode == 1){
                    row--;
                    col++;
                    mode = 2;
                }
                else if(mode == 2){
                    row--;
                    col--;
                    col--;
                    mode = 3;
                }
                else {
                    row++;
                    row++;
                    col++;
                    mode = 1;
                }
            }

            currentNum++;
        }
        int lastIndex = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<=i; j++) {
                answer[lastIndex] = arr[i][j];
                lastIndex++;
            }
        }
        return answer;
    }
}

