package algo20201221;

import java.util.LinkedList;

public class Solution_크레인인형뽑기게임 {

	public static void main(String[] args) {
		
		System.out.println(solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}));
	}

	static public int solution(int[][] board, int[] moves) {
        int answer = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        int N = board.length;
        
        for (Integer c : moves) {
        	c-=1;
        	//큐에 넣고 board 정리하는 작업
			for (int r = 0; r < N; r++) {
				if(board[r][c]!=0) {
					queue.offer(board[r][c]);
					board[r][c] = 0;
					break;
				}
			}
			
			if(queue.size()>1) {
				if(queue.get(queue.size()-1) ==queue.get(queue.size()-2)) {
					queue.removeLast();
					queue.removeLast();
					answer+=2;

				}
			}
		}
        
        return answer;
    }

}

