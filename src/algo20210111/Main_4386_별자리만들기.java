package algo20210111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_4386_별자리만들기 {
	static int n;
	static int parents[];

	static void makeSet(int v) {
		parents[v] = v;
	}
	
	static int findSet(int v) {
		if(v==parents[v]) {
			return v;
		}
		parents[v] = findSet(parents[v]);
		
		return parents[v];
	}
	
	static void union(int u, int v) {
		if(u<v) {
			parents[findSet(u)] = findSet(v);
		}else {
			parents[findSet(v)] = findSet(u);
		}

	}
	
	static double calc(double d, double e, double f, double g) {
		return Math.sqrt(Math.pow(d-f, 2)+ Math.pow(e-g, 2));
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		n = Integer.parseInt(in.readLine());
		parents = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			makeSet(i);
		}
		
		LinkedList<double []> stars = new LinkedList<>();
		List<Star> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			stars.add(new double[] {a,b});
			
		}
		
		for (int i = 0; i < stars.size()-1; i++) {
			for (int j = i+1; j < stars.size(); j++) {
				list.add(new Star(i+1,j+1,calc(stars.get(i)[0], stars.get(i)[1], stars.get(j)[0], stars.get(j)[1])));
			}
		}
		Collections.sort(list);
		
		int cnt = 0;
		double sum = 0;
		for (Star star : list) {
			if(findSet(star.start) == findSet(star.end)) {
				continue;
			}
			cnt++;
			sum+=star.w;
			union(star.start, star.end);
			
			if(cnt==n-1) {
				break;
			}
		}
		System.out.println(String.format("%.2f", sum));
	}
	
	static class Star implements Comparable<Star>{
		int start;
		int end;
		double w;
		public Star(int start, int end, double w) {
			super();
			this.start = start;
			this.end = end;
			this.w = w;
		}
		@Override
		public int compareTo(Star o) {
			return Double.compare(this.w, o.w);
		}
		
		
	}

}
