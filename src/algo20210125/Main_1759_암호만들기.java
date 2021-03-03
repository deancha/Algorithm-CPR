package algo20210125;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	static int L;
	static int C;
	static char[] arr;
	static boolean[] checked;
	static String checkStr = "aiueo";
	static StringBuffer sb;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		sb = new StringBuffer();
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		arr = in.readLine().replaceAll(" ", "").toCharArray();
		checked = new boolean[C];
		Arrays.sort(arr);
		dfs(0,0);
		System.out.println(sb);
	}
	private static void dfs(int cur, int cnt) {
		
		if(cnt==L) {
			boolean flag = false;
			String temp = "";
			int cntJaum = 0;
			for (int i = 0; i < C; i++) {
				if(checked[i]) {
					//체크되어있으면
					temp+=arr[i];
					if(arr[i] == 'a' ||
							arr[i] == 'i' ||
							arr[i] == 'u' ||
							arr[i] == 'e' ||
							arr[i] == 'o' ) {
						flag = true;
						
					}else {
						cntJaum ++;
					}
				}
			}
			if(flag && cntJaum>=2) {
				sb.append(temp).append("\n");
			}
			return;
		}
		
		for (int i = cur; i < C; i++) {
			checked[i] = true;
			dfs(i+1, cnt+1);
			checked[i] = false;
		}
	}

}
