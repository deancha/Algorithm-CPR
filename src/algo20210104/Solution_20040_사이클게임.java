package algo20210104;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_20040_사이클게임 {
	static int n;
	static int m;
	static int[] parents;
	
	public static void makeSet(int v) {
		parents[v]=v;
	}
	
	public static int findSet(int v) {
		if(v==parents[v]) {
			return v;
		}
		parents[v] = findSet(parents[v]);
		return parents[v];
	}
	
	public static void union(int u, int v) {
		if(u<v) {
			parents[findSet(u)] = findSet(v);
		}else
			parents[findSet(v)] = findSet(u);
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			makeSet(i);
		}
		
		int answer = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(findSet(u)==findSet(v)) {
				answer = i+1;
				break;
			}
			union(u,v);
		}
		System.out.println(answer);
	}

}
