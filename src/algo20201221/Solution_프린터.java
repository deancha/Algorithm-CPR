package algo20201221;

import java.util.LinkedList;

public class Solution_프린터 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 1, 3, 2 }, 2));
		System.out.println(solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
	}

	static public int solution(int[] priorities, int location) {
		int answer = 0;
		LinkedList<Printer> list = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++) {
			list.add(new Printer(priorities[i], false));	
		}
		list.get(location).target = true;
		
		
		top:
		while(!list.isEmpty()) {
			Printer cur = list.removeFirst();
			boolean isP = true;
			
			for (int i = 0; i < list.size(); i++) {
				if(cur.priority<list.get(i).priority) {
					list.addLast(cur);
					isP = false;
					break;
				}
			}
			
			if(isP) {
				answer++;
				if(cur.target == true) {
					break top;
				}
			}
		}
		return answer;
	}
	
	static class Printer{
		int priority;
		boolean target;
	
		public Printer(int priority, boolean target) {
			super();
			this.priority = priority;
			this.target = target;
		};
		
	}
}
