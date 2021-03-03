package algo20201022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057_마법사상어와토네이도 {
	static int N;
	static int sand[][];
	static int dirMap[][];
	static int dir1[][] = {{0,1},{1,0},{-1,0},{0,-1}};//오,아래,왼,위
	static int dir2[][] = {{0,-1},{1,0},{0,1},{-1,0}};//왼,아래,오른,위
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		sand = new int[N][N];
		dirMap = new int[N][N];
		int initSum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				sand[i][j] = Integer.parseInt(st.nextToken());
				initSum += sand[i][j];
			}
		}
		
		int curR = N/2;
		int curC = N/2;
		int cnt =1;
		int v = 0;
		int d = 0;
		top:
		while(true) {
			
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < cnt; j++) {
					dirMap[curR][curC] = v;
					curR += dir2[d][0];
					curC += dir2[d][1];
				}
				v=(v+1)%4;
				d=(d+1)%4;
				if(curR == 0 && curC==0) break top;
			}
			cnt++;
		}
		
		System.out.println();

		
		
		
	}

}
