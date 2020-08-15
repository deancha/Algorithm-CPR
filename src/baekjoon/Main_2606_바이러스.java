package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//20200815
public class Main_2606_바이러스 {
	static int N,M;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());	//컴퓨터의 수
		M = Integer.parseInt(in.readLine());	//연결된 링크의 수
		
		map = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = map[b][a] = 1;
		}
		
		dfs(0);
		
		int result = -1;
		for (int i = 0; i < N; i++) {
			if(visited[i]) {
				result++;
			}
		}
		System.out.println(result);
	}
	private static void dfs(int cur) {
		visited[cur] = true;
		
		for (int i = 0; i < N; i++) {
			if(map[cur][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

}
