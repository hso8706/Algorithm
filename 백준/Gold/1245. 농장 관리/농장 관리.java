import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N,M;
	static int[][] map;
	static int[] dx = {-1,0,1,0,1,1,-1,-1};
	static int[] dy = {0,1,0,-1,1,-1,1,-1};
	static boolean isPeak;
	static boolean[][] visited;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		//입력
		input();
		//dfs
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]) {
					isPeak = true;
					dfs(i, j);
					if(isPeak) cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

	private static void dfs(int cx, int cy ) {

		visited[cx][cy] = true;
		for(int i=0; i<8; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];
			if(nx<0||ny<0||nx>=N||ny>=M) continue;
			if(map[cx][cy] < map[nx][ny])isPeak = false;
			if(!visited[nx][ny] && map[cx][cy] == map[nx][ny]) dfs(nx, ny);
		}
	}

	private static void input() throws IOException {
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}

}