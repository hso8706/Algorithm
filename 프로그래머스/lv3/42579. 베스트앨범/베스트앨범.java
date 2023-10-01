import java.util.*;

class Song implements Comparable<Song> {
    int id;
    String genre;
    int plays;

    public Song(int id, String genre, int plays) {
        this.id = id;
        this.genre = genre;
        this.plays = plays;
    }

    @Override
    public int compareTo(Song other) {
        if (this.plays == other.plays) {
            return this.id - other.id;
        }
        return other.plays - this.plays;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalPlays = new HashMap<>();
        Map<String, PriorityQueue<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genreTotalPlays.put(genre, genreTotalPlays.getOrDefault(genre, 0) + play);

            if (!genreSongs.containsKey(genre)) {
                genreSongs.put(genre, new PriorityQueue<>());
            }
            genreSongs.get(genre).add(new Song(i, genre, play));
        }

        List<String> sortedGenres = new ArrayList<>(genreTotalPlays.keySet());
        sortedGenres.sort((g1, g2) -> genreTotalPlays.get(g2) - genreTotalPlays.get(g1));

        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            PriorityQueue<Song> songs = genreSongs.get(genre);
            for (int i = 0; i < 2 && !songs.isEmpty(); i++) {
                result.add(songs.poll().id);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution.solution(genres, plays);
        System.out.println(Arrays.toString(result)); // [4, 1, 3, 0]
    }
}
