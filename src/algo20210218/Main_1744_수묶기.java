package algo20210218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_1744_수묶기 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		List<Integer> plus = new ArrayList<Integer>();
		List<Integer> minus = new ArrayList<Integer>();
		List<Integer> one = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(in.readLine());
			if (cur > 1) {
				plus.add(cur);
			} else if(cur==1){
				one.add(cur);
			}else {
				minus.add(cur);
			}
		}
		Collections.sort(plus, Comparator.reverseOrder());
		Collections.sort(minus);
		// 5, 3, 2 , 1 일 때 최대값은 5*3 + 2 + 1 = 18

		// 1보다 크면 내림차순 정렬해서 위에서 두개씩 묶어 곱하고 더하면 됨
		// 0보다 작거나 같으면 오름차순 정렬해서 두개씩 묶어서 더해주면 됨
		// -5, -3, -2, 0
		int ans = 0;
		
		// 1일때는 걍 더해줘야함
		ans += one.size();
		
		for (int i = 0; i < plus.size()-1; i+=2) {
			ans += (plus.get(i) * plus.get(i+1));
		}
		if(plus.size()%2==1) {//개수가 홀수개이면 마지막꺼 더해줘야함
			ans+=plus.get(plus.size()-1);
		}
		
		for (int i = 0; i < minus.size()-1; i+=2) {
			ans += (minus.get(i) * minus.get(i+1));
		}
		if(minus.size()%2==1) {
			ans+=minus.get(minus.size()-1);
		}
		System.out.println(ans);
	}
}
