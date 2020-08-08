package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * N x M 크기의 미로가 있음
 * 1 : 이동할 수 있는 칸
 * 0 : 이동할 수 없는 칸
 * 
 * (1,1) -> (N,M) 위치로 이동할 때 지나야 하는 최소의 칸 수?
 * 서로 인접한 칸으로만 이동 가능
 * 
 * 
 */
public class Main_2178_미로탐색 {
	
	static int N, M;
	static int map[][];
	static boolean visited[][];
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// =========== 입력 ================
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
	
		// =========== 풀이 ================
		//일단 1,1 지점 -> 여기서는 0,0지점을 큐에 넣음
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {0,0,1});	// 첫 좌표를 큐에 넣엇음
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			
			if(r==N-1 && c ==M-1) {
				System.out.println(cnt);
				break;
			}
			//4방탐색
			for (int d = 0; d < 4; d++) {
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				if(isin(nr,nc) && map[nr][nc]==1 &&!visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc,cnt+1});
				}
			}
			
			
		}
	
	}
	private static boolean isin(int r, int c) {

		return r>=0 && r<N && c>=0 && c<M;
	}

}
