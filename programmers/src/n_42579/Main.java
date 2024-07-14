package n_42579;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        String[] gen_1 = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[]    tim_1 = new int[]{500, 600, 150, 800, 2500};
        m.solution(gen_1,tim_1);


    }

    public class Genre{
        public String genre;
        public int playTime;

        public Genre(String genre, int playTime){
            this.genre = genre;
            this.playTime = playTime;
        }
    }

    public class Music{
        public int index;
        public int time;
        public Music(int index, int time){
            this.index = index;
            this.time  = time;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        // **
        PriorityQueue<Genre>                    genrePriorityQueue = new PriorityQueue<>(Comparator.comparing(genre -> -genre.playTime));
        HashMap<String,PriorityQueue<Music>>    musicSaveQueue     = new HashMap<>();
        HashMap<String,Integer>                 genreRecording     = new HashMap<>();
        PriorityQueue<Music>                    currentQueue;
        int                                     cnt                = genres.length;

        for(int i = 0; i<cnt; i++){
            // 저장된 이력이 존재
            String current_genre = genres[i];
            int    current_time  = plays[i];

            // ** 이미 저장된 경우
            if( genreRecording.containsKey(current_genre) ){
                genreRecording.put(current_genre,genreRecording.get(current_genre)+current_time);
                currentQueue = musicSaveQueue.get(current_genre);
                currentQueue.offer(new Music(i,current_time));
            }
            else {
                PriorityQueue<Music>            musicGenrePriority = new PriorityQueue<>(Comparator.comparing(music -> -music.time));
                                                musicGenrePriority.offer(new Music(i,current_time));
                genreRecording.put(current_genre,current_time);
                musicSaveQueue.put(current_genre,musicGenrePriority);
            }
        }


        for(String key : genreRecording.keySet()){
            genrePriorityQueue.offer(new Genre(key,genreRecording.get(key)));
        }

        ArrayList<Integer> answerArrayList = new ArrayList<>();

        while( !genrePriorityQueue.isEmpty() ){
            Genre genre  = genrePriorityQueue.poll();
            currentQueue = musicSaveQueue.get(genre.genre);
            int index = 0;
            while(!currentQueue.isEmpty()){
                index++;
                answerArrayList.add(currentQueue.poll().index);
                if(index == 2){
                    break;
                }
            }
        }

        int[] answer = new int[answerArrayList.size()];

        for(int i = 0 ; i<answerArrayList.size(); i++){
            answer[i] = answerArrayList.get(i);
            System.out.println(answerArrayList.get(i));
        }

        return answer;
    }

}
