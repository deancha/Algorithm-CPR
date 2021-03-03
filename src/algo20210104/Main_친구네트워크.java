package algo20210104;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_친구네트워크 {
	static Map<String, Integer> map;
	
	static int findSet(String name) {
		if(map.get(name)<0) {
			return map.get(name);
		}
		map.put(name, findSet(name));
		return map.get(name);
	}
	
	public static void union(String u, String v) {
		
		int rank1 = findSet(u);
		int rank2 = findSet(v);
		if(rank1 < rank2) {
			map.put(u, map.get(u)+map.get(v));
			map.put(v, -map.get(u));
		}else {
			map.put(v, map.get(u)+map.get(v));
			map.put(u, -map.get(v));
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			map = new HashMap<String, Integer>();
			int F = Integer.parseInt(in.readLine());
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(in.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				if(!map.containsKey(name1)) {
					map.put(name1, -1);
				}
				if(!map.containsKey(name2)) {
					map.put(name2, -1);
				}
				union(name1, name2);
				
			}
		}
	}

}
