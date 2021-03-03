package algo20210104;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_정수내림차순으로배치하기 {

	public static void main(String[] args) {
		System.out.println(solution(118372));
	}
    static public long solution(long n) {
        String str = Long.toString(n);
        int len = str.length();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
			arr[i] = str.charAt(i) -'0';
		}
        
        Arrays.sort(arr);
        String answer ="";
        for (int i = len-1; i >=0 ; i--) {
			answer += arr[i];
		}
        
        return Long.parseLong(answer);
    }
}
