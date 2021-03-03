package algo20201223;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution_단속카메라2 {

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
				return o1[0]-o2[0];
			}
		});
        
        int curMin = list.get(list.size()-1)[0];
        
        for (int i = list.size()-1; i >=0 ; i--) {
			if(curMin > list.get(i)[1]) {
				curMin = list.get(i)[0];
				answer++;
			}
		}
        return answer;
    }
	

}
