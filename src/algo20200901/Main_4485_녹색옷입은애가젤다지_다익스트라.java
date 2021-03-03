package algo20200901;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지_다익스트라 {
	
	static int N;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static final int MAX_VALUE = 987654321;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int index = 1;
		
		while(true) {
			N = Integer.parseInt(in.readLine());
			if(N==0) break;
			
			map = new int[N][N];
			visited = new boolean[N][N];
			dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = MAX_VALUE;
				}
			}
			
			// 첫지점 카운트 
			dist[0][1] = map[0][1];
			dist[1][0] = map[1][0];
			visited[0][0] = true;
			
			for (int i = 0; i < N * N -1; i++) {
				
				int minV = MAX_VALUE;
				int minR = -1;
				int minC = -1;
				
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if(!visited[r][c] && dist[r][c] < minV) {
							minV= dist[r][c];
							minR = r;
							minC = c;
						}
					}
				}
				
				visited[minR][minC] = true;
				for (int d = 0; d < 4; d++) {
					int nr = minR + dir[d][0];
					int nc = minC + dir[d][1];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
						if(dist[nr][nc] > dist[minR][minC] + map[nr][nc]) {
							dist[nr][nc] = dist[minR][minC] + map[nr][nc];
						}
					}
				}
			}
			
			
			
			sb.append("Problem " + index++ +": " + (dist[N-1][N-1] +map[0][0]));
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
