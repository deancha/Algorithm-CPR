package algo20210201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_1339_단어숫자 {
	static int N;
	static String[] words;
	static int maxV;
	static List<String> list;
	static Map<Character, Integer> alphaMap;
	static boolean[] visited;
	static int[] data;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		words = new String[N];
		alphaMap = new HashMap<Character, Integer>();
		
		list = new ArrayList<String>();
		
		int count = 0; 
		for (int i = 0; i < N; i++) {
			words[i] = in.readLine();
			for (int j = 0; j < words[i].length(); j++) {
				if(!alphaMap.containsKey(words[i].charAt(j))) {
					alphaMap.put(words[i].charAt(j), count++);
				}
			}
		}
		data = new int[alphaMap.size()];
		visited = new boolean[10];
		maxV = Integer.MIN_VALUE;
		dfs(0,0);
		System.out.println(maxV);
	}
	private static void dfs(int cur, int cnt) {
		if(cnt==data.length) {
			int ret = 0;
	        for (int i = 0; i < words.length; i++) {
	            int tmp = 0;
	            for (int j = 0; j < words[i].length(); j++) {
	                tmp += data[alphaMap.get(words[i].charAt(j))];
	                tmp *= 10;
	            }
	            ret += tmp / 10;
	        }
	        if (maxV < ret)
	            maxV = ret; 
			return;
		}
		for (int i = 0; i < 10; i++) {
			if(!visited[i]) {
				visited[i] = true;
				data[cnt] = i;
				dfs(i,cnt+1);
				visited[i] = false;
			}
		}
	}

}
