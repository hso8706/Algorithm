import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int M, N, K; //M X N, K: 직사각형 개수
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = new int[] {-1,1,0,0};
	static int[] dy = new int[] {0,0,-1,1};
	static ArrayList<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			for (int y = ly; y < ry; y++) {
				for (int x = lx; x < rx; x++) {
					board[y][x] = -1;
				}
			}
		}
//		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
		int marking = 1;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && board[i][j] != -1) {
					visited[i][j] = true;
					board[i][j] = marking;
					bfs(i, j, marking);
					marking++;
				}
			}
		}
		bw.write(marking-1 + "\n");
		for (int m = 1; m <= marking; m++) {
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(board[i][j] == m) cnt++;
				}
			}
			if(cnt!=0) result.add(cnt);
		}
		Collections.sort(result);
		for (int i = 0; i < result.size(); i++) {
			bw.write(result.get(i)+ " ");
		}
		bw.flush();
		bw.close();
	}
	private static void bfs(int i, int j, int m) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{i, j});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];
			
			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];
				if(nx<0 || ny<0 || nx>=M || ny>=N || board[nx][ny] != 0) continue;
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					board[nx][ny] = m;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
	}
}