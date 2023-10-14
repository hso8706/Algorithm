import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static boolean[] truthPeople;
//	static ArrayList<Integer> truthPeole;
	static ArrayList<Integer>[] partyPeople;
	static ArrayList<Integer>[] group;
	static int cnt;
	public static void main(String[] args) throws IOException {

		//입력
		input();
		//파티 순회
		visitParty();
		//출력
		output();
		
	}
	private static void output() {
		for(int i=0; i<M; i++) {
			boolean canLie = true;
			for(int partyPerson : partyPeople[i]) {
				if(truthPeople[partyPerson]) canLie = false;
			}
			if(canLie) cnt++;
		}
		
		System.out.println(cnt);
		
	}
	private static void visitParty() {
		for(int i=1; i<N+1; i++) {
			if(truthPeople[i]) {
				Deque<Integer> queue = new ArrayDeque<>();
				queue.offer(i);
				
				while(!queue.isEmpty()) {
					int idx = queue.poll();
					for(int n : group[idx]) {
						if(!truthPeople[n]) {
							truthPeople[n] = true;
							queue.offer(n);
						}
					}
				}
				
			}
		}
		
	}
	private static void input() throws IOException {
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		//진실을 아는 사람
		truthPeople = new boolean[N+1];
		group = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			group[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(bf.readLine());
		int end = Integer.parseInt(st.nextToken());
		for(int i=0; i<end; i++) {
			truthPeople[Integer.parseInt(st.nextToken())] = true;
		}
		
		partyPeople = new ArrayList[M];
		for(int i=0; i<M; i++) {
			partyPeople[i] = new ArrayList<>();
			st = new StringTokenizer(bf.readLine());
			end = Integer.parseInt(st.nextToken());
			for(int n=0; n<end; n++) {
				partyPeople[i].add(Integer.parseInt(st.nextToken()));
			}
			
			for(int a=0; a<partyPeople[i].size()-1; a++) {
				for(int b=a+1; b<partyPeople[i].size(); b++) {
					int s = partyPeople[i].get(a);
					int e = partyPeople[i].get(b);
					group[s].add(e);
					group[e].add(s);
				}
			}
		}
	}

}