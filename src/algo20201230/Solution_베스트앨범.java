package algo20201230;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution_베스트앨범 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500})));
	}
	
	static public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Music> list = new ArrayList<Music>();
        Map<String, Integer> tmap = new TreeMap<>();
        int len = genres.length;
        for (int i = 0; i < len; i++) {
			list.add(new Music(i, genres[i], plays[i]));
			if(tmap.containsKey(genres[i])){
				tmap.put(genres[i], tmap.get(genres[i])+plays[i]);
			}else {
				tmap.put(genres[i], plays[i]);
			}
		}
        
        
        Collections.sort(list);
        return answer;
    }
	
	static class Music implements Comparable<Music>{
		int id;
		String genre;
		int count;
		
		public Music(int id, String genre, int count) {
			super();
			this.id = id;
			this.genre = genre;
			this.count = count;
		}

		@Override
		public int compareTo(Music o) {
			if(this.count == o.count) {
				return Integer.compare(this.id, o.id);
			}else {
				return -Integer.compare(this.count, o.count);
			}
		}
		
		
	}
}
