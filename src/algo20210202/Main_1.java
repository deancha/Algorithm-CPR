package algo20210202;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_1 {
	static char[][] visited;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    
	public static void main(String[] args) {
		List<Integer> list1 = new LinkedList<>();
		List<Integer> list2 = new LinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		System.out.println(minCost(4, 4, 1, 0, 2, 3, list1,list2));
	}
	public static int minCost(int rows, 
            int cols, 
            int initR, 
            int initC, 
            int finalR, 
            int finalC, 
            List<Integer> costRows,
            List<Integer> costCols) {
		
		visited = new char[rows][cols];
        for(int r =0 ; r <rows;r++){
        	Arrays.fill(visited[r], Integer.MAX_VALUE);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        visited[initR][initC] = '0';
        queue.add(new int[]{initR,initC,0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            
            for(int d = 0 ; d<4; d++){
                int nr = curR + dir[d][0];
                int nc = curC + dir[d][1];
                if(nr>=0 && nr<rows && nc>=0 && nc<cols){
                    int plus = 0;
                    if(d==0){
                        plus = costRows.get(nr);
                    }else if(d==1){
                        plus = costRows.get(curR);
                    }else if(d==2){
                        plus = costCols.get(nc);
                    }else if(d==3){
                        plus = costCols.get(curC);
                    }
                    if(visited[nr][nc]-'0'>visited[curR][curC]-'0'+plus){
//                        visited[nr][nc] = visited[curR][curC]-'0'+plus;
                        queue.add(new int[]{nr,nc});
                    }
                    
                }
            }
        }
        return visited[finalR][finalC];
    }
}
