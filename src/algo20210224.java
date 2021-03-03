import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class algo20210224 {
	static char[][] map;
	static boolean[][] checked;
	static int ans;
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		checked = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		ans = 0;
		combi(0,1,0);
		
		System.out.println(ans);
	}
	private static void combi(int cur, int cnt, int cntS) {
		if(cnt==7) {
			if(cntS>=4) {
				if(isAdjacent((cur-1)/5,(cur-1)%5)){
					ans++;
				}
			}
			return;
		}
		
		for (int i = cur; i < 25; i++) {
			int r = i / 5; 
			int c = i % 5;
			// r,c가 현재 위치
			
			checked[r][c] = true;
			if(map[r][c]=='S') {
				combi(i+1,cnt+1,cntS+1);
			}else {
				combi(i+1,cnt+1,cntS);
			}
			checked[r][c] = false;
			
		}
	}
	private static boolean isAdjacent(int i, int j) {
		Queue<int []> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j});
		int cnt = 1;
		boolean visit[][] = new boolean[5][5];
		visit[i][j] = true;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				if(nr>=0 && nr<5 && nc>=0 && nc<5 && checked[nr][nc] && !visit[nr][nc]) {
					visit[nr][nc]= true;
					queue.offer(new int[] {nr,nc});
					cnt++;
				}
			}
		}
		if(cnt==7) {
			return true;
		}else {
			return false;
		}
	}

}
