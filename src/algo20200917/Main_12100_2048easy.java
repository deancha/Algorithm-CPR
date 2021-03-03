package algo20200917;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100_2048easy {
	static int N;
	static int[][] map;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int d = 0; d < 4; d++) {
			dfs(0, d, map);
		}
		
		System.out.println(max);
	}

	private static void dfs(int cnt, int d, int[][] temp) {
		if(cnt>=5) {
			int m = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(temp[i][j]!=0) {
						m = Math.max(m,map[i][j]);
					}
				}
			}
			max = Math.max(m, max);
			return;
		}
		for (int i = 0; i < 4; i++) {
			
			dfs(cnt+1,i,temp);
		}
	}

}
