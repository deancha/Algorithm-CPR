package algo20201230;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_문자열내마음대로정렬하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    static public String[] solution(String[] strings, int n) {
        
    	Arrays.sort(strings);
        Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.charAt(n)-o2.charAt(n);
			}
		});
        return strings;
    }
}
