package algo20201223;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution_기둥과보설치 {
	static LinkedList<Info> list;
	public static void main(String[] args) {
		int temp[][] =solution(5, new int[][]{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}});
		for (int i = 0; i < temp.length; i++) {
			System.out.println(Arrays.toString(temp[i]));
		}
		System.out.println();
		temp = solution(5, new int[][]{{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}});
		for (int i = 0; i < temp.length; i++) {
			System.out.println(Arrays.toString(temp[i]));
		}
	}
	
	static public int[][] solution(int n, int[][] build_frame) {
		
        int[][] answer = {};
        
        int len = build_frame.length;
        int c,r,a,b;
        list = new LinkedList<>();
        for (int i = 0; i < len; i++) {
			c = build_frame[i][0];
			r = build_frame[i][1];
			a = build_frame[i][2];//0:기둥, 1:보
			b = build_frame[i][3];//1:설치, 0:삭제
			
			if (b==1) {
				//설치일경우 기둥인지 보인지 체크해야함
				if(a==0) {
					//기둥일 경우
					if(r ==0 || checkOn(c,r)) {
						list.add(new Info(c,r,a));						
					}
				}else {
					if(checkOn2(c,r)) {
						list.add(new Info(c,r,a));						

					}
					//보일 경우
				}
				
			}else {
				remove(c,r,a);
				
			}
		}
        Collections.sort(list);
        answer = new int[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
			answer[i][0] = list.get(i).c;
			answer[i][1] = list.get(i).r;
			answer[i][2] = list.get(i).a;
		}
        return answer;
    }
	
	private static boolean checkOn2(int curC, int curR) {
		for (int i = 0; i < list.size(); i++) {
			int c = list.get(i).c;
			int r = list.get(i).r;
			int a = list.get(i).a;
			if(a==0) {
				//기둥인 경우
				r = r+1;
				if((curC == c ||curC+1==c) &&curR == r) {
					return true;
				}
			}else {
				//보인 경우
				if((curC == c+1||curC +1==c) &&curR == r) {
					return true;
				}
			}
			
			
		}
		return false;
	}

	private static void remove(int c, int r,int a) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).c==c && list.get(i).r==r && list.get(i).a==a) {
				list.remove(i);
				break;
			}
		}
	}

	private static boolean checkOn(int curC, int curR) {

		for (int i = 0; i < list.size(); i++) {
			int c = list.get(i).c;
			int r = list.get(i).r;
			int a = list.get(i).a;
			if(a==0) {
				//기둥인 경우
				r = r+1;
				if(curC == c &&curR == r) {
					return true;
				}
			}else {
				//보인 경우
				if((curC == c+1||curC==c) &&curR == r) {
					return true;
				}
			}
			
			
		}
		return false;
	}

	static class Info implements Comparable<Info>{
		int c;
		int r;
		int a;
		public Info(int c, int r, int a) {
			super();
			this.c = c;
			this.r = r;
			this.a = a;
		}
		
		@Override
		public int compareTo(Info o) {
			if(this.c==o.c) {
				if(this.r==o.r) {
					return Integer.compare(this.a,o.a);

				}else {
					return Integer.compare(this.r, o.r);

				}
			}else {
				return Integer.compare(this.c, o.c);				
			}
		}
	}
}
