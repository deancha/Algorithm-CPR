package algo20201230;

import java.util.HashMap;
import java.util.Map;

public class Solution_전화번호목록 {

	public static void main(String[] args) {

	}

	static public boolean solution(String[] phone_book) {
		boolean answer = true;
		Map<String, Integer> hmap = new HashMap<String, Integer>();
		for (String phone_number : phone_book) {
			for (String key : hmap.keySet()) {
				if (phone_number.length() > key.length()) {
					if (key.equals(phone_number.substring(0, key.length()))) {
						return false;
					}
				} else {
					if (phone_number.equals(key.substring(0, phone_number.length()))) {
						return false;
					}
				}
			}
			hmap.put(phone_number, 1);
		}
		return answer;
	}

}
