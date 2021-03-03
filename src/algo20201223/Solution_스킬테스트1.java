package algo20201223;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_스킬테스트1 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 1, 3, 3, 0, 1, 1 })));
	}

	static public int[] solution(int[] arr) {
		int[] answer = {};

		List<Integer> list = new ArrayList<>();
		int len_arr = arr.length;
		list.add(arr[0]);

		for (int i = 1; i < len_arr; i++) {
			
			if (arr[i]!=arr[i-1]) {
				list.add(arr[i]);

			}
		}
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
