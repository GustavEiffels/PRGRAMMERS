package TEST;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExam {

    public static class TestNode{
        public String nodeNm;
        public int priority;
        public TestNode(String nodeNm, int priority){
            this.nodeNm = nodeNm;
            this.priority = priority;
        }
    }
    public static void main(String[] args) {

        PriorityQueue<TestNode> test01 = new PriorityQueue<>(Comparator.comparing(pri -> -pri.priority));
        test01.offer(new TestNode("donald",122));
        test01.offer(new TestNode("trump",10));
        test01.offer(new TestNode("eden",20));
        test01.offer(new TestNode("joe",150));


        for(int i = 0; i < 4  ; i++){
            TestNode nd = test01.poll();
            System.out.println("name : "+nd.nodeNm+" priority : "+nd.priority);
        }
    }
}
