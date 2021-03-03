package algo20201221;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution_두개뽑아서더하기 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2,1,3,4,1}));
		System.out.println(solution(new int[] {5,0,2,7}));
		
	}
	static public int[] solution(int[] numbers) {
        int[] answer;
        int len = numbers.length;
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < len-1; i++) {
        	for (int j = i+1; j < len; j++) {
				set.add(numbers[i]+numbers[j]);
			}
		}
        
        answer = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        int idx = 0;
        while(iter.hasNext()) {
        	answer[idx++] = iter.next(); 
        }
        return answer;
        
    }

}
