package algo20210210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1406_에디터 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		List<Character> list = new ArrayList<Character>();
		String str = in.readLine();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		int n = Integer.parseInt(in.readLine());
		
		int cursor = str.length();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			String inst = st.nextToken();
			if(inst.equals("P")) {
				String c = st.nextToken();
				list.add(cursor, c.charAt(0));
				cursor++;
			}else if(inst.equals("L")) {
				//커서 왼쪽으로
				if(cursor!=0) {
					cursor--;
				}
			}else if(inst.equals("D")) {
				//커서 오른쪽으로
				if(cursor!=list.size()) {
					cursor++;
				}
			}else if(inst.equals("B")) {
				//커서왼쪽문자 삭제
				if(cursor!=0) {
					list.remove(cursor-1);
					cursor--;
				}
			}
		}
		String ans = "";
		while(!list.isEmpty()) {
			ans += list.remove(0);
		}
		System.out.println(ans);
			
	}

}
