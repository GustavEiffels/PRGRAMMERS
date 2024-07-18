package n_178870_240716;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int[] sequence_1 = new int[]{1, 2, 3, 4, 5};
        int   k_1        = 7;

        int[] sequence_2 = new int[]{1, 1, 1, 2, 3, 4, 5};
        int   k_2        = 5;

        int[] sequence_3 = new int[]{2,2,2,2,2,2};
        int   k_3        = 6;

        int[] sequence_4 = new int[]{1, 2, 3, 4, 10, 10};
        int   k_4        = 10;

        int[] sequence_5 = new int[]{2, 2, 2, 2, 2};
        int   k_5        = 2;

        m.solution(sequence_1,k_1);
        System.out.println();
        m.solution(sequence_2,k_2);
        System.out.println();
        m.solution(sequence_3,k_3);
        System.out.println();
        m.solution(sequence_4,k_4);
        System.out.println();
        m.solution(sequence_5,k_5);
        System.out.println();

    }

    public class Point {
        public int size;
        public int first;
        public Point(int size, int first){
            this.size  = size;
            this.first = first;
        }
    }

    public int[] solution(int[] sequence, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.size != o2.size) {
                return Integer.compare(o1.size, o2.size);
            }
            return Integer.compare(o1.first, o2.first);
        });

        int lt  = 0 ;
        int rt  = 1 ;
        int sequenceSize = sequence.length;

        if(sequence[lt] == k){
            pq.offer(new Point(1,0));
        }
        else{
            int sum = sequence[lt]+sequence[rt] ;

            if(sum == k){
                pq.offer(new Point(2,0));
                sum -= sequence[lt++];
                sum -= sequence[rt++];
                sum += sequence[lt];
                sum += sequence[rt];
            }

            while(lt<=rt){
                if(sum < k){
                    if( rt + 1 == sequenceSize ){
                        break;
                    }
                    sum += sequence[++rt];
                }
                // sum  보다 큰 경우
                else if( sum > k ){
                    sum -= sequence[lt++];
                }
                // 같은 경우
                else {
                    pq.offer(new Point((rt-lt+1),lt));
                    sum -= sequence[lt++];
                    if(rt+1 != sequenceSize){
                        sum += sequence[++rt];
                    }
                }
            }
        }

        Point resultPoint = pq.poll();
//        System.out.println("resultPoint.first : "+resultPoint.first);
//        System.out.println("resultPoint.first+resultPoint.size-1 : "+(resultPoint.first+resultPoint.size-1));

        return new int[]{resultPoint.first,resultPoint.first+resultPoint.size-1};
    }
}
