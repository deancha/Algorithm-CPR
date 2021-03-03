package algo20201225;

public class Solution_가장긴팬린드롬 {

	public static void main(String[] args) {
		System.out.println(solution("abacde"));
	}

	static public int solution(String s) {
		int answer = 0;
		int len_s = s.length();
		String reverseStr = "";
		String tempStr = "";
		// 일단 뒤집어
		for (int i = s.length() - 1; i >= 0; i--) {
			reverseStr += s.charAt(i);
		}

		// 기준
//        String tempStr = reverseStr.substring(0,s);
		int cnt = 0;
		for (int i = 0; i < len_s; i++) { // 요게 하나씩 땡기는 거임
			tempStr = reverseStr.substring(0, len_s - i);
			cnt = 0;
			for (int j = 0; j < len_s - i; j++) { // 카운트해줌
				if (tempStr.charAt(j) == s.charAt(i + j)) {
					cnt++;
				} else {
					answer = Math.max(answer, cnt);
					cnt = 0;

				}
			}
			answer = Math.max(answer, cnt);
			
			tempStr = reverseStr.substring(i,len_s);
			cnt = 0;
			for (int j = 0; j < len_s-i; j++) { // 카운트해줌
				if (tempStr.charAt(j) == s.charAt(j)) {
					cnt++;
				} else {
					answer = Math.max(answer, cnt);
					cnt = 0;

				}
			}
			answer = Math.max(answer, cnt);
		}
		
		return answer;
	}

}
