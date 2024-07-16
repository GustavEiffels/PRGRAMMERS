package n_178870_240716;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int[] sequence_1 = new int[]{1, 2, 3, 4, 5};
        int   k_1        = 7;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        // 우선순위 큐에 아이템 추가
        pq.add(new Point(1, 5));
        pq.add(new Point(1, 3));
        pq.add(new Point(2, 2));
        pq.add(new Point(0, 1));

        // 우선순위 큐에서 아이템을 하나씩 꺼내어 출력
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    public class Point implements Comparator<Point>{
        public int size;
        public int first;
        public Point(int size, int first){
            this.size  = size;
            this.first = first;
        }

        @Override
        public int compare(Point p1, Point p2) {
            if (p1.size != p2.size) {
                return Integer.compare(p1.size, p2.size);
            } else {
                return Integer.compare(p1.first, p2.first);
            }
        }
    }

    public int[] solution(int[] sequence, int k) {
        // ** 7 은 타겟이다.
        int lt  = 0 ;
        int rt  = 1 ;
        int sum = sequence[lt]+sequence[rt] ;



        if(sum == k){

        }

        while(lt<rt){

        }

        int[] answer = {};


        return answer;
    }
}
