package algo20200926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	static int N;
	static int M;
	static int[][] map;
	static int r;
	static int c;
	static int d;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		while (true) {
			// 청소하기
			
				
			visited[r][c] = true;
			cnt++;
			
			boolean check = true;
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				
				if (map[nr][nc] == 0 && !visited[nr][nc]) {
					check = false;
					break;
				}
			}
			
			if(check) {
				int nr = r - dir[d][0];
				int nc = c - dir[d][1];
				if(map[nr][nc]==1) {
					break;
				}else {
					r = nr;
					c = nc;
				}
			}
			
			// 현재방향 기준으로 왼쪽 회전
			if (d == 0) {
				d = 3;
			} else {
				d--;
			}

			if(d==0) {
				for (int cur = 0; cur < r; cur++) {
					if(map[cur][c] ==0 && !visited[cur][c]) {
						r++;
						break;
					}
				}
			}else if(d==1) {
				for (int cur = c; cur < M; cur++) {
					if(map[r][cur] ==0 && !visited[r][cur]) {
						c++;
						break;
					}
				}
				
			}else if(d==2) {
				for (int cur = r; cur < N; cur++) {
					if(map[cur][c] ==0 && !visited[cur][c]) {
						r--;
						break;
					}
				}
			}else {
				for (int cur = 0; cur < c; cur++) {
					if(map[r][cur] ==0 && !visited[r][cur]) {
						r = r +dir[d][0];
						c = c +dir[d][1];
						break;
					}
				}
			}
			
		}

		System.out.println(cnt);
	}

}
