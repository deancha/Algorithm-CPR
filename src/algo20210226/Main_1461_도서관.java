package algo20210226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1461_도서관 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		ArrayList<Integer> plus = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(cur>=0) {
				plus.add(cur);
			}else {
				minus.add(cur);
			}
		}
		Collections.sort(plus,Collections.reverseOrder());
		Collections.sort(minus);
		
		int ans = 0;
		//큰부분 절대값이 작은 애를 먼저 처리하자
		//양수 먼저 처리
		if(plus.size()>0) {
			for (int i = 0; i < plus.size(); i=i+M) {
				ans += plus.get(i)*2;
			}
		}

		// 음수 처리
		if(minus.size()>0) {
			for (int i = 0; i < minus.size(); i=i+M) {
				ans -= minus.get(i)*2;
			}			
		}
		
		if(plus.isEmpty()) {
			ans += minus.get(0);
		}else if(minus.isEmpty()) {
			ans -= plus.get(0);
		}else if(Math.abs(minus.get(0))>plus.get(0)) {
			ans += minus.get(0);
		}else {
			ans -= plus.get(0);
		}
		
		System.out.println(ans);
	}
}
