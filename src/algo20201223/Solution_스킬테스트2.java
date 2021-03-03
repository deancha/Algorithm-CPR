package algo20201223;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_스킬테스트2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {5, 9,7,10},5)));
		System.out.println(Arrays.toString(solution(new int[] {2, 36,1,3},1)));
		System.out.println(Arrays.toString(solution(new int[] {3,2,6},10)));
		

	}
	static public int[] solution(int[] arr, int divisor) {
        int[] answer;
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(arr);
        for (Integer v : arr) {
			if(v%divisor==0) {
				list.add(v);
			}
		}
        if(list.size()>0) {
        	answer = new int[list.size()];
        	for (int i = 0; i < list.size(); i++) {
				answer[i]=list.get(i);
			}
        }else {
        	answer = new int[1];
        	answer[0] = -1;
        	
        }
        return answer;
    }

}
