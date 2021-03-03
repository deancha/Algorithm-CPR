package algo20201221;

import java.util.Arrays;

public class Solution_주식가격 {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(solution(new int[] {1,2,3,2,3})));
	}
	
	static public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length-1; i++) {
        	int cnt = 0;
			for (int j = i+1; j < prices.length; j++) {
				cnt++;
				if (prices[i]>prices[j]) {
					break;
				}
			}
			answer[i] = cnt;
		}
        return answer;
    }

}
