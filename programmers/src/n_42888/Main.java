package n_42888;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();

        String[] command = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        m.solution(command);

    }

    public class Message{
        public String id;
        public String command;

        public Message(String id, String command){
            this.id      = id;
            this.command = command;
        }
    }

    public String[] solution(String[] record) {
        int                     commandCnt     = record.length              ;

        ArrayList<Message>      messageRecord  = new ArrayList<>()          ;
        HashMap<String,String>  userMap        = new HashMap<>()            ;

        String command,id,nick = null;

        for( String message : record ){
            String[] command_arr = message.split(" ");

            if(command_arr.length == 3){
                command = command_arr[0];
                id      = command_arr[1];
                nick    = command_arr[2];
            }
            else{
                command = command_arr[0];
                id      = command_arr[1];
            }

            // ** message command 에 유일하게 들어가지 않음
            if( command.equals("Change") ){
                userMap.put(id,nick);
            }
            else {
                messageRecord.add(new Message(id,command));

                if( command.equals("Enter") ) {
                    userMap.put(id,nick);
                }
            }
        }

        String[] answer     = new String[messageRecord.size()];

        for(int i = 0; i <messageRecord.size(); i++){
            Message m = messageRecord.get(i);
            if( m.command.equals("Enter") ) {
                answer[i] = userMap.get(m.id)+"님이 들어왔습니다.";
            }
            else {
                answer[i] = userMap.get(m.id)+"님이 나갔습니다.";
            }
        }
        return answer;
    }    
}
