package algo20200921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2531_회전초밥 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[N];

		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(in.readLine());
		}
		
		LinkedList<Integer> list = new LinkedList<>();
		int sp = 0, cnt = 0;
		int ans = 0;
		while(true) {
			if(cnt==k) {
				
				if(checkList(list,c)) {
					ans = Math.max(ans, k);
				}else {
					ans = Math.max(ans,k+1);
				}
				cnt--;
				list.remove();
				
			}
			if(cnt<k) {
				boolean flag = false;
				if(sp>=N) break;
				for (Integer cur : list) {
					if(cur==sushi[sp]) {
						list.remove();
						
						list.add(sushi[sp++]);
						flag = true;
						break;
					}
				}
				if(!flag) {
					cnt++;

					list.add(sushi[sp]);
					sp++;					
				}
			}
		}
		System.out.println(ans);
		
	}

	private static boolean checkList(LinkedList<Integer> list, int target) {
		for (Integer cur : list) {
			if(cur==target) {
				return true;
			}
		}
		return false;
	}

}
