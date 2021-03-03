package algo20200919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	static int N;
	static int M;
	static int r;
	static int c;
	static int map[][];
	static int[] dice;
	static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dice = new int[6];
		/*
		 * 0 : 앞면
		 * 1 : 윗면
		 * 2 : 오른면
		 * 3 : 왼면
		 * 4 : 아랫면
		 * 5 : 뒷면
		 * 
		 */
		
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < k; i++) {
			int d = Integer.parseInt(st.nextToken())-1;
			rollDice(d);
		}
		
		System.out.println(sb.toString());
	}
	private static void rollDice(int d) {
		int nr = r + dir[d][0];
		int nc = c + dir[d][1];
		
		// 범위 넘어가면 return 
		if(nr<0 || nr>=N || nc<0 ||nc>=M) return;
		
		int tempFront = dice[0];
		int tempBack = dice[5];
		int tempTop = dice[1];
		int tempBottom = dice[4];
		int tempLeft = dice[3];
		int tempRight = dice[2];
		
		r = nr;
		c = nc;
		if(d==0) {
			dice[1] = tempLeft;
			dice[2] = tempTop;
			dice[4] = tempRight;
			dice[3] = tempBottom;
		}else if(d==1) {
			dice[3] = tempTop;
			dice[4] = tempLeft;
			dice[2] = tempBottom;
			dice[1] = tempRight;
					
					
					
		}else if(d==2) {
			dice[5] = tempTop;
			dice[4] = tempBack;
			dice[0] = tempBottom;
			dice[1] = tempFront;
					
		}else {
			dice[0] = tempTop;
			dice[4] = tempFront;
			dice[5] = tempBottom;
			dice[1] = tempBack;
		}
		
		
		if(map[nr][nc]==0) {
			map[nr][nc] = dice[4];
		}else {
			dice[4] = map[nr][nc];
			map[nr][nc] = 0;
		}
		//주사위 윗면 출력
		sb.append(dice[1] + "\n");
		
	}

}
