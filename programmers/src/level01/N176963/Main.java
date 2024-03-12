package level01.N176963;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    
    public static void main(String[] args) {
        String[] name1 = new String[]{"may", "kein", "kain", "radi"};
        String[] name2 = new String[]{"kali", "mari", "don"};
        String[] name3 = new String[]{"may", "kein", "kain", "radi"};

        int[] yearning1 = new int[]{5, 10, 1, 3};
        int[] yearning2 = new int[]{11, 1, 55}  ;
        int[] yearning3 = new int[]{5, 10, 1, 3};

        String[][] photo1 = new String[][]
        {
            {"may", "kein", "kain", "radi"},
            {"may", "kein", "brin", "deny"}, 
            {"kon", "kain", "may", "coni"}
        };

        String[][] photo2 = new String[][]
        {
            {"kali", "mari", "don"},
            {"pony", "tom", "teddy"}, 
            {"con", "mona", "don"}
        };

        String[][] photo3 = new String[][]
        {
            {"may"},
            {"kein", "deny", "may"}, 
            {"kon", "coni"}
        };
        
        // solution(name3, yearning3, photo3);
        // solution(name2, yearning2, photo2);
        // solution(name1, yearning1, photo1);

        Arrays.stream(solution(name3, yearning3, photo3)).forEach(i -> {
            System.out.println(i);
        });

        System.out.println("----");

        Arrays.stream(solution(name2, yearning2, photo2)).forEach(i -> {
            System.out.println(i);
        });
        System.out.println("----");

        Arrays.stream(solution(name1, yearning1, photo1)).forEach(i -> {
            System.out.println(i);
        });
        System.out.println("----");
        
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {

        Map<String,Integer> nameScore   = new HashMap<>();
        int                 size        = name.length;
        int                 photoCnt    = photo.length;
        int[]               answer      = new int[photoCnt];


        for(int i = 0; i<size ;i++)     {
            nameScore.put(name[i], yearning[i]);
        }


        for(int i = 0; i<photoCnt; i++) {
            int tempScore = 0;
            String[] temp = photo[i];

            for (String s : temp) {
                tempScore += (nameScore.get(s) != null) ? nameScore.get(s) : 0;
            }
            answer[i] = tempScore;
        }

        return answer;
    }
}

