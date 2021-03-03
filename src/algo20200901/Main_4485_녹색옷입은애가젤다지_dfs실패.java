package algo20200901;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지_dfs실패 {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static int minV;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int cnt = 0;
		while(true) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			if(N==0) break;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			minV = Integer.MAX_VALUE;
			
			visited[0][0] = true;
			
			dfs(0,0,map[0][0]);
			sb.append("Problem " + ++cnt + ": " + minV);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	private static void dfs(int r, int c, int minValue) {
		if(r== N-1 && c == N-1) {
			minV = Math.min(minV, minValue);
			return;
		}
		
		if(minValue > minV) {
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			if(isIn(nr,nc) && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr,nc, minValue + map[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
