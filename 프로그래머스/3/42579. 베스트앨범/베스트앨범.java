import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 속한 노래가 많이 재생된 장르 
        // 2. 장르 내 많이 재생된 노래 
        // 3. 장르 내 재생 횟수 같으면 -> 고유 번호 낮은 노래 먼저 
        
        // 장르별 재생횟수 저장
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 장르 넣고 재생 순서 정렬
        List<String> genre = new ArrayList<>();
        for(String gen : map.keySet()) {
            genre.add(gen);
        }
        
        // 재생순서 많은대로 -> 내림차순 정렬 
        Collections.sort(genre, (o1,o2) -> map.get(o2) - map.get(o1));
            
        // 재생순서 많은 장르별로 노래 2개씩 뽑아내기 
        List<Integer> songs = new ArrayList<>();
        for(int i=0; i<genre.size(); i++) {
            String genreName = genre.get(i);
            int maxPlays = 0;
            int firstSong = -1;
            int secondSong = -1;
            
            for(int j=0; j<genres.length; j++) {
                if(genreName.equals(genres[j]) && maxPlays < plays[j]) {
                    maxPlays = plays[j];
                    firstSong = j;
                }
            }
            maxPlays = 0;
            
            for(int j=0; j<genres.length; j++) {
                if(genreName.equals(genres[j]) && maxPlays < plays[j] && j != firstSong) {
                    maxPlays = plays[j];
                    secondSong = j;
                }
            }
            
            songs.add(firstSong);
            if(secondSong != -1) songs.add(secondSong);
        }
        
        return songs.stream().mapToInt(Integer::intValue).toArray();
    }
}