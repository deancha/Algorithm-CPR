package algo20201223;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution_단속카메라 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}}));
	}
	
	static public int solution(int[][] routes) {
        int answer = 1;
        List<int []> list = new LinkedList<int[]>();
        
        for (int i = 0; i < routes.length; i++) {
			list.add(new int[] {routes[i][0],routes[i][1]});
		}
        
        Collections.sort(list, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
        
        int curMax = list.get(0)[1];
        
        for (int i = 0; i < list.size(); i++) {
			if(curMax < list.get(i)[0]) {
				curMax = list.get(i)[1];
				answer++;
			}
			
		}
        return answer;
    }

}
