package algo20210129;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_20208_진우의민트초코우유 {
	static int N;	//지도 크기
	static int M;	//초기 체력
	static int H;	//체력증가
	static boolean[][] visited;
	static int maxMincho;
	static int jinwooR;
	static int jinwooC;
	static List<Mincho> minchos;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		maxMincho = -1;
		List<int []> list = new ArrayList<int[]>();
		minchos = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp==1) {
					//1이면 진우
					jinwooR = i;
					jinwooC = j;
				}else if(temp==2) {
					//2이면 민초우유
					list.add(new int[] {i,j});
				}
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			int curR = list.get(i)[0];
			int curC = list.get(i)[1];
			int dist = Math.abs(jinwooR-curR) + Math.abs(jinwooC-curC);
			minchos.add(new Mincho(curR, curC, dist));
		}
		
		Collections.sort(minchos);
		dfs(jinwooR,jinwooC,0,0,M,0);
		System.out.println(maxMincho);
	}
	


	private static void dfs(int r, int c, int cur, int distToHome, int h, int cnt) {
		// r, c : 현재위치
		// h : 현재체력
		// cnt : 민초 먹은 횟수

		//백트래킹 조건 : 일단 현재 위치에서 남은 체력으로 집까지 갈 수 잇어야함 못가면 빠꾸
		if(distToHome > h){
			return;
		}
		maxMincho = Math.max(maxMincho, cnt);
		
		for (int i = cur; i < minchos.size(); i++) {
			Mincho mincho = minchos.get(i);
			int minchoR = mincho.r;
			int minchoC = mincho.c;
			int dist = mincho.dist;
			
			int distToNext = Math.abs(minchoR-r) + Math.abs(minchoC-c);
			//앞으로 가야할 거리보다 현재체력이 더 많다면 한번 더 타줌
			if(h >= (Math.abs(minchoR-r) + Math.abs(minchoC-c))) {
				dfs(minchoR, minchoC, i+1, distToHome, h-distToNext+H, cnt+1);
			}
		}
		
	}



	static class Mincho implements Comparable<Mincho>{
		int r;
		int c;
		int dist;
		
		public Mincho(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Mincho o) {
			return Integer.compare(this.dist, o.dist);
		}
	}

}
