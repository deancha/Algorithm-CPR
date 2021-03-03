package algo20201105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10026_적록색약 {
	static int N;
	static char[][] map;
	static boolean[][] checked;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		map = new char[N][N];
		checked = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		//적록색약이 아닌 사람이 봣을때
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!checked[i][j]) {
					cnt++;
					checked[i][j] = true;
					dfs(i,j,map[i][j]);
				}
			}
		}
		// 값 나온 거 저장
		sb.append(cnt).append(" ");
		//배열 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(checked[i], false);
		}
		
		//적록색약인 사람이 봤을때 - G와 R을 똑같이 봄
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!checked[i][j]) {
					cnt++;
					checked[i][j] = true;
					dfs2(i,j,map[i][j]);
				}
			}
		}
		
		sb.append(cnt);
		System.out.println(sb);
	}
	
	private static void dfs2(int r, int c, char value) {
		for (int d = 0; d < 4; d++) {
			int nr = r+dir[d][0];
			int nc = c+dir[d][1];
			
			//B이면 B만 찾아가야함
			if(value == 'B') {
				if(isIn(nr,nc)&&!checked[nr][nc] && map[nr][nc] == 'B') {
					checked[nr][nc] = true;
					dfs2(nr,nc,value);
				}
			}else {
				if(isIn(nr,nc)&&!checked[nr][nc] && map[nr][nc] != 'B') {
					checked[nr][nc] = true;
					dfs2(nr,nc,value);
				}
			}
		}
	}
	
	private static void dfs(int r, int c, char value) {	
		for (int d = 0; d < 4; d++) {
			int nr = r+dir[d][0];
			int nc = c+dir[d][1];
			if(isIn(nr,nc)&&!checked[nr][nc] && map[nr][nc]==value) {
				checked[nr][nc] = true;
				dfs(nr,nc,value);
			}
		}
	}
	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}

}
