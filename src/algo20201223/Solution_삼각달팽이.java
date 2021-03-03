package algo20201223;

import java.sql.Array;
import java.util.Arrays;

public class Solution_삼각달팽이 {
	
	static int[][] dir = {{1,0},{0,1},{-1,-1}};
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(4)));
		System.out.println(Arrays.toString(solution(5)));
		System.out.println(Arrays.toString(solution(6)));
	}
	
	static public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        
        int[][] map = new int[n][n];
        
        int v = 1;
        int d = 0;
        int r = 0;
        int c = 0;
        while(v<=(n*(n+1))/2) {
        	
        	map[r][c] = v++;
        	
        	int nr = r + dir[d][0];
        	int nc = c + dir[d][1];
        	if(isIn(nr,nc,n) && map[nr][nc]==0) {
        		r= nr;
        		c= nc;
        	}else {
        		d = (d+1)%3;
        		r = r + dir[d][0];
        		c = c + dir[d][1];
        	}
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				answer[idx++] = map[i][j];
			}
		}
        return answer;
    }

	private static boolean isIn(int nr, int nc,int n) {
		return nr>=0&&nc>=0&&nr<n&&nc<n;
	}
}
