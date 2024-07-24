package binary_search.sliver_4.n_2776;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int note1Count = Integer.parseInt(br.readLine());
            int[] note1 = new int[note1Count];
            String[] note1Str = br.readLine().split(" ");
            for (int index = 0; index < note1Count; index++) {
                note1[index] = Integer.parseInt(note1Str[index]);
            }
            Arrays.sort(note1);

            int note2Count = Integer.parseInt(br.readLine());
            String[] note2Str = br.readLine().split(" ");
            int[] note2 = new int[note2Count];
            for (int index = 0; index < note2Count; index++) {
                note2[index] = Integer.parseInt(note2Str[index]);
            }

            for (int num : note2) {
                if (binarySearch(note1, num)) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
