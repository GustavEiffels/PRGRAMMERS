package n_43164_240715;

import java.util.*;

// ** https://school.programmers.co.kr/learn/courses/30/lessons/43164
public class Main {
    public static void main(String[] args) {
        String[][] ticket1 = new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] ticket2 = new String[][]{        {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        Main m = new Main();
//        m.solution(ticket1);
        m.solution(ticket2);

    }

    public class Ticket{
        public String from;
        public String to;

        public Ticket(String from, String to){
            this.from = from;
            this.to = to;
        }
    }

    public int ticket_cnt;
    public Map<String,List<Ticket>> fromTicketMap = new HashMap<>();
    public String[] solution(String[][] tickets) {
        ticket_cnt      = tickets.length;
        Ticket[] ticketArr  = new Ticket[ticket_cnt];

        for(int i = 0;i<ticket_cnt;i++){
            String fromStr   = tickets[i][0];
            Ticket newTicket = new Ticket(fromStr,tickets[i][1]);
            ticketArr[i]     = newTicket;

            if(fromTicketMap.containsKey(fromStr)){
                fromTicketMap.get(fromStr).add(newTicket);
            }
            else{
                List<Ticket> list = new ArrayList<>();
                list.add(newTicket);
                fromTicketMap.put(fromStr,list);
            }
        }


        return null;
    }
}
