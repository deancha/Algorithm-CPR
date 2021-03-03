package algo20201225;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution_기능개발 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {93,30,55}, new int[] {1,30,5})));
		System.out.println(Arrays.toString(solution(new int[] {95,90,99,99,80,99}, new int[] {1,1,1,1,1,1})));
	}
	static public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        LinkedList<Integer> cntList = new LinkedList<>();
        
        int idx =0;
        int cnt;
        int x = 0;
        
        while(idx!=progresses.length) {
        	x = (100-progresses[idx]) / speeds[idx];
        	if((100-progresses[idx]) % speeds[idx]!=0) {
        		x+=1;
        	}
        	
        	for (int i = idx; i < progresses.length; i++) {
        		progresses[i] += x*speeds[i];
        	}
        	cnt = 0;
        	for (int i = idx;i < progresses.length; i++) {
				if(progresses[i]>=100) {
					cnt++;
				}else {
					break;
				}
			}
        	cntList.add(cnt);
        	idx+=cnt;
        }

        
        answer = new int[cntList.size()];
        for (int i = 0; i < cntList.size(); i++) {
			answer[i] = cntList.get(i);
		}
        return answer;
    }
}
