package algo20201223;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution_문자열내림차순으로배치하기 {

	public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));
	}
	
	static public String solution(String s) {
        String answer = "";
        Character[] list = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
			list[i] = s.charAt(i);
		}
        Arrays.sort(list,Collections.reverseOrder());
        for (int i = 0; i < s.length(); i++) {
			answer += list[i];
		}
        return answer;
    }
}
