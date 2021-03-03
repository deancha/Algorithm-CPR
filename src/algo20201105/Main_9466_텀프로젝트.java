package algo20201105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9466_텀프로젝트 {
	static int N;
	static int[] students;
	static int[] parent;
	
	public static void makeSet(int v) {
		parent[v] = -1;
	}
	
	public static int findSet(int v) {
		if(parent[v]<0) {
			return v;
		}
		return findSet(parent[v]);
	}
	
	public static void union(int u, int v) {
		int root1 = findSet(u);
		int root2 = findSet(v);
		if(root1 == root2) return;
		
		int rank1 = parent[root1];
		int rank2 = parent[root2];
		if(rank1<rank2) {
			parent[root1] += parent[root2];
			parent[root2] = root1;
		}else {
			parent[root2] += parent[root1];
			parent[root1] = root2;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			N = Integer.parseInt(in.readLine());
			students = new int[N];
			parent = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i <N; i++) {
				students[i] = Integer.parseInt(st.nextToken());
				makeSet(i);
			}
			
			for (int i = 1; i <= N; i++) {
				union(i, students[i-1]);
			}
			
			System.out.println();
			
			
		}
	}

}
