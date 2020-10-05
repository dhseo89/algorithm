import java.util.Scanner;

public class Main {

	static int N,M,K;
	static int[][] map;
	static int[] d;
	static int MIN = 30000;
	static int start;
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		start = sc.nextInt();
		d = new int[N+1];
		visited = new boolean[N+1];
		map = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				int val = MIN;
				if(i == j) val = 0;
				map[i][j] = val;
			}
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			map[a][b] =c;
		}
		dijkstra(start);
		print();
	}
	
	
	private static void dijkstra(int start) {
		visited[start] = true;
		for (int i = 1; i < N+1; i++) {
			d[i] = map[start][i];
		}
		for (int i = 1; i < N+1; i++) {
			int idx = getMinIdx();
			visited[idx] = true;
			for (int j = 1; j < N+1; j++) {
				if(!visited[j]) {
					if(d[idx]+map[idx][j]<d[j]) d[j] = d[idx]+map[idx][j];
				}
			}
		}
	}
	
	private static int getMinIdx() {
		int minVal = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 1; i < N+1; i++) {
			if(map[start][i]<minVal && !visited[i]) {
				minVal = map[start][i];
				index = i;
			}
		}
		return index;
	}


	private static void print() {
		for (int i = 1; i < d.length; i++) {
			if(d[i] == MIN) {
				System.out.println("INF");
			}
			else {
				System.out.println(d[i]);
			}
		}
	}
}
