package algo20210115;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {
	static int R;
	static int C;
	static char[][] map;
	static int[][] visited;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
			Arrays.fill(visited[i], 100000);
		}
		
		ArrayDeque<int []> queue = new ArrayDeque<>();
		queue.offer(new int[] {0,0});
		visited[0][0]=0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				
				if(nr>=0 && nr <R && nc>=0 && nc<C) {
					if(map[nr][nc]=='1') {
						if(visited[nr][nc]>visited[r][c]+1) {
							queue.offer(new int[] {nr,nc});
							visited[nr][nc] = visited[r][c]+1;
						}
					}else{
						if(visited[nr][nc]>visited[r][c]) {
							queue.offer(new int[] {nr,nc});
							visited[nr][nc] = visited[r][c];
						}
					}
				}
			}
		}
		System.out.println(visited[R-1][C-1]);
	}

}
