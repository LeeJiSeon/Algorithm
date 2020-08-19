import java.util.*;
class BestAlbum {
    class Song implements Comparable<Song> {
        int id, play;
        String genre;

        Song(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            if(this.play == o.play)
                return this.id - o.id;
            else
                return o.play - this.play;
        }
    }

    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> genresMap = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();
        List<Integer> bestAlbum = new ArrayList<>();

        for(int i = 0 ; i < genres.length ; i++) {
            List<Song> songlist = songMap.getOrDefault(genres[i], new ArrayList<Song>());
            songlist.add(new Song(i, genres[i], plays[i]));
            Collections.sort(songlist, new Comparator<Song>() {
                @Override
                public int compare(Song s1, Song s2) {
                    return s1.compareTo(s2);
                }
            });
            if(songlist.size() > 2)
                songlist.remove(songlist.size()-1);
            songMap.put(genres[i], songlist);
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genreslist = new ArrayList<>(genresMap.keySet());
        Collections.sort(genreslist, (o1, o2) -> (genresMap.get(o2).compareTo(genresMap.get(o1))));
        for(String genre : genreslist) {
            List<Song> songlist = new ArrayList<>(songMap.get(genre));
            for(Song s : songlist)
                bestAlbum.add(s.id);
        }
        
        answer = new int[bestAlbum.size()];
        for(int i = 0 ; i < answer.length ; i++)
            answer[i] = bestAlbum.get(i);
        return answer;
    }
}
