package algo20210101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_모의고사 {
	// 1번 1-2-3-4-5
	// 2번 2-1-2-3-2-4-2-5
	// 3번 3-3-1-1-2-2-4-4-5-5
	static int[] a1 = {1,2,3,4,5};
	static int[] a2 = {2,1,2,3,2,4,2,5};
	static int[] a3 = {3,3,1,1,2,2,4,4,5,5};
	public static void main(String[] args) {
//		System.out.println(solution(new int[] {1,2,3,4,5}));
		System.out.println(Arrays.toString(solution(new int[] {1,3,2,4,2})));
	}
	
    static public int[] solution(int[] answers) {

    	List<Student> list = new ArrayList<>();
    	list.add(new Student(1,0));
    	list.add(new Student(2,0));
    	list.add(new Student(3,0));
        for (int i = 0; i < answers.length; i++) {
        	if(a1[i%5]==answers[i]) {
        		list.get(0).cnt++;
        	}
        	if(a2[i%8]==answers[i]) {
        		list.get(1).cnt++;
        	}
        	if(a3[i%10]==answers[i]) {
        		list.get(2).cnt++;
        	}
        	
			
		}
        
        Collections.sort(list);
        int max = list.get(0).cnt;
        int cnt = 1;
        for (int i = 1; i < 3; i++) {
			if(list.get(i).cnt==max) {
				cnt++;
			}else {
				break;
			}
		}
        int[] answer = new int[cnt];
        for (int i = 0; i < cnt; i++) {
			answer[i] = list.get(i).id;
		}
        return answer;
    }
    static class Student implements Comparable<Student>{
    	int id;
    	int cnt;
    	
		public Student(int id, int cnt) {
			super();
			this.id = id;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Student o) {
			return -Integer.compare(this.cnt, o.cnt);
		}
	
    }
}
