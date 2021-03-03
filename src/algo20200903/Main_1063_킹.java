package algo20200903;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063_킹 {
	
	static String rows = "87654321";
	static String cols = "ABCDEFGH";
	
	/*
	 * R : 0
	 * L : 1
	 * B : 2
	 * T : 3
	 * RT : 4
	 * LT : 5
	 * RB : 6
	 * LB : 7
	 */
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		String kingLoc = st.nextToken();	//왕의위치
		String dollLoc = st.nextToken();	//돌의위치
		int moveN = Integer.parseInt(st.nextToken());
		
		int dollR =0;	//돌 행좌표 - row
		int dollC =0 ;	//돌 열좌표 - col
		int kingR =0;	
		int kingC =0;
		for (int i = 0; i < 8; i++) {
			if(kingLoc.charAt(0) == cols.charAt(i)) {
				kingC = i;
			}
			if(dollLoc.charAt(0) == cols.charAt(i)) {
				dollC = i;
			}
			if(kingLoc.charAt(1) == rows.charAt(i)) {
				kingR = i;
			}
			if(dollLoc.charAt(1) == rows.charAt(i)) {
				dollR = i;
			}
		}
		
		int map[][] = new int[8][8];
		map[kingR][kingC] = 1;
		map[dollR][dollC] = 2;
		
		for (int i = 0; i < moveN; i++) {
			String inst = in.readLine();	//명령어
			int d = 0;
			switch (inst) {
			case "R":
				d = 0;
				break;
			case "L":
				d = 1;
				break;
			case "B":
				d = 2;
				break;
			case "T":
				d = 3;
				break;
			case "RT":
				d = 4;
				break;
			case "LT":
				d = 5;
				break;
			case "RB":
				d = 6;
				break;
			case "LB":
				d = 7;
				break;
			}
			
			int nr = kingR + dir[d][0];
			int nc = kingC + dir[d][1];
			
			if(nr<0 || nr>=8 || nc<0 || nc>=8) {
				continue;
			}
			
			int nnr = 0;
			int nnc = 0;
			if(nr == dollR && nc == dollC) {
				nnr  = dollR + dir[d][0];
				nnc = dollC + dir[d][1];
				if(nnr<0 || nnr>=8 || nnc<0 || nnc>=8) {
					continue;
				}
				dollR = nnr;
				dollC = nnc;
			}
			
			
			kingR = nr;
			kingC = nc;
			
			map[kingR][kingC] = 1;
			map[dollC][dollC] = 2;
		}
		
		String kingLastLoc = "" + cols.charAt(kingC) + rows.charAt(kingR);
		String dollLastLoc = "" + cols.charAt(dollC) + rows.charAt(dollR);
		
		System.out.println(kingLastLoc);
		System.out.println(dollLastLoc);
		
	}

}
